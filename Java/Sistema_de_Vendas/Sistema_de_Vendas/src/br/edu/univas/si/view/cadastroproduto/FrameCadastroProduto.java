package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.view.defaultcomponents.ButtonsListenersCadastro;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameCadastroProduto extends MyJFrame {

		private static final long serialVersionUID = 4878628545758897368L;
		
		private ButtonsPanelCadastro buttonsPanel;
		private PanelTableProduto tableProduto;
		
		public FrameCadastroProduto() {
			super("Cadastro Produto");
			
			initialize();
			setExtendedState(MAXIMIZED_BOTH);
			pack();
			setLocationRelativeTo(null);
		}
		
		private void initialize() {        
			
			add(getButtonsPanel(), BorderLayout.NORTH);
			add(getTabelProduto(), BorderLayout.CENTER);
		}

		private ButtonsPanelCadastro getButtonsPanel(){
			if(buttonsPanel == null){
				buttonsPanel = new ButtonsPanelCadastro();
				buttonsPanel.addButtonsListener(new ButtonsListenersCadastro() {
					@Override
					public void incluiPerformed() {
						JOptionPane.showMessageDialog(null, "Teste do bot�o incluir","AVISO",JOptionPane.YES_NO_CANCEL_OPTION);
						
					}

					@Override
					public void alteraPerformed() {
						JOptionPane.showMessageDialog(null, "Teste do bot�o alterar", "Alterar",JOptionPane.INFORMATION_MESSAGE);
						
					}

					@Override
					public void SairPerformed() {
						JOptionPane.showMessageDialog(null, "Teste sair","Sair", JOptionPane.CANCEL_OPTION);
						
					}

					@Override
					public void excluiPerformed() {
						JOptionPane.showMessageDialog(null, "Teste exclui","Exclui", JOptionPane.ERROR_MESSAGE);
						
					}
				});
			}
			return buttonsPanel;
		}
	
		private PanelTableProduto getTabelProduto(){
			if(tableProduto==null){
				try {
					tableProduto = new PanelTableProduto();
				} catch (ProdutoException e) {
					e.printStackTrace();
				}		
			}
			return tableProduto;
		}
		
		 
		public static void main(String[] args) {
			 
			 setlookAndFeel(MyJFrame.AERO);
			 FrameCadastroProduto t = new FrameCadastroProduto();
			 t.setVisible(true);		
		}
}
