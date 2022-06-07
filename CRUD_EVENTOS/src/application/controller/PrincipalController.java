package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import application.model.Caravana;
import application.model.Compra;
import application.model.Evento;
import application.model.Ingresso;
import application.model.Programacao;
import javafx.event.ActionEvent;

import javafx.scene.control.ScrollPane;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

public class PrincipalController {
	@FXML
	private Button btnSalvarEvento;
	@FXML
	private TextField txtCodigoEvento;
	@FXML
	private TextArea taEvento;
	@FXML
	private TextField txtHoraEvento;
	@FXML
	private TextField txtNumeroEvento;
	@FXML
	private TextField txtRuaEvento;
	@FXML
	private TextField txtDataEvento;
	@FXML
	private TextField txtNomeEvento;
	@FXML
	private TextField txtUfEvento;
	@FXML
	private Button btnListareEvento;
	@FXML
	private Button btnAtualizarEvento;
	@FXML
	private Button btnExcluirEvento;
	@FXML
	private TextField txtCodigoIngresso;
	@FXML
	private TextField txtTipoIngresso;
	@FXML
	private TextField txtPrecoIngresso;
	@FXML
	private TextArea taCaravana;
	@FXML
	private Button btnSalvarCaravana;
	@FXML
	private TextField txtCodigoCaravana;
	@FXML
	private TextField txtCapacidadeCaravana;
	@FXML
	private TextField txtPrecoCaravana;
	@FXML
	private TextField txtNomeCaravana;
	@FXML
	private TextField txtUfCaravana;
	@FXML
	private Button btnListarCaravana;
	@FXML
	private Button btnAtualizarCaravana;
	@FXML
	private Button btnExcluirCaravana;
	@FXML
	private Button btnVisualizarCaravana;
	@FXML
	private TextArea taProgramacao;
	@FXML
	private Button btnSalvarProgramacao;
	@FXML
	private TextField txtCodigoProgramacao;
	@FXML
	private TextField txtCodigoEvento_Programacao;
	@FXML
	private TextField txtNomeProgramacao;
	@FXML
	private TextField txtHorarioProgramacao;
	@FXML
	private Button btnListarProgramacao;
	@FXML
	private Button btnAtualizarProgramacao;
	@FXML
	private Button btnExcluirProgramacao;
	@FXML
	private TextArea taCompra;
	@FXML
	private Button btnSalvarCompra;
	@FXML
	private TextField txtCodigoCompra;
	@FXML
	private TextField txtNomeComprador;
	@FXML
	private TextField txtEmailCompra;
	@FXML
	private TextField txtCodigoEvento_compra;
	@FXML
	private TextField txtCodigoIngresso_compra;
	@FXML
	private TextField txtCodigoCaravana_compra;
	@FXML
	private Button btnListarCompra;
	@FXML
	private Button btnAtualizarCompra;
	@FXML
	private Button btnExcluirCompra;
	@FXML
	private Button btnVisualizarOpcao_compra;
	@FXML
	private Button btnVisualizarCompra;
	@FXML
	private Label lblInformacao;
	@FXML
	private Button btnBuscar;

	@FXML
	public void acaoEvento(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		EventoController eventoController = new EventoController(txtCodigoEvento, txtNomeEvento, txtDataEvento,
				txtHoraEvento, txtRuaEvento, txtNumeroEvento, txtUfEvento,
				taEvento);
		
		IngressoController ingressoController = new IngressoController(txtCodigoEvento,
				txtCodigoIngresso, txtTipoIngresso, txtPrecoIngresso,
				taEvento);
		
		if((cmd.contains("Salvar") || cmd.contains("Atualizar")) && (txtCodigoEvento.getText().isEmpty()
				|| txtNomeEvento.getText().isEmpty()
				|| txtDataEvento.getText().isEmpty()
				|| txtHoraEvento.getText().isEmpty()
				|| txtRuaEvento.getText().isEmpty()
				|| txtNumeroEvento.getText().isEmpty()
				|| txtUfEvento.getText().isEmpty()
				|| txtCodigoIngresso.getText().isEmpty()
				|| txtTipoIngresso.getText().isEmpty()
				|| txtPrecoIngresso.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if((cmd.contains("Excluir") && txtCodigoEvento.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "Preencha o código", "ERRO", JOptionPane.ERROR_MESSAGE);
			}else {
				try {
					if(cmd.contains("Listar")) {
						eventoController.buscarEventos();	
					}
					else if(cmd.contains("Excluir")){
						Evento ev = new Evento();
						ev.setCodigo(Integer.parseInt(txtCodigoEvento.getText()));
						eventoController.excluirEvento(ev);
					}
					else {
						Evento ev = new Evento();
						ev.setCodigo(Integer.parseInt(txtCodigoEvento.getText()));
						ev.setNome(txtNomeEvento.getText());
						ev.setData(txtDataEvento.getText()); 
						ev.setHora(txtHoraEvento.getText());
						ev.setRua(txtRuaEvento.getText());
						ev.setNumero(Integer.parseInt(txtNumeroEvento.getText()));
						ev.setUf(txtUfEvento.getText());
						
					//	if(!txtCodigoIngresso.getText().isEmpty()) {
							Ingresso i = new Ingresso();
							i.setCodigo(Integer.parseInt(txtCodigoIngresso.getText()));
							i.setTipo(txtTipoIngresso.getText());
							i.setPreco(Double.parseDouble(txtPrecoIngresso.getText()));
							ev.setIngresso(i);
					//	}
						
						if(cmd.contains("Salvar")) {
							eventoController.inserirEvento(ev);
						//	ingressoController.inserirIngresso(i);
						}else if(cmd.contains("Atualizar")) {
							eventoController.atualizarEvento(ev);
						}
						
					}
				} catch (SQLException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();	
				}
			}
		}
	}

	@FXML
	public void acaoCaravana(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		CaravanaController caravanaController = new CaravanaController(txtCodigoCaravana, txtNomeCaravana,txtCapacidadeCaravana,
        txtPrecoCaravana, txtUfCaravana, taCaravana);
			
		if((cmd.contains("Salvar") || cmd.contains("Atualizar")) &&
				(txtCodigoCaravana.getText().isEmpty()
					|| txtNomeCaravana.getText().isEmpty()
					|| txtCapacidadeCaravana.getText().isEmpty()
					|| txtPrecoCaravana.getText().isEmpty()
					|| txtUfCaravana.getText().isEmpty())) 
		{
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			if((cmd.contains("Excluir") || cmd.contains("Buscar")) && 
					(txtCodigoCaravana.getText().isEmpty()))
			{
				JOptionPane.showMessageDialog(null, "Insira o codigo, capacidade e preco para que a caravana seja apagada", 
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try {
					if(cmd.contains("Listar")) {
						caravanaController.buscarCaravanas();
					}else if(cmd.contains("Excluir")) {
						Caravana c = new Caravana();
						c.setCodigo(Integer.parseInt(txtCodigoCaravana.getText()));
						caravanaController.excluirCaravana(c);
						
					}else if(cmd.contains("Buscar") || cmd.contains("txtCodigoCaravana")) {
						Caravana c = new Caravana();
						c.setCodigo(Integer.parseInt(txtCodigoCaravana.getText()));
						caravanaController.buscarCaravana(c);
						
					}else if(cmd.contains("Visualizar caravanas e eventos")) {
						caravanaController.buscarCaravanaEvento();
					}else {
						Caravana c = new Caravana();
						c.setCodigo(Integer.parseInt(txtCodigoCaravana.getText()));
						c.setNome(txtNomeCaravana.getText());
						c.setCapacidade(Integer.parseInt(txtCapacidadeCaravana.getText()));
						c.setPreco(Double.parseDouble(txtPrecoCaravana.getText()));
						c.setUf(txtUfCaravana.getText());
						
						if(cmd.contains("Salvar")) {
							caravanaController.inserirCaravana(c);
						}else if(cmd.contains("Atualizar")) {
							caravanaController.atualizarCaravana(c);
						}
					}
													
				}catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}

	}
	
	
	@FXML
	public void acaoProgramacao(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		ProgramacaoController programacaoController = new ProgramacaoController(txtCodigoProgramacao, 
			txtCodigoEvento_Programacao, txtHorarioProgramacao, txtNomeProgramacao, taProgramacao); 
		
		if((cmd.contains("Salvar") || cmd.contains("Atualizar")) && (txtCodigoProgramacao.getText().isEmpty()
				|| txtCodigoEvento_Programacao.getText().isEmpty() || txtHorarioProgramacao.getText().isEmpty()
				|| txtNomeProgramacao.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if((cmd.contains("Excluir") && txtCodigoProgramacao.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "Preencha o codigo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				try {
					if(cmd.contains("Listar")) {
						programacaoController.buscarProgramacoes();
					}else {
						Programacao p = new Programacao();
						p.setCodigo(Integer.parseInt(txtCodigoProgramacao.getText()));
						p.setHorario(txtHorarioProgramacao.getText());
						p.setNome(txtNomeProgramacao.getText());
						
						
						Evento ev = new Evento();
						ev.setCodigo(Integer.parseInt(txtCodigoEvento_Programacao.getText()));
						p.setEvento(ev);
						
						if (cmd.contains("Salvar")) {
							programacaoController.inserirProgramacao(p);
						}else if(cmd.contains("Atualizar")) {
							programacaoController.atualizarProgramacao(p);
						}else if(cmd.contains("Excluir")) {
							programacaoController.excluirProgramacao(p);
						}
					}
				} catch (SQLException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
	}
	
	@FXML
	public void acaoCompra(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		CompraController compraController = new CompraController
				(txtCodigoCompra, txtNomeComprador, txtEmailCompra,
				txtCodigoEvento_compra, /*txtCodigoIngresso_compra,*/ txtCodigoCaravana_compra,
				taCompra);
		
		if((cmd.contains("Salvar") || cmd.contains("Atualizar")) && 
				(txtCodigoCompra.getText().isEmpty()
					|| txtNomeComprador.getText().isEmpty()
					|| txtEmailCompra.getText().isEmpty()
				|| txtCodigoEvento_compra.getText().isEmpty()
			//	|| txtCodigoIngresso_compra.getText().isEmpty()
				|| txtCodigoCaravana_compra.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		}else {
			if((cmd.contains("Excluir") 
					&& txtCodigoCompra.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha o codigo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}else {
				try {
					if(cmd.contains("Listar")) {
						compraController.buscarCompras();
					}
					else if(cmd.contains("Visualizar opções")){
						compraController.visualizarOpcao();
					}else if(cmd.contains("Visualizar compra")){
						compraController.listaFiltrar();
					}
						else{
						Compra cp = new Compra();
						cp.setCodigo(Integer.parseInt(txtCodigoCompra.getText()));
						cp.setNome(txtNomeComprador.getText());
						cp.setEmail(txtEmailCompra.getText());
						
						if(!txtCodigoEvento_compra.getText().isEmpty()) {
							Evento ev = new Evento();
							ev.setCodigo(Integer.parseInt(txtCodigoEvento_compra.getText()));
							cp.setEvento(ev);
						}
						
					/*	if(!txtCodigoIngresso_compra.getText().isEmpty()) {
							Ingresso i = new Ingresso();
							i.setCodigo(Integer.parseInt(txtCodigoIngresso_compra.getText()));
							cp.setIngresso(i);
						}
						*/
						if(!txtCodigoCaravana_compra.getText().isEmpty()) {
							Caravana c = new Caravana();
							c.setCodigo(Integer.parseInt(txtCodigoCaravana_compra.getText()));
							cp.setCaravana(c);
						}
						
						if(cmd.contains("Salvar")) {
							compraController.inserirCompra(cp);
						}else if(cmd.contains("Atualizar")) {
							compraController.atualizarCompra(cp);
						}else if(cmd.contains("Excluir")) {
							compraController.excluirCompra(cp);
						}
						
						
					}
				} catch (SQLException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();					
				}
			}
				
		}
		
	}
	
	
}
