package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;
import java.awt.Dimension;

import br.edu.univas.si.view.defaultcomponents.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameIncluirUsuario extends MyJFrame {

	private static final long serialVersionUID = 5515241630872543611L;

	private PanelUsuario panelUsuario;
	private ButtonsPanelConfirmaFecha buttonsConfirmaFecha;

	public FrameIncluirUsuario() {
		super("Incluir - Usuário");
		setPreferredSize(new Dimension(700, 400));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		add(getButtonsConfirmaFecha(),BorderLayout.NORTH);
		add(getPanelUsuario(),BorderLayout.CENTER);
	}

	private ButtonsPanelConfirmaFecha getButtonsConfirmaFecha() {
		if (buttonsConfirmaFecha == null) {
			buttonsConfirmaFecha = new ButtonsPanelConfirmaFecha();
			buttonsConfirmaFecha.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {

				@Override
				public void fechaPerformed() {
					// TODO implements

				}

				@Override
				public void confirmaPerformed() {
					// implements

				}
			});
		}

		return buttonsConfirmaFecha;
	}

	private PanelUsuario getPanelUsuario() {
		if (panelUsuario == null) {
			panelUsuario = new PanelUsuario();
		}
		return panelUsuario;
	}

	// FIXME retirar main
	public static void main(String[] args) {
		setlookAndFeel(AERO);

		FrameIncluirUsuario t = new FrameIncluirUsuario();
	//	t.setSize(new Dimension(400, 400));
		t.setVisible(true);

	}

}
