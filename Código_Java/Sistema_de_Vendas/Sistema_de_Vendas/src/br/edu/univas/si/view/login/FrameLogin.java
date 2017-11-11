package br.edu.univas.si.view.login;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.view.defaultcomponents.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameLogin extends MyJFrame {

	private static final long serialVersionUID = -5190457170229789597L;

	PanelLogin panelLogin = null;
	ButtonsPanelConfirmaFecha buttonsLogin = null;
	
	public FrameLogin(){
		super("Login");
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

	private PanelLogin getPanelLogin(){
		if(panelLogin == null){
			panelLogin = new PanelLogin();
		}
		return panelLogin;
	}
	
	private ButtonsPanelConfirmaFecha getButtonsPanelConfirmaFecha(){
		if(buttonsLogin==null){
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
	
	private void fechaClicked(){
		JOptionPane.showMessageDialog( this,"Cancelou login");
		System.exit(0);
	}
	
	private void confirmaClicked(){
		JOptionPane.showMessageDialog(this, "Tentou login");
	}
	
	public static void main(String[] args) {//TODO RETIRAR
		
		//setlookAndFeel(ACRYL);
		setlookAndFeel(AERO);
		FrameLogin t = new FrameLogin();
		t.setVisible(true);
	}
}
