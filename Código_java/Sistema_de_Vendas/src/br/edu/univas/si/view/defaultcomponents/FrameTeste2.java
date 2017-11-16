package br.edu.univas.si.view.defaultcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameTeste2 extends MyJFrame{

	private static final long serialVersionUID = -4451478510256229503L;
	
	private ButtonsPanelConfirmaFecha confirmaFechaButtons;

	public FrameTeste2() {
		super("Frame 2");
		setPreferredSize(new Dimension(600,600));
		
		initialize();
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		add(getConfirmaFechaButtons(),BorderLayout.NORTH);
	}
	
	private ButtonsPanelConfirmaFecha getConfirmaFechaButtons(){
		if(confirmaFechaButtons == null){
			confirmaFechaButtons = new ButtonsPanelConfirmaFecha();
			confirmaFechaButtons.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				@Override
				public void fechaPerformed() {
					JOptionPane.showMessageDialog(null, "Teste fechar");
					
				}
				
				@Override
				public void confirmaPerformed() {
					JOptionPane.showMessageDialog(null, "teste confirmar");
					
				}
			});
		}		
		return confirmaFechaButtons;
	}
	
	public static void main(String[] args){
		setlookAndFeel(AERO);
		FrameTeste2 f = new FrameTeste2();
		f.setVisible(true);
	}
}
