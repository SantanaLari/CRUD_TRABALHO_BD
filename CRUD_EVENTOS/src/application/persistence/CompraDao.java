package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Caravana;
import application.model.Compra;
import application.model.Evento;
import application.model.Ingresso;

public class CompraDao implements ICompraDao {

	private Connection c;
	
	public CompraDao() throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	@Override
	public void insereCompra(Compra cp) throws SQLException {
	//	String sql = "INSERT INTO compra(codigo, nome, email, codigoCaravana) VALUES (?,?,?,?)";
		String sql = "INSERT INTO compra VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
	
		ps.setInt(1, cp.getCodigo());
		ps.setString(2, cp.getNome());
		ps.setString(3, cp.getEmail());
		ps.setInt(4, cp.getEvento().getCodigo());
		ps.setInt(5, cp.getCaravana().getCodigo());
		ps.execute();
		ps.close();
		
	}
	
	@Override
	public void atualizaCompra(Compra cp) throws SQLException {
		String sql = "UPDATE compra SET nome = ?, email = ? WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cp.getNome());
		ps.setString(2, cp.getEmail());
		ps.setInt(3, cp.getCodigo());
		ps.execute();
		ps.close();
	}
	
	@Override
	public void excluiCompra(Compra cp) throws SQLException {
		String sql = "DELETE FROM compra WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cp.getCodigo());
		ps.execute();
		ps.close();
	}
	
	//Botão visualizar compra
	@Override
	public List<Compra> listagemFiltrada() throws SQLException {
		List<Compra> listaFiltrada = new ArrayList<Compra>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT cp.nome AS nomeComprador, ");
		sql.append("ev.nome AS nomeEvento, ");
		sql.append("cv.nome AS nomeCaravana ");
		sql.append("FROM compra cp, caravana cv, evento ev ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Evento e = new Evento();
			e.setNome(rs.getString("nomeEvento"));
			
			Caravana cv = new Caravana();
			cv.setNome(rs.getString("nomeCaravana"));
			
			Compra cp = new Compra();
			cp.setNome(rs.getString("nomeComprador"));
			cp.setCaravana(cv);
			
			listaFiltrada.add(cp);
		}
		
		rs.close();
		ps.close();
		
		return listaFiltrada;
	}
	
	//botão listar/salvar
	@Override
	public List<Compra> buscaCompras() throws SQLException {
		List<Compra> listaCompra = new ArrayList<Compra>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ev.nome AS nomeEvento, ev.dia AS diaEvento, ");
		sql.append("cv.nome AS nomeCaravana, ");
		sql.append("cp.nome AS nomeComprador, cp.email AS emailComprador ");
		sql.append("FROM caravana cv, compra cp, evento ev ");
		sql.append("WHERE cp.codigoCaravana = cv.codigo ");
		sql.append("AND cp.codigoEvento = ev.codigo ");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Evento e = new Evento();
	    	e.setNome(rs.getString("nomeEvento"));
	    	e.setData(rs.getString("diaEvento"));
	    	
	    //	Ingresso i = new Ingresso();
	    //	i.setPreco(rs.getDouble("preco"));
	    //	i.setTipo(rs.getString("tipo"));
	    	
	    	Caravana cv = new Caravana();
	    	cv.setNome(rs.getString("nomeCaravana"));
	    	
	    	Compra cp = new Compra();
	    	cp.setNome(rs.getString("nomeComprador"));
	    	cp.setEmail(rs.getString("emailComprador"));
	    	cp.setCaravana(cv);
	    	
	    	listaCompra.add(cp);
		}
		
		rs.close();
		ps.close();
		
		return listaCompra;
	}
	
	//botão de opções
	public List<Compra> visualizaOpcao() throws SQLException {
		List<Compra> listaVisualizacao = new ArrayList<Compra>();
		StringBuffer sql = new StringBuffer();
	/*	sql.append("SELECT ev.codigo AS codigo_evento, ");
		sql.append("ev.nome, ev.dia, ");
		sql.append("ig.codigo, ig.preco AS preco_ingresso, ");
		sql.append("cv.codigo AS id_caravana, cv.preco AS preco_caravana");
		sql.append("CASE WHEN (ev.UF = cv.UF) ");
		sql.append("THEN ");
		sql.append("SUM(ig.preco + cv.preco)" );
		sql.append("ELSE ");
		sql.append("ig.preco ");
	    sql.append("END AS total ");
	    sql.append("FROM evento ev INNER JOIN ingresso ig ");
	    sql.append("ON ev.codigo = ig.codigoEvento ");
	    sql.append("LEFT OUTER JOIN caravana cv ");
	    sql.append("ON cv.uf = ev.uf ");
	    sql.append("GROUP BY ev.codigo, ev.nome, ev.dia, ig.codigo, ig.preco, cv.codigo, "
	    		+ "cv.preco, cv.uf, ev.uf ");
	    sql.append("ORDER BY total ASC");*/
		
		sql.append("SELECT ev.codigo AS codigoEvento, ");
		sql.append("ev.nome AS nomeEvento, ");
		sql.append("cv.codigo AS codigoCaravana, ");
		sql.append("cv.nome AS nomeCaravana ");
		sql.append("FROM evento ev, caravana cv ");
		sql.append("WHERE cv.uf = ev.uf");
	    PreparedStatement ps = c.prepareStatement(sql.toString());
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	    	Evento e = new Evento();
	    	e.setCodigo(rs.getInt("codigoEvento"));
	    	e.setNome(rs.getString("nomeEvento"));
	   
	  /*   	Ingresso i = new Ingresso();
	    	i.setCodigo(rs.getInt("codigoIngresso"));
	    	i.setPreco(rs.getDouble("precoIngresso"));
	    */
	    	Caravana cv = new Caravana();
	    	cv.setCodigo(rs.getInt("codigoCaravana"));
	    	cv.setNome(rs.getString("nomeCaravana"));
	    	
	    	Compra cp = new Compra();
	    	cp.setCaravana(cv);
	    	cp.setEvento(e);
	    	
	    	listaVisualizacao.add(cp);
	    }
	    
	    rs.close();
	    ps.close();
	    
		return listaVisualizacao;

	}
}