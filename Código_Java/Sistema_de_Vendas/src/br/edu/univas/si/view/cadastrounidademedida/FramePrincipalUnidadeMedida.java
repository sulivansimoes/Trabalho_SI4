package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;

import br.edu.univas.si.controller.unidademedida.ControllerAlterar;
import br.edu.univas.si.controller.unidademedida.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FramePrincipalUnidadeMedida extends MyJFrame {

	private static final long serialVersionUID = -7511419928508107918L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableUnidadeMedida tableUnidadeMedia;
	private ControllerIncluir controllerIncluir;
	private ControllerAlterar controllerAlterar;

	public FramePrincipalUnidadeMedida() {
		super("Cadastro Unidade Medida");

		initialize();
		setExtendedState(MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getTableUnidadeMedia(), BorderLayout.CENTER);
	}

	private ButtonsPanelCadastro getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanelCadastro();
			buttonsPanel.addButtonsListener(new ButtonsListenersCadastro() {

				@Override
				public void incluiPerformed() {
					incluiClicked();

				}

				@Override
				public void excluiPerformed() {
					excluiClicked();

				}

				@Override
				public void alteraPerformed() {
					alteraClicked();

				}

				@Override
				public void SairPerformed() {
					sairClicked();

				}
			});
		}
		return buttonsPanel;
	}

	private PanelTableUnidadeMedida getTableUnidadeMedia(){
		if(tableUnidadeMedia==null){
			tableUnidadeMedia = new PanelTableUnidadeMedida();	
		}
		return tableUnidadeMedia;
	}
	
	private void incluiClicked(){
		controllerIncluir = new ControllerIncluir();
		controllerIncluir.initialize();
		//TODO 
	}
	
	private void alteraClicked(){
		controllerAlterar = new ControllerAlterar();
		controllerAlterar.initialize();
	}
	
	private void excluiClicked(){
		//TODO implements.   
	}
	
	private void sairClicked(){
		if(controllerIncluir!=null){
			controllerIncluir.close();
		}
		this.dispose();
	}
	
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FramePrincipalUnidadeMedida f = new FramePrincipalUnidadeMedida();
		f.setVisible(true);
	}
}
