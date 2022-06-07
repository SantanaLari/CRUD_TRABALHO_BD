package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Compra;
import application.persistence.CompraDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CompraController implements ICompraController {

	private TextField txtCodigoCompra;
	private TextField txtNomeComprador;
	private TextField txtEmailCompra;
	private TextField txtCodigoEvento_compra;
	private TextField txtCodigoIngresso_compra;
	private TextField txtCodigoCaravana_compra;
	private TextArea taCompra;
	
	public CompraController(TextField txtCodigoCompra, TextField txtNomeComprador, TextField txtEmailCompra,
			TextField txtCodigoEvento_compra, /*TextField txtCodigoIngresso_compra,*/ TextField txtCodigoCaravana_compra,
			TextArea taCompra) {
		this.txtCodigoCompra = txtCodigoCompra;
		this.txtNomeComprador = txtNomeComprador;
		this.txtEmailCompra = txtEmailCompra;
		this.txtCodigoEvento_compra = txtCodigoEvento_compra;
//		this.txtCodigoIngresso_compra = txtCodigoIngresso_compra;
		this.txtCodigoCaravana_compra = txtCodigoCaravana_compra;
		this.taCompra = taCompra;
	}

	@Override
	public void inserirCompra(Compra cp) throws ClassNotFoundException, SQLException {
		CompraDao cpDao = new CompraDao();
		cpDao.insereCompra(cp);
		limpaCamposCompra();
		buscarCompras();
	}

	@Override
	public void atualizarCompra(Compra cp) throws ClassNotFoundException, SQLException {
		CompraDao cpDao = new CompraDao();
		cpDao.atualizaCompra(cp);
		limpaCamposCompra();
		buscarCompras();
	}

	@Override
	public void excluirCompra(Compra cp) throws ClassNotFoundException, SQLException {
		CompraDao cpDao = new CompraDao();
		cpDao.excluiCompra(cp);
		limpaCamposCompra();
		buscarCompras();
	}

	//botão visualizar compra
	@Override
	public void listaFiltrar() throws ClassNotFoundException, SQLException {
		limpaCamposCompra();
		taCompra.setText("");
		
		CompraDao cDao = new CompraDao();
		List<Compra> listaFiltragem = cDao.listagemFiltrada();
		
		StringBuffer buffer = new StringBuffer("Comprador\t\t\tCaravana\n");
		for(Compra cp : listaFiltragem) {
			//buffer.append(cp.getNome() +"\t\t\t" + cp.getCaravana().getNome());
			buffer.append(cp.getNome() + "\t\t " +cp.getCaravana().getNome()+"\n");
			
		}
		taCompra.setText(buffer.toString());
	}

	//botão salvar/listar
	@Override
	public void buscarCompras() throws ClassNotFoundException, SQLException {
		limpaCamposCompra();
		taCompra.setText("");
		
		CompraDao cDao = new CompraDao();
		List<Compra> buscaCompleta = cDao.buscaCompras();
		
		//StringBuffer buffer = new StringBuffer("Caravana\t\tPreco\tCodigoCompra\tCliente\t\temail\n");
		StringBuffer buffer = new StringBuffer("Caravana\n");
		
		for(Compra cp : buscaCompleta) {
		//	buffer.append(cp.getCodigo() + "\t" +cp.getNome() + "\t\t" + cp.getEmail()+"\n");
		//	buffer.append(cp.getCaravana().getCodigo()+"\t"+cp.getCaravana().getNome() + "\t" + cp.getCaravana().getPreco() + "\t" + cp.getCodigo() + "\t" +cp.getNome() + "\t\t" + cp.getEmail()+"\n");
			buffer.append(cp.getCaravana().getNome() + "\t\t" + cp.getCodigo()+"\n");
		}
		taCompra.setText(buffer.toString());

	}
	
	@Override
	public void visualizarOpcao() throws ClassNotFoundException, SQLException {
		limpaCamposCompra();
		taCompra.setText("");
		
		CompraDao cDao = new CompraDao();
		List<Compra> listaFiltragem = cDao.visualizaOpcao();
		
		StringBuffer buffer = new StringBuffer("Codigo\t\t\tCaravana\t\t\tCodigo\t\tEvento\n");
		for(Compra cp : listaFiltragem) {
			buffer.append(cp.getCaravana().getCodigo() + "\t\t\t\t" + cp.getCaravana().getNome()+ "\t\t" + cp.getEvento().getCodigo()
		+ "\t\t" + cp.getEvento().getNome() + "\n");
		}
		
		taCompra.setText(buffer.toString());
	}
	
	public void limpaCamposCompra() throws ClassNotFoundException, SQLException {
		txtCodigoCompra.setText("");
		txtNomeComprador.setText("");
		txtEmailCompra.setText("");
     	txtCodigoEvento_compra.setText("");
//		txtCodigoIngresso_compra.setText("");
		txtCodigoCaravana_compra.setText("");
	}

}
