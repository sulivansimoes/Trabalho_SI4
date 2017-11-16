package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;

import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FramePrincipalUnidadeMedida extends MyJFrame {

	private static final long serialVersionUID = -7511419928508107918L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableUnidadeMedida tableUnidadeMedia;

	public FramePrincipalUnidadeMedida() {
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
					incluiClicked();

				}

				@Override
				public void excluiPerformed() {
					// TODO implements

				}

				@Override
				public void alteraPerformed() {
					alteraClicked();

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
	
	private void incluiClicked(){
		//TODO: Ver como se chama FrameIncluirUnidade. 
	}
	
	private void alteraClicked(){
		//TODO: Ver a maneira correta de se fazer o procedimento de chamar o FrameIncluirUnidade.
		
	}
	
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FramePrincipalUnidadeMedida f = new FramePrincipalUnidadeMedida();
		f.setVisible(true);
	}
}
