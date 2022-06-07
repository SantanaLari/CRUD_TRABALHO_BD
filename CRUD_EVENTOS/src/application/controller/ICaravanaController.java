package application.controller;

import java.sql.SQLException;

import application.model.Caravana;

public interface ICaravanaController {

	public void inserirCaravana(Caravana c) throws ClassNotFoundException, SQLException;
	public void atualizarCaravana(Caravana c) throws ClassNotFoundException, SQLException;
	public void excluirCaravana(Caravana c) throws ClassNotFoundException, SQLException;
	public void buscarCaravanas() throws ClassNotFoundException, SQLException;
	public void buscarCaravanaEvento() throws ClassNotFoundException, SQLException;
	public void buscarCaravana(Caravana c) throws ClassNotFoundException, SQLException;
}
