package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.unidademedida.ControllerAlterar;
import br.edu.univas.si.controller.unidademedida.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameAlterarUnidadeMedida extends MyJFrame{

	private static final long serialVersionUID = 7769731142209152371L;
	
	private ButtonsPanelConfirmaFecha buttons;
	private PanelUnidadeMedida panelUnidadeMedida;
	private ControllerAlterar controller;
	
	public FrameAlterarUnidadeMedida(ControllerAlterar controller){
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
			//popular panel com informações do banco.
			
		}
		return panelUnidadeMedida;
	}
	
	private void confirmaClicked(){
		//TODO implements - Pegar dados da linha selecionada do JTable e montar um TO.
		//controller.updateUnidadeMedida(unidade);
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
