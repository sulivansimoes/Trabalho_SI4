package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;

import br.edu.univas.si.view.defaultcomponents.ButtonsListenersCadastro;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameCadastroUsuario extends MyJFrame {

	private static final long serialVersionUID = -6140725584051515117L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableUsuario tableUsuario;

	public FrameCadastroUsuario() {
		super("Cadastro usu�rio");

		initialize();
		setExtendedState(MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getTableUsuario(), BorderLayout.CENTER);
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

	private PanelTableUsuario getTableUsuario() {
		if(tableUsuario==null){
			tableUsuario = new PanelTableUsuario();
		}
		
		return tableUsuario;
	}
	
	public static void main(String[] args) { //TODO retirar
		setlookAndFeel(AERO);
		FrameCadastroUsuario f = new FrameCadastroUsuario();
		f.setVisible(true);
	}

}
