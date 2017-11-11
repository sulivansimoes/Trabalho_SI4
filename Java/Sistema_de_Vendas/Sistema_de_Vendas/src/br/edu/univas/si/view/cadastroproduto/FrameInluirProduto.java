package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;
import java.awt.Dimension;

import br.edu.univas.si.view.defaultcomponents.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameInluirProduto extends MyJFrame {

	private static final long serialVersionUID = 3846931392661349187L;

	private ButtonsPanelConfirmaFecha buttonsPanel;
	private PanelProduto panelProduto;

	public FrameInluirProduto() {
		super("Incluir - Produto");
		setPreferredSize(new Dimension(800, 380));

		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() { 
		add(getButtonsPanel(),BorderLayout.NORTH);
		add(getPanelProduto(), BorderLayout.CENTER);
	}

	private ButtonsPanelConfirmaFecha getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanelConfirmaFecha();
			buttonsPanel.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				@Override
				public void fechaPerformed() {
					// TODO implements

				}

				@Override
				public void confirmaPerformed() {
					// TODO implemts

				}
			});
		}
		return buttonsPanel;
	}
	
	private PanelProduto getPanelProduto(){
		if(panelProduto==null){
			panelProduto = new PanelProduto();
		}
		return panelProduto;
	}

	//FIXME retirar main
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FrameInluirProduto p = new FrameInluirProduto();
		p.setVisible(true);
	}
}
