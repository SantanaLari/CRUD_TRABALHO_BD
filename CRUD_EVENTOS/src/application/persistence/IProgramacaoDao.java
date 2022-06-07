package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Programacao;

public interface IProgramacaoDao {
	public void insereProgramacao(Programacao p) throws SQLException;
	public void atualizaProgramacao(Programacao p) throws SQLException;
	public void excluiProgramacao(Programacao p) throws SQLException;
//	public Programacao buscaProgramacao(Programacao p) throws SQLException;
	public List<Programacao> buscaProgramacoes() throws SQLException;
}
