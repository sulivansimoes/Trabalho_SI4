package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.unidademedida.Controller;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameIncluirUnidadeMedida extends MyJFrame {

	private static final long serialVersionUID = -535016700356021864L;

	private PanelUnidadeMedida panelUnidadeMedida;
	private ButtonsPanelConfirmaFecha buttonsPanel;
	private Controller controller;

	public FrameIncluirUnidadeMedida(Controller controller) {
		super("Incluir - Unidade Medida");
		this.controller = controller;
		
		setPreferredSize(new Dimension(700, 270));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getPanelUnidadeMedida(), BorderLayout.CENTER);
	}

	private ButtonsPanelConfirmaFecha getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanelConfirmaFecha();
			buttonsPanel.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				@Override
				public void fechaPerformed() {
					fechaClicked();
				}

				@Override
				public void confirmaPerformed() {
					confirmaClicked();
				}
			});
		}
		return buttonsPanel;
	}

	private PanelUnidadeMedida getPanelUnidadeMedida() {
		if (panelUnidadeMedida == null) {
			panelUnidadeMedida = new PanelUnidadeMedida();
		}
		return panelUnidadeMedida;
	}
	
	private void confirmaClicked(){
		//Extrai conteudo dos campos.
		String codigo =  getPanelUnidadeMedida().getTextFieldCodigo().getText();	
		String descricao = getPanelUnidadeMedida().getTextFieldDescricao().getText();
		
		if(! validaPreechimento(codigo, descricao)){
			JOptionPane.showMessageDialog(this, "Campos com asterisco ( * ) são de prechimento obrigatório. Preencha os "
										 + "campos obrigatórios antes de salvar.");
		}else{
			//Monta TO
			UnidadeMedidaTO unidadeMedida = new UnidadeMedidaTO(codigo, descricao);
			//Envia TO para controller.	
			controller.insertUnidadeMedida(unidadeMedida);
		
			limpaCampos();
		}
	}
	
	//Valida o prenchimento dos campos obrigatórios antes de salvar.
	private boolean validaPreechimento(String codigo, String descricao){
		if(codigo.trim().isEmpty() || descricao.trim().isEmpty()){
			return false;
		}
		return true;
	}
	
	private void limpaCampos(){
		getPanelUnidadeMedida().getTextFieldCodigo().setText("");
		getPanelUnidadeMedida().getTextFieldDescricao().setText("");
	}
	
	private void fechaClicked(){
		Object[] opcoes = {"Sim","Não"};
		int escolha = JOptionPane.showOptionDialog(this, 
												  "Deseja fechar sem salvar ?", 
												  "Aviso", 
												  JOptionPane.YES_NO_OPTION, 
												  JOptionPane.QUESTION_MESSAGE, 
												  null , 
												  opcoes , 
												  opcoes[1]);
		
		if(escolha==0){ //Sim
				this.dispose();
		}
	}
}
