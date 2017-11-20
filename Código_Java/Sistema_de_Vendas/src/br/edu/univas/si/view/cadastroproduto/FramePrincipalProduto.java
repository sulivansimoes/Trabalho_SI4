package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import br.edu.univas.si.controller.produto.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

/**
 * Summary: Classe monta JFrame inicial do cadastro de produtos. JFrame contem opções de Incluir, Alterar, Excluir registros.
 * @author: Súlivan Simões Silva
 */
public class FramePrincipalProduto extends MyJFrame {

	private static final long serialVersionUID = 4878628545758897368L;

	private ButtonsPanelCadastro buttonsPanel;
	private PanelTableProduto tableProduto;
	private ControllerIncluir controller;

	public FramePrincipalProduto() {
		super("Cadastro Produto");

		initialize();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {

		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getTabelProduto(), BorderLayout.CENTER);
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
				public void alteraPerformed() {
					alteraClicked();
				}

				@Override
				public void SairPerformed() {
					sairClicked();
				}

				@Override
				public void excluiPerformed() {
					excluiClicked();
				}
			});
		}
		return buttonsPanel;
	}

	private PanelTableProduto getTabelProduto() {
		if (tableProduto == null) {
			try {
				tableProduto = new PanelTableProduto();
			} catch (ProdutoException e) {
				e.printStackTrace();
			}
		}
		return tableProduto;
	}

	private void incluiClicked() {
		controller = new ControllerIncluir();
		controller.initialize();
	}

	private void alteraClicked() {
		// TODO
	}

	private void excluiClicked() {
		// TODO
	}

	private void sairClicked() {
		this.dispose();
	}

	//FIXME RETIRAR MAIN.
	public static void main(String[] args) {

		setlookAndFeel(MyJFrame.AERO);
		FramePrincipalProduto t = new FramePrincipalProduto();
		t.setVisible(true);
	}
}
