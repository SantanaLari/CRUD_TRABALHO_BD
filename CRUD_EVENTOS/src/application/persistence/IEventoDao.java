package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Evento;

public interface IEventoDao {
	
	public void insereEvento(Evento ev) throws SQLException; 
	public void atualizaEvento(Evento ev) throws SQLException;
	public void excluiEvento(Evento ev) throws SQLException;
//	public Evento buscaEvento(Evento ev) throws SQLException;
	public List<Evento> buscaEventos() throws SQLException;
}
