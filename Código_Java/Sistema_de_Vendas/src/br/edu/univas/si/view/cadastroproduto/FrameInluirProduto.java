package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.dao.processes.ProdutoDAO;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

/**
 * Summary: Classe contém JFrame onde usuário preenche campos para fazer uma nova inclusão de um produto.
 * @author: Súlivan Simões Silva
 */
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
					fechaClicked();
				}

				@Override
				public void confirmaPerformed() {
					confirmaClicked();
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
	
	private void confirmaClicked(){
		//Extrai conteudo dos campos. 
		long codigoDeBarras =  Long.valueOf(getPanelProduto().getTextFieldCodigoDeBarras().getText().trim().isEmpty() ? 
											"0" : getPanelProduto().getTextFieldCodigoDeBarras().getText().trim() );
	
		float precoVenda = Float.valueOf(getPanelProduto().getTextFieldPrecoVenda().getText().isEmpty() ? 
										"0" : getPanelProduto().getTextFieldPrecoVenda().getText());
		
		float quantidade = Float.valueOf(getPanelProduto().getTextFieldQuantidade().getText().isEmpty() ? 
										"0" : getPanelProduto().getTextFieldQuantidade().getText());
		
		String descricao = getPanelProduto().getTextFieldDescricao().getText();
		String codigoUnidadeMedida = getPanelProduto().getTextFieldCodigoUnidadeMedida().getText(); 
		
		if(! validaPreenchimento(codigoDeBarras, descricao, precoVenda, quantidade, codigoUnidadeMedida)){
			JOptionPane.showMessageDialog(this, "Campos com asterisco ( * ) são de prechimento obrigatório. Preencha os "
										 + "campos obrigatórios antes de salvar.");
		}else{
			//Monta TO
			ProdutoTO produto = new ProdutoTO(codigoDeBarras, descricao, precoVenda, quantidade ,codigoUnidadeMedida);
			
			//Chama model direto na view - FIXME: CHAMAR O CONTROLLER NO LUGAR DO MODEL
			ProdutoDAO d = new ProdutoDAO();
			try {
				d.insertNewProduto(produto);
			} catch (ProdutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			limpaCampos();
		}
	}
	
	//Valida se os campos obrigatórios estão preenchidos antes de salvar.
	private boolean validaPreenchimento(long codigoBarras, String descricao, Float precoVenda, Float quantidade, String unid){
		
		if(codigoBarras==0 || descricao.trim().isEmpty() || precoVenda==0 || quantidade==0 || unid.trim().isEmpty()){
			return false;
		}
		return true;
	}
	
	private void limpaCampos(){
		getPanelProduto().getTextFieldCodigoDeBarras().setText("");
		getPanelProduto().getTextFieldDescricao().setText("");
		getPanelProduto().getTextFieldPrecoVenda().setText("");
		getPanelProduto().getTextFieldQuantidade().setText("");
		getPanelProduto().getTextFieldCodigoUnidadeMedida().setText("");
	}
	
	private void fechaClicked(){
		Object[] opcoes = {"Sim","Não"};
		int escolha = JOptionPane.showOptionDialog(this, 
												  "Deseja fechar sem salvar ?", 
												  "Aviso", 
												  JOptionPane.YES_NO_OPTION, 
												  JOptionPane.QUESTION_MESSAGE, 
												  null , 
												  opcoes , 
												  opcoes[1]);
		
		if(escolha==0){ //Sim
				this.dispose();
		}
	}
	
	//FIXME retirar main
	public static void main(String[] args) {
		setlookAndFeel(AERO);
		FrameInluirProduto p = new FrameInluirProduto();
		p.setVisible(true);
	}
}
