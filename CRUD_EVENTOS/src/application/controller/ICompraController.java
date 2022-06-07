package application.controller;

import java.sql.SQLException;

import application.model.Compra;

public interface ICompraController {

	public void inserirCompra(Compra cp) throws ClassNotFoundException, SQLException;
	public void atualizarCompra(Compra cp) throws ClassNotFoundException, SQLException;
	public void excluirCompra(Compra cp) throws ClassNotFoundException, SQLException;
	public void listaFiltrar() throws ClassNotFoundException, SQLException;
	public void buscarCompras() throws ClassNotFoundException, SQLException;
	public void visualizarOpcao() throws ClassNotFoundException, SQLException;
}
