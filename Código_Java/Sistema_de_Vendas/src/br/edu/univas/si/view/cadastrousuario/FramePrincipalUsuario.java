package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;

import br.edu.univas.si.controller.usuario.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FramePrincipalUsuario extends MyJFrame {

	private static final long serialVersionUID = -6140725584051515117L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableUsuario tableUsuario;
	private ControllerIncluir controllerIncluir;
	
	public FramePrincipalUsuario() {
		super("Cadastro usuário");

		initialize();
		setExtendedState(MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getTableUsuario(), BorderLayout.CENTER);
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

	private PanelTableUsuario getTableUsuario() {
		if(tableUsuario==null){
			tableUsuario = new PanelTableUsuario();
		}
		
		return tableUsuario;
	}
	
	private void incluiClicked(){
		controllerIncluir = new ControllerIncluir();
		controllerIncluir.initialize();
	}
	
	private void alteraClicked(){
		//TODO
	}
	
	private void excluiClicked(){
		//TODO
	}
	
	private void sairClicked(){
		if(controllerIncluir!=null){
			controllerIncluir.close();
		}
		this.dispose();
	}
	
	//TODO retirar
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		 FramePrincipalUsuario f = new FramePrincipalUsuario();
		 f.setVisible(true);
	}
}
