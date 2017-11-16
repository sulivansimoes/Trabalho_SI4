package br.edu.univas.si.view.realizarvenda;

import java.awt.BorderLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import br.edu.univas.si.listeners.ButtonsListenersVendas;
import br.edu.univas.si.view.util.MyJFrame;
import br.edu.univas.si.view.util.MyMask;

public class FrameVenda extends MyJFrame{
	
	private static final long serialVersionUID = 5395576882928509353L;
	
	private ButtonsPanelVendas buttons;
	private JFormattedTextField cpoProduto;
	
	public FrameVenda(){
		
		initialize();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void  initialize(){
		add(getButtons(), BorderLayout.LINE_START);
		add(getCpoProduto(), BorderLayout.SOUTH);
	}
	
	private ButtonsPanelVendas getButtons(){
		if(buttons==null){
			buttons = new ButtonsPanelVendas();
			buttons.addButtonListenersVendas(new ButtonsListenersVendas() {
				@Override
				public void finalizaPerformed() {
					finalizaCliked();
				}
				
				@Override
				public void cancelaPerformed() {
					cancelaClicked();
				}
				
				@Override
				public void abandonaPerformed() {
					// TODO implements
					
				}
			});
			
		}		
		return buttons;
	}
	
	private void finalizaCliked(){
		//TODO implements
	}
	
	private void cancelaClicked(){
		//TODO implements
	}
	
	private void abandonaClicked(){
		//TODO implements
	}
	
	private JFormattedTextField getCpoProduto(){
		if(cpoProduto==null){
			cpoProduto = new JFormattedTextField();
			cpoProduto.setColumns(40);
			MyMask.maskCodigoBarras(cpoProduto);
		}
		return cpoProduto;
	}
	
	//TODO: RETIRAR
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FrameVenda f = new FrameVenda();
		f.setVisible(true);
	}
}
