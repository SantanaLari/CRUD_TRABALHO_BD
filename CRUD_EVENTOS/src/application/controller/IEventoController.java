package application.controller;

import java.sql.SQLException;

import application.model.Evento;

public interface IEventoController {
	
	public void inserirEvento(Evento ev) throws ClassNotFoundException, SQLException;
	public void atualizarEvento(Evento ev) throws ClassNotFoundException, SQLException;
	public void excluirEvento(Evento ev) throws ClassNotFoundException, SQLException;
//	public void buscarEvento(Evento ev) throws ClassNotFoundException, SQLException;
	public void buscarEventos() throws ClassNotFoundException, SQLException;
	
}
