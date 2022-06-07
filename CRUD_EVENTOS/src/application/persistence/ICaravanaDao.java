package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Caravana;

public interface ICaravanaDao {
	
	public void insereCaravana(Caravana c) throws SQLException;
	public void atualizaCaravana(Caravana c) throws SQLException;
	public void excluiCaravana(Caravana c) throws SQLException;
	public List<Caravana>buscaCaravanas() throws SQLException;
	public List<Caravana>buscaCaravanaEvento() throws SQLException;
	public Caravana buscaCaravana(Caravana c) throws SQLException;
}
