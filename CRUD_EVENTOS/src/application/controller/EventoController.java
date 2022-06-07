package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Evento;
import application.persistence.EventoDao;
import application.persistence.IngressoDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EventoController implements IEventoController {
	
	private TextField txtCodigoEvento;
	private TextField txtNomeEvento;
	private TextField txtDataEvento;
	private TextField txtHoraEvento;
	private TextField txtRuaEvento;
	private TextField txtNumeroEvento;
	private TextField txtUfEvento;
	private TextField txtCodigoIngresso;
	private TextField txtTipoIngresso;
	private TextField txtPrecoIngresso;
	private TextArea taEvento;
	
	public EventoController(TextField txtCodigoEvento, TextField txtNomeEvento, TextField txtDataEvento,
			TextField txtHoraEvento, TextField txtRuaEvento, TextField txtNumeroEvento, TextField txtUfEvento,
			TextArea taEvento) {
		this.txtCodigoEvento = txtCodigoEvento;
		this.txtNomeEvento = txtNomeEvento;
		this.txtDataEvento = txtDataEvento;
		this.txtHoraEvento = txtHoraEvento;
		this.txtRuaEvento = txtRuaEvento;
		this.txtNumeroEvento = txtNumeroEvento;
		this.txtUfEvento = txtUfEvento;
		this.txtCodigoIngresso = txtCodigoIngresso;
		this.txtTipoIngresso = txtTipoIngresso;
		this.txtPrecoIngresso = txtPrecoIngresso;
		this.taEvento = taEvento;
	}

	@Override
	public void inserirEvento(Evento ev) throws ClassNotFoundException, SQLException {
		EventoDao eDao = new EventoDao();
		eDao.insereEvento(ev);
		limpaCamposEvento();
		buscarEventos();
	}

	@Override
	public void atualizarEvento(Evento ev) throws ClassNotFoundException, SQLException {
		EventoDao eDao = new EventoDao();
		eDao.atualizaEvento(ev);
		limpaCamposEvento();
		buscarEventos();
	}

	@Override
	public void excluirEvento(Evento ev) throws ClassNotFoundException, SQLException {
		EventoDao eDao = new EventoDao();
		eDao.excluiEvento(ev);
		limpaCamposEvento();
		buscarEventos();
	}

	@Override
	public void buscarEventos() throws ClassNotFoundException, SQLException {
		limpaCamposEvento();
		taEvento.setText("");
		
		EventoDao eDao = new EventoDao();
		List<Evento> listaEventos = eDao.buscaEventos();
		
		StringBuffer buffer = new StringBuffer("Codigo\tNome\t\tData\t\t\tHora\t\tRua"
				+ "\t\tNumero\tUF\tCodigoIngresso\tTipo\t\tPreco\n");
	/*	for(Evento ev : listaEventos) {
			buffer.append(ev.getCodigo()+"\t"+ev.getNome()+ 
					"\t\t"+ev.getData()+"\t"+ev.getHora()+"\t"+ev.getRua()+
					"\t\t"+ev.getNumero()+"\t"+ev.getUf()+"\t"+
					ev.getIngresso().getCodigo()+ "\t"+ ev.getIngresso().getTipo()+ 
					"\t"+ev.getIngresso().getPreco());
		}*/
		
		for(Evento ev : listaEventos) {
			buffer.append(ev.getCodigo()+"\t\t"+ev.getNome()+ 
					"\t\t"+ev.getData()+"\t"+ev.getHora()+"\t"+ev.getRua()+
					"\t\t"+ev.getNumero()+"\t\t"+ev.getUf()+"\n");
		}
		
		taEvento.setText(buffer.toString());
	}
	
	private void limpaCamposEvento() {
		txtCodigoEvento.setText("");
		txtNomeEvento.setText("");
		txtDataEvento.setText("");
		txtHoraEvento.setText("");
		txtRuaEvento.setText("");
		txtNumeroEvento.setText("");
		txtUfEvento.setText("");
	//	txtCodigoIngresso.setText("");
	//	txtTipoIngresso.setText("");
	//	txtPrecoIngresso.setText("");
	}

}
