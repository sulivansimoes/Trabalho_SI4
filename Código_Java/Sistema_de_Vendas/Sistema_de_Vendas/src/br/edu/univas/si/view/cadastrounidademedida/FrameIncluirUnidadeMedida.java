package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;
import java.awt.Dimension;

import br.edu.univas.si.view.defaultcomponents.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameIncluirUnidadeMedida extends MyJFrame {

	private static final long serialVersionUID = -535016700356021864L;

	private PanelUnidadeMedida panelUnidadeMedida;
	private ButtonsPanelConfirmaFecha buttonsPanel;

	public FrameIncluirUnidadeMedida() {
		super("Incluir - Unidade Medida");
		setPreferredSize(new Dimension(700, 270));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getPanelUnidadeMedida(), BorderLayout.CENTER);
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
					// TODO impelemtns

				}
			});
		}
		return buttonsPanel;
	}

	private PanelUnidadeMedida getPanelUnidadeMedida() {
		if (panelUnidadeMedida == null) {
			panelUnidadeMedida = new PanelUnidadeMedida();
		}
		return panelUnidadeMedida;
	}

	// FIXME retirar main
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FrameIncluirUnidadeMedida t = new FrameIncluirUnidadeMedida();
		t.setVisible(true);
	}

}
