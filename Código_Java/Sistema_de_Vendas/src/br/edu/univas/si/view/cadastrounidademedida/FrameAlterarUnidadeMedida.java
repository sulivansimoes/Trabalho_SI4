package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.unidademedida.Controller;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameAlterarUnidadeMedida extends MyJFrame{

	private static final long serialVersionUID = 7769731142209152371L;
	
	private ButtonsPanelConfirmaFecha buttons;
	private PanelUnidadeMedida panelUnidadeMedida;
	
	public FrameAlterarUnidadeMedida(Controller controller){
		super("Alterar - Unidade Medida");
	
		setPreferredSize(new Dimension(700, 270));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		add(getButtons(), BorderLayout.NORTH);
		add(getPanelUnidadeMedida(), BorderLayout.CENTER);
	}
	
	private ButtonsPanelConfirmaFecha getButtons(){
		if(buttons==null){
			buttons = new ButtonsPanelConfirmaFecha();
			buttons.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
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
		return buttons;
	}
	
	private PanelUnidadeMedida getPanelUnidadeMedida(){
		if(panelUnidadeMedida==null){
			panelUnidadeMedida = new PanelUnidadeMedida();
			panelUnidadeMedida.getTextFieldCodigo().setEditable(false);
			//Carregar a as informa��es do cadastro no Panel.
			//TODO
		}
		return panelUnidadeMedida;
	}
	
	private void confirmaClicked(){
		//TODO implements
	}	
	
	private void fechaClicked(){
		Object[] opcoes = {"Sim","N�o"};
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
	
	
	//TODO retirar
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FrameAlterarUnidadeMedida f = new FrameAlterarUnidadeMedida();
		f.setVisible(true);
	}
}
