package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;

import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameCadastroUnidadeMedida extends MyJFrame {

	private static final long serialVersionUID = -7511419928508107918L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableUnidadeMedida tableUnidadeMedia;

	public FrameCadastroUnidadeMedida() {
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
					// TODO implements

				}

				@Override
				public void excluiPerformed() {
					// TODO implements

				}

				@Override
				public void alteraPerformed() {
					// TODO implements

				}

				@Override
				public void SairPerformed() {
					// TODO implements

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
	
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FrameCadastroUnidadeMedida f = new FrameCadastroUnidadeMedida();
		f.setVisible(true);
	}
}
