package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Ingresso;

public interface IIngressoDao {

	public void insereIngresso(Ingresso i) throws SQLException;
	public void atualizaIngresso(Ingresso i) throws SQLException;
	public void excluiIngresso(Ingresso i) throws SQLException;
	public Ingresso buscaIngresso(Ingresso i) throws SQLException;
	public List<Ingresso> buscaIngressos() throws SQLException;
}
