package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Evento;
import application.model.Ingresso;
import application.persistence.IngressoDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class IngressoController implements IIngressoController {

	private TextField txtCodigoEvento;
//	private TextField txtNomeEvento;
//	private TextField txtDataEvento;
//	private TextField txtHoraEvento;
//	private TextField txtRuaEvento;
//	private TextField txtNumeroEvento;
//	private TextField txtUfEvento;
	private TextField txtCodigoIngresso;
	private TextField txtTipoIngresso;
	private TextField txtPrecoIngresso;
	private TextArea taEvento;
	
	public IngressoController(TextField txtCodigoEvento,
			TextField txtCodigoIngresso, TextField txtTipoIngresso, TextField txtPrecoIngresso, TextArea taEvento) {
		this.txtCodigoEvento = txtCodigoEvento;
/*.txtNomeEvento = txtNomeEvento;
		this.txtDataEvento = txtDataEvento;
		this.txtHoraEvento = txtHoraEvento;
		this.txtRuaEvento = txtRuaEvento;
		this.txtNumeroEvento = txtNumeroEvento;
		this.txtUfEvento = txtUfEvento;*/
		this.txtCodigoIngresso = txtCodigoIngresso;
		this.txtTipoIngresso = txtTipoIngresso;
		this.txtPrecoIngresso = txtPrecoIngresso;
		this.taEvento = taEvento;
	}
	
	@Override
	public void inserirIngresso(Ingresso i) throws ClassNotFoundException, SQLException {
		IngressoDao iDao = new IngressoDao();
		iDao.insereIngresso(i);
		buscarIngressos();
	}

	@Override
	public void atualizarIngresso(Ingresso i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirIngresso(Ingresso i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarIngresso(Ingresso i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarIngressos() throws ClassNotFoundException, SQLException {
		taEvento.setText("");
		
		IngressoDao iDao = new IngressoDao();
		List<Ingresso> listaIngressos = iDao.buscaIngressos();
		StringBuffer buffer = new StringBuffer("INGRESSO");
		
		for(Ingresso i : listaIngressos) {
			buffer.append(i.getCodigo()+"\t\t"+i.getTipo()+ 
					"\t\t"+i.getPreco()+"\n");
		}
		
		taEvento.setText(buffer.toString());
		taEvento.setText(buffer.toString());
	}

}
