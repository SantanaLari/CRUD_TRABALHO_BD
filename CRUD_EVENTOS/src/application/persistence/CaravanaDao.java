package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Caravana;
import application.model.Evento;

public class CaravanaDao implements ICaravanaDao{
	
	private Connection con;

	public CaravanaDao() throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		con = gDao.getConnection();
	}
	
	@Override
	public void insereCaravana(Caravana c) throws SQLException {
		String sql = "INSERT INTO caravana VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getCodigo());
		ps.setString(2, c.getNome());
		ps.setInt(3, c.getCapacidade());
		ps.setDouble(4, c.getPreco());
		ps.setString(5, c.getUf());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaCaravana(Caravana c) throws SQLException {
		String sql = "UPDATE caravana SET nome = ?, capacidade = ?, "
				+ "preco = ?, uf = ? WHERE codigo = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getNome());
		ps.setInt(2, c.getCapacidade());
		ps.setDouble(3, c.getPreco());
		ps.setString(4, c.getUf());
		ps.setInt(5, c.getCodigo());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiCaravana(Caravana c) throws SQLException {
		String sql = "DELETE FROM caravana WHERE codigo = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getCodigo());
		
		ps.execute();
		ps.close();	
	}

	//botão listar
	@Override
	public List<Caravana> buscaCaravanas() throws SQLException {
		List<Caravana> listaCaravana = new ArrayList<Caravana>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM caravana");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Caravana c = new Caravana();
			c.setCodigo(rs.getInt("codigo"));
			c.setNome(rs.getString("nome"));
			c.setCapacidade(rs.getInt("capacidade"));
			c.setPreco(rs.getDouble("preco"));
			c.setUf(rs.getString("uf"));
		
			listaCaravana.add(c);
		}
		
		rs.close();
		ps.close();
		
		return listaCaravana;
	}

	//botão visualizar caravanas e eventos
	@Override
	public List<Caravana> buscaCaravanaEvento() throws SQLException {
		List<Caravana> listaCaravana = new ArrayList<Caravana>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ev.nome AS nomeEvento, ");
		sql.append("cv.nome AS nomeCaravana ");
		sql.append("FROM evento ev, caravana cv ");
		sql.append("WHERE cv.uf = ev.uf");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Evento ev = new Evento();
			ev.setNome(rs.getString("nomeEvento"));
			
			Caravana c = new Caravana();
			c.setNome(rs.getString("nomeCaravana"));
			c.setEvento(ev);
			
			listaCaravana.add(c);
		}
		
		rs.close();
		ps.close();
		
		return listaCaravana;
	}

	//botão buscar
	public Caravana buscaCaravana(Caravana c) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codigo, nome, capacidade, preco, uf ");
		sql.append("FROM caravana ");
		sql.append("WHERE codigo = ?");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setInt(1, c.getCodigo());
		ResultSet rs = ps.executeQuery();
		int cont = 0;
		if(rs.next()) {
			c.setNome(rs.getString("nome"));
			c.setCapacidade(rs.getInt("capacidade"));
			c.setPreco(rs.getDouble("preco"));
			c.setUf(rs.getString("uf"));
			cont++;
		}
		
		if(cont == 0) {
			c = new Caravana();
		}
		
		rs.close();
		ps.close();
	
		return c;
	}
}
