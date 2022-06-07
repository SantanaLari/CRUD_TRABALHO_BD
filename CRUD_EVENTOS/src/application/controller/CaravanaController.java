package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Caravana;
import application.persistence.CaravanaDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CaravanaController implements ICaravanaController {

	private TextField txtCodigoCaravana;
	private TextField txtNomeCaravana;
	private TextField txtCapacidadeCaravana;
	private TextField txtPrecoCaravana;
	private TextField txtUfCaravana;
	private TextArea taCaravana;
	
	public CaravanaController(TextField txtCodigoCaravana, TextField txtNomeCaravana, TextField txtCapacidadeCaravana,
			TextField txtPrecoCaravana, TextField txtUfCaravana, TextArea taCaravana) {
		this.txtCodigoCaravana = txtCodigoCaravana;
		this.txtNomeCaravana = txtNomeCaravana;
		this.txtCapacidadeCaravana = txtCapacidadeCaravana;
		this.txtPrecoCaravana = txtPrecoCaravana;
		this.txtUfCaravana = txtUfCaravana;
		this.taCaravana = taCaravana;
	}

	@Override
	public void inserirCaravana(Caravana c) throws ClassNotFoundException, SQLException {
		CaravanaDao cDao = new CaravanaDao();
		cDao.insereCaravana(c);
		limpaCamposCaravana();
		buscarCaravanas();
	}

	@Override
	public void atualizarCaravana(Caravana c) throws ClassNotFoundException, SQLException {
		CaravanaDao cDao = new CaravanaDao();
		cDao.atualizaCaravana(c);
		limpaCamposCaravana();
		buscarCaravanas();
	}

	@Override
	public void excluirCaravana(Caravana c) throws ClassNotFoundException, SQLException {
		CaravanaDao cDao = new CaravanaDao();
		cDao.excluiCaravana(c);
		limpaCamposCaravana();
		buscarCaravanas();
	}

	@Override
	public void buscarCaravanas() throws ClassNotFoundException, SQLException {
		limpaCamposCaravana();
		taCaravana.setText("");
		
		CaravanaDao cDao = new CaravanaDao();
		List<Caravana> listaCaravana = cDao.buscaCaravanas();
		
		StringBuffer buffer = new StringBuffer("Codigo\t\tNome\t\t\tCapacidade\t\t\tPreco\t\t\tUf\n");
		for(Caravana c : listaCaravana) {
			buffer.append(c.getCodigo()+"\t\t"+c.getNome()+"\t\t\t"+c.getCapacidade()+
					"\t\t\t\t"+c.getPreco() + "\t\t\t\t"+c.getUf()+"\n");
		}
		
		taCaravana.setText(buffer.toString());
	}

	@Override//NÃO FUNCIONA
	public void buscarCaravanaEvento() throws ClassNotFoundException, SQLException {
		limpaCamposCaravana();
		taCaravana.setText("");
		
		CaravanaDao cDao = new CaravanaDao();
		List<Caravana> listaCaravanaEvento = cDao.buscaCaravanaEvento();
		
		StringBuffer buffer = new StringBuffer("Evento\t\tCaravana\n");
		for(Caravana c : listaCaravanaEvento) {
			buffer.append(c.getEvento().getNome() +"\t\t" + c.getNome()+"\n");
		}
		
		taCaravana.setText(buffer.toString());
	}
	
	@Override
	public void buscarCaravana(Caravana c) throws ClassNotFoundException, SQLException {
		limpaCamposCaravana();
		
		CaravanaDao cDao = new CaravanaDao();
		c = cDao.buscaCaravana(c);
		
		txtCodigoCaravana.setText(String.valueOf(c.getCodigo()));
		txtNomeCaravana.setText(c.getNome());
		txtCapacidadeCaravana.setText(String.valueOf(c.getCapacidade()));
		txtPrecoCaravana.setText(String.valueOf(c.getPreco()));
		txtUfCaravana.setText(c.getUf());
	}

	private void limpaCamposCaravana() {
		txtCodigoCaravana.setText("");
		txtNomeCaravana.setText("");
		txtCapacidadeCaravana.setText("");
		txtPrecoCaravana.setText("");
		txtUfCaravana.setText("");
	}
}
