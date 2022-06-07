package application.controller;

import java.sql.SQLException;

import application.model.Programacao;

public interface IProgramacaoController {
	
	public void inserirProgramacao(Programacao p) throws ClassNotFoundException, SQLException;
	public void atualizarProgramacao(Programacao p) throws ClassNotFoundException, SQLException;
	public void excluirProgramacao(Programacao p) throws ClassNotFoundException, SQLException;
//	public void buscarProgramacao(Programacao p) throws ClassNotFoundException, SQLException;
	public void buscarProgramacoes() throws ClassNotFoundException, SQLException;
	
}
