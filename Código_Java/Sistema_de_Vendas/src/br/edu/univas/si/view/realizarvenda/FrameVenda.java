package br.edu.univas.si.view.realizarvenda;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import br.edu.univas.si.controller.vendaproduto.ControllerVenda;
import br.edu.univas.si.listeners.ButtonsListenersVendas;
import br.edu.univas.si.listeners.PressTeclaListener;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameVenda extends MyJFrame{
	
	private static final long serialVersionUID = 5395576882928509353L;
	
	private ButtonsPanelVendas buttons;
	private PanelLabelsVenda panelLabel;
	private PanelTableProdutos panelProdutos;
	
	ControllerVenda controller;
	
	public FrameVenda(ControllerVenda controller){
		super("Vendas - Atendimento");
		this.controller = controller;
		initialize();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void  initialize(){
		add(getButtons(), BorderLayout.BEFORE_FIRST_LINE);
		add(getPanelLabel(), BorderLayout.LINE_START);
		add(getTableProduto(), BorderLayout.CENTER);
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
					abandonaClicked();	
				}
			});
			
		}		
		return buttons;
	}
	
	private void finalizaCliked(){
		controller.insertVenda();
	}
	
	private void cancelaClicked(){
		controller.cancelaUltimaVenda();
	}
	
	private void abandonaClicked(){
		controller.abandonaVenda();
	}
	
	public PanelLabelsVenda getPanelLabel(){
		if(panelLabel==null){
			panelLabel = new PanelLabelsVenda();
			panelLabel.setPressTeclaPerformed(new PressTeclaListener() {
				@Override
				public void pressKeyPerformed() {
					enterPress();					
				}
			});
		}
		return panelLabel;
	}
	
	public PanelTableProdutos getTableProduto(){
		if(panelProdutos==null){
			panelProdutos = new PanelTableProdutos();
		}
		return panelProdutos;
	}
	
	//Registra produto no JTable
	private void enterPress(){ 
		controller.updateTableVenda();
	}
}
