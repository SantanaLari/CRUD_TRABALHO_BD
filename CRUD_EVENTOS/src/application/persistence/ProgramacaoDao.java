package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Evento;
import application.model.Programacao;

public class ProgramacaoDao implements IProgramacaoDao {

	private Connection c;
	
	public ProgramacaoDao() throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	@Override
	public void insereProgramacao(Programacao p) throws SQLException {
		String sql = "INSERT INTO programacao VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		ps.setInt(2, p.getCodigoEvento().getCodigo());
		ps.setString(3, p.getHorario());
		ps.setString(4, p.getNome());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaProgramacao(Programacao p) throws SQLException {
		String sql = "UPDATE programacao SET codigoEvento = ?, "
				+ "horario = ?, nome = ? WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigoEvento().getCodigo());
		ps.setString(2, p.getHorario());
		ps.setString(3, p.getNome());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiProgramacao(Programacao p) throws SQLException {
		String sql = "DELETE FROM programacao WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		ps.execute();
		ps.close();
	}


	@Override
	public List<Programacao> buscaProgramacoes() throws SQLException {
		List<Programacao> listaProgramacao = new ArrayList<Programacao>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ev.nome AS nomeEvento, ");
		sql.append("pg.nome AS nomeProgramacao, ");
		sql.append("pg.horario AS programacaoHorario ");
		sql.append("FROM evento ev, programacao pg ");
		sql.append("WHERE ev.codigo = pg.codigoEvento ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Evento e = new Evento();
			e.setNome(rs.getString("nomeEvento"));
			
			Programacao pg = new Programacao();
			pg.setNome(rs.getString("nomeProgramacao"));
			pg.setHorario(rs.getString("programacaoHorario"));
			pg.setEvento(e);
			
			listaProgramacao.add(pg);
		}
		rs.close();
		ps.close();
		
		return listaProgramacao;
	}

}
