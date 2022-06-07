package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Compra;

public interface ICompraDao {
	
	public void insereCompra(Compra cp) throws SQLException;
	public void atualizaCompra(Compra cp) throws SQLException;
	public void excluiCompra(Compra cp) throws SQLException;
	public List<Compra> listagemFiltrada() throws SQLException;
	public List<Compra> buscaCompras() throws SQLException;
	public List<Compra> visualizaOpcao() throws SQLException;
}
