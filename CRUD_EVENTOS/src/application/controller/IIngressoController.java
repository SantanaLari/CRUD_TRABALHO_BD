package application.controller;

import java.sql.SQLException;

import application.model.Ingresso;

public interface IIngressoController {
	
//nao sei se essa classe é necessaria
	public void inserirIngresso(Ingresso i) throws ClassNotFoundException, SQLException;
	public void atualizarIngresso(Ingresso i) throws ClassNotFoundException, SQLException;
	public void excluirIngresso(Ingresso i) throws ClassNotFoundException, SQLException;
	public void buscarIngresso(Ingresso i) throws ClassNotFoundException, SQLException;
	public void buscarIngressos() throws ClassNotFoundException, SQLException;
	
}
