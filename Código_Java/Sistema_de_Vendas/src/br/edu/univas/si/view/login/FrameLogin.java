package br.edu.univas.si.view.login;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.principal.ControllerLogin;
import br.edu.univas.si.controller.principal.ControllerPrincipal;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameLogin extends MyJFrame {

	private static final long serialVersionUID = -5190457170229789597L;

	PanelLogin panelLogin = null;
	ButtonsPanelConfirmaFecha buttonsLogin = null;
	ControllerLogin controller;

	public FrameLogin(ControllerLogin controller) {
		super("Login");
		this.controller = controller;
		initialize();

		setPreferredSize(new Dimension(350, 200));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getPanelLogin(), BorderLayout.NORTH);
		add(getButtonsPanelConfirmaFecha(), BorderLayout.SOUTH);

	}

	public PanelLogin getPanelLogin() {
		if (panelLogin == null) {
			panelLogin = new PanelLogin();
		}
		return panelLogin;
	}

	private ButtonsPanelConfirmaFecha getButtonsPanelConfirmaFecha() {
		if (buttonsLogin == null) {
			buttonsLogin = new ButtonsPanelConfirmaFecha();
			buttonsLogin.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {

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
		return buttonsLogin;
	}

	private void fechaClicked() {
		System.exit(0);
	}

	private void confirmaClicked() {
		if(!controller.autentifica()){
			JOptionPane.showMessageDialog(null, "Senha ou usuário incorretos!","Aviso!",JOptionPane.WARNING_MESSAGE);
		}else{
			//Inicia Aplicação...
			ControllerPrincipal controllerMenu = new ControllerPrincipal();
			controllerMenu.initialize();
			controller.close();
		}
	}
}
