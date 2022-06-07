package application.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Evento;
import application.model.Ingresso;

public class EventoDao implements IEventoDao {

	private Connection c;
	
	public EventoDao() throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	@Override
	public void insereEvento(Evento ev) throws SQLException {
		String sql = "INSERT INTO evento VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, ev.getCodigo());
		ps.setString(2, ev.getNome());
		ps.setString(3, ev.getData());
		ps.setString(4, ev.getHora());
		ps.setString(5, ev.getRua());
		ps.setInt(6, ev.getNumero());
		ps.setString(7, ev.getUf());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaEvento(Evento ev) throws SQLException {
		String sql = "UPDATE evento SET nome = ?, data = ?, hora = ?, "
				+ "rua = ?, numero = ?, uf = ? WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, ev.getNome());
		ps.setString(2, ev.getData());
		ps.setString(3, ev.getHora());
		ps.setString(4, ev.getRua());
		ps.setInt(5, ev.getNumero());
		ps.setString(6, ev.getUf());
		ps.setInt(7, ev.getCodigo());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiEvento(Evento ev) throws SQLException {
		String sql = "DELETE FROM evento WHERE codigo = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, ev.getCodigo());
		
		ps.execute();
		ps.close();
	}

	@Override
	public List<Evento> buscaEventos() throws SQLException {
		List<Evento> listaEvento = new ArrayList<Evento>();
		StringBuffer sql = new StringBuffer();
	/*	sql.append("SELECT ev.codigo AS codigo_evento, "
				 + "ev.nome, ev.dia, ev.hora, ev.rua, ev.numero, ev.uf, "
				 + "ig.codigo, ig.tipo, ig.preco");
		sql.append("FROM evento ev, ingresso ig ");
		sql.append("WHERE ev.codigo = ig.codigoEvento ");*/
		
		sql.append("SELECT * FROM evento ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) { //daqui pra baixo eu boiei
			Evento ev = new Evento();
			ev.setCodigo(rs.getInt("codigo"));
			ev.setNome(rs.getString("nome"));
			ev.setData(rs.getString("data"));
			ev.setHora(rs.getString("hora"));
			ev.setRua(rs.getString("rua"));
			ev.setNumero(rs.getInt("numero"));
			ev.setUf(rs.getString("uf"));
			
			Ingresso i = new Ingresso();
			i.setCodigo(rs.getInt("codigo"));
		//	i.setTipo(rs.getString("tipo"));
		//	i.setPreco(rs.getDouble("preco"));
			i.setCodigoEvento(ev);
			
			listaEvento.add(ev);
		}
		
		rs.close();
		ps.close();
		
		return listaEvento;
	}
	
}
