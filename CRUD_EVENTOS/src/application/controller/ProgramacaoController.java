package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Programacao;
import application.persistence.ProgramacaoDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProgramacaoController implements IProgramacaoController{

	private TextField txtCodigoProgramacao;
	private TextField txtCodigoEvento_Programacao;
	private TextField txtHorarioProgramacao;
	private TextField txtNomeProgramacao;
	private TextArea taProgramacao;
	
	public ProgramacaoController(TextField txtCodigoProgramacao, TextField txtCodigoEvento_Programacao,
			TextField txtHorarioProgramacao, TextField txtNomeProgramacao, TextArea taProgramacao) {
		this.txtCodigoProgramacao = txtCodigoProgramacao;
		this.txtCodigoEvento_Programacao = txtCodigoEvento_Programacao;
		this.txtHorarioProgramacao = txtHorarioProgramacao;
		this.txtNomeProgramacao = txtNomeProgramacao;
		this.taProgramacao = taProgramacao;
	}

	@Override
	public void inserirProgramacao(Programacao p) throws ClassNotFoundException, SQLException {
		ProgramacaoDao pDao = new ProgramacaoDao();
		pDao.insereProgramacao(p);
		limpaCamposProgramacao();
		buscarProgramacoes();
	}

	@Override
	public void atualizarProgramacao(Programacao p) throws ClassNotFoundException, SQLException {
		ProgramacaoDao pDao = new ProgramacaoDao();
		pDao.atualizaProgramacao(p);
		limpaCamposProgramacao();
		buscarProgramacoes();
	}

	@Override
	public void excluirProgramacao(Programacao p) throws ClassNotFoundException, SQLException {
		ProgramacaoDao pDao = new ProgramacaoDao();
		pDao.excluiProgramacao(p);
		limpaCamposProgramacao();
		buscarProgramacoes();
	}

	@Override
	public void buscarProgramacoes() throws ClassNotFoundException, SQLException {
		limpaCamposProgramacao();
		taProgramacao.setText("");
		
		ProgramacaoDao pDao = new ProgramacaoDao();
		List<Programacao> listaProgramacao = pDao.buscaProgramacoes();
		
		StringBuffer buffer = new StringBuffer("NomeEvento\t\tProgramacao\t\thorario");
		for (Programacao p : listaProgramacao) {
			buffer.append(p.getCodigoEvento().getNome()+"\t\t"+p.getNome()+"\t\t"+p.getHorario());
		}
		
		taProgramacao.setText(buffer.toString());
	}
	
	public void limpaCamposProgramacao() {
		txtCodigoProgramacao.setText("");
		txtCodigoEvento_Programacao.setText("");
		txtHorarioProgramacao.setText("");
		txtNomeProgramacao.setText("");
	}

}
