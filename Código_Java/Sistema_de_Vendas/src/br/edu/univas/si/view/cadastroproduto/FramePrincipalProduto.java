package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import br.edu.univas.si.controller.produto.ControllerAlterar;
import br.edu.univas.si.controller.produto.ControllerExcluir;
import br.edu.univas.si.controller.produto.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.model.to.ProdutoTO;
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
	private ControllerIncluir controllerIncluir;
	private ControllerAlterar controllerAlterar;
	private ControllerExcluir controllerExcluir;

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

	public PanelTableProduto getTabelProduto() {
		if (tableProduto == null) {
				tableProduto = new PanelTableProduto();
		}
		return tableProduto;
	}

	private void incluiClicked() {
		controllerIncluir = new ControllerIncluir(this);
		controllerIncluir.initialize();
	}

	private void alteraClicked() {
		controllerAlterar = new ControllerAlterar(this);
		controllerAlterar.initialize();
		controllerAlterar.populatePanel(getRowSelected());
	}

	private void excluiClicked() {
		controllerExcluir = new ControllerExcluir(this);
		controllerExcluir.initialize();
		controllerExcluir.populatePanel(getRowSelected());
	}

	private void sairClicked() {
		if(controllerIncluir!=null){
			controllerIncluir.close();	}
		if(controllerExcluir!=null){
			controllerExcluir.close();	}
		if(controllerAlterar!=null){
			controllerAlterar.close();	}
		
		this.dispose();
	}
	
	//Pega conteudo da linha que o usuario esta posicionado.
	private ProdutoTO getRowSelected(){
		int linha = getTabelProduto().getTable().getSelectedRow();
		ProdutoTO produto = new ProdutoTO();
		
		if(linha != -1){ //-1 é flag caso não esteja posiciona em nenhuma linha.
			String codigoBarras = String.valueOf(String.valueOf(getTabelProduto().getTable().getValueAt(linha, 0)));
			String descricao    = String.valueOf(getTabelProduto().getTable().getValueAt(linha, 1));
			String unidademedida= String.valueOf(getTabelProduto().getTable().getValueAt(linha, 2));
			float quantidadeVenda= Float.valueOf(String.valueOf(getTabelProduto().getTable().getValueAt(linha, 3)));
			float  preco 		= Float.valueOf(String.valueOf(getTabelProduto().getTable().getValueAt(linha, 4)));
			
			produto.setCodigoDeBarras(codigoBarras);
			produto.setDescricao(descricao);
			produto.setCodigo_unidadeMedida(unidademedida);
			produto.setQuantidade(quantidadeVenda);
			produto.setPrecoVenda(preco);
		}
		return produto;
	}
}
