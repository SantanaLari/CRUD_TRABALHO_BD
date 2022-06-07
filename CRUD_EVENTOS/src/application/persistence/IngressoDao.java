package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Ingresso;

public class IngressoDao implements IIngressoDao {

	private Connection c;
	
	public IngressoDao() throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	@Override
	public void insereIngresso(Ingresso i) throws SQLException {
		String sql = "INSERT INTO ingresso VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i.getCodigo());
		//ps.setInt(2, i.getCodigoEvento().getCodigo());
		ps.setString(2, i.getTipo());
		ps.setDouble(3, i.getPreco());
	}

	@Override
	public void atualizaIngresso(Ingresso i) throws SQLException {
		String sql = "UPDATE ingresso SET codigo = ?, "
				+ "tipo = ?, preco = ? WHERE codigoEvento = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i.getCodigo());
		ps.setString(2, i.getTipo());
		ps.setDouble(3, i.getPreco());
		ps.setInt(4, i.getCodigoEvento().getCodigo());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiIngresso(Ingresso i) throws SQLException {
		String sql = "DELETE ingresso WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i.getCodigo());
		ps.execute();
		ps.close();
	}

	@Override
	public Ingresso buscaIngresso(Ingresso i) throws SQLException {
		
		return null;
	}

	@Override
	public List<Ingresso> buscaIngressos() throws SQLException {
		List<Ingresso> listaIngresso = new ArrayList<Ingresso>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM evento, ingresso ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		//	Evento e = new Evento(); deu preguiça de terminar
		}
		return null;
	}

}
