package br.edu.univas.si.controller.vendaproduto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.produto.ControllerConsulta;
import br.edu.univas.si.model.dao.processes.VendaDAO;
import br.edu.univas.si.model.exception.VendaException;
import br.edu.univas.si.model.tablemodel.TableModelProduto;
import br.edu.univas.si.model.to.CabecalhoVendaTO;
import br.edu.univas.si.model.to.ItensVendaTO;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.realizarvenda.FrameVenda;

public class ControllerVenda {

	FrameVenda viewVenda;
	VendaDAO modelVenda;
	TableModelProduto modelTableProduto;

	private String SERIE = "001"; 	//A serie, deve ser alterada quando o numero do cupom alcança seu número maximo.
	
	public ControllerVenda() {
		this.viewVenda = new FrameVenda(this);
		viewVenda.getPanelLabel().getTextFieldCpoProduto().grabFocus(); //Força o foco no campo após a abertura da tela de venda.
		
		modelVenda = new VendaDAO();
		modelTableProduto = new TableModelProduto();
	}
	
	public void initialize(){
		viewVenda.setVisible(true);
	}
	
	//Atualiza view de acordo com produto informado no JTextField do produto.
	public void updateTableVenda(){
		//Pega codigo de barras da view e procura no banco de dados.
		ProdutoTO produto = new  ControllerConsulta().searchProduto(viewVenda.getPanelLabel().getTextFieldCpoProduto().getText().trim());
		
		if(produto==null){
			JOptionPane.showMessageDialog(viewVenda, 
										 "Código de barras não cadastrado. \n Produto não encontrado.",
										 "Aviso",
										 JOptionPane.ERROR_MESSAGE);
		}else{
			//Atualiza JTable com produto
			TableModelProduto bkpModel = (TableModelProduto) viewVenda.getTableProduto().getTable().getModel();
			bkpModel.addProduto(produto);
			viewVenda.getTableProduto().getTable().setModel(bkpModel);
			
			//Atualiza label total - referente ao total da venda.
			float total = 0f;
			for(int i=0; i < bkpModel.getRowCount() ; i++){
				total += Float.valueOf(bkpModel.getValueAt(i, 4).toString());
			}
			viewVenda.getPanelLabel().getLabelCalculoTotal().setText(String.valueOf(total));
		}
		viewVenda.getPanelLabel().getTextFieldCpoProduto().setText("");
	}
	
	public void insertVenda(){
		
		ArrayList<ItensVendaTO> listaProdutos =  new ArrayList<ItensVendaTO>();

		try {
			//Pegando infrmações do cabeçalho da venda.			
			int numeroCupom  	=  modelVenda.searchUltimaVenda(SERIE)+1;
			Date dataEmissao 	= Calendar.getInstance().getTime();
			float valorTotal	= Float.valueOf(viewVenda.getPanelLabel().getLabelCalculoTotal().getText());
			String cpfUsuario   =  "00000000000";//TODO corrrigir pegar o cpf do usuario que está fazendo a venda.
						
			for(int linha = 0; linha <  viewVenda.getTableProduto().getTable().getModel().getRowCount(); linha++){
				
				int item = linha+1;
				String produto 	  = viewVenda.getTableProduto().getTable().getModel().getValueAt(linha, 0).toString();
				float  quantidade = Float.valueOf(viewVenda.getTableProduto().getTable().getModel().getValueAt(linha, 3).toString());
				String codigoUM   = viewVenda.getTableProduto().getTable().getModel().getValueAt(linha, 2).toString();
				float valorItem   = Float.valueOf(viewVenda.getTableProduto().getTable().getModel().getValueAt(linha, 4).toString());
	
				listaProdutos.add(new ItensVendaTO(numeroCupom, SERIE, item, produto, quantidade, codigoUM, valorItem, valorItem));			
			}			
	
			//Envia venda para o banco.
			modelVenda.insertNewVenda(new CabecalhoVendaTO(numeroCupom,SERIE,dataEmissao,cpfUsuario,valorTotal), listaProdutos);
			
			//Limpa tela para uma nova venda.
			cleanSreen();
			
			JOptionPane.showMessageDialog(viewVenda, "Venda registrada.");
			
		} catch (VendaException e) {
			e.printStackTrace();
		}		
	}
	
	public void abandonaVenda(){
		Object[] opcoes = {"Sim","Não"};
		int escolha = JOptionPane.showOptionDialog(viewVenda, 
												  "Deseja abandonar venda ?", 
												  "Aviso", 
												  JOptionPane.YES_NO_OPTION, 
												  JOptionPane.QUESTION_MESSAGE, 
												  null , 
												  opcoes , 
												  opcoes[1]);
		
		if(escolha==0){ //Sim
				viewVenda.dispose();
		}
	}
	
	public void cancelaUltimaVenda(){
		try {
				int  cupomUltimaVenda = modelVenda.searchUltimaVenda(SERIE);
				Object[] opcoes = {"Sim","Não"};
				int escolha = JOptionPane.showOptionDialog(viewVenda, 
														  "Deseja excluir ultima venda ?\n Número cupom: "+cupomUltimaVenda+"\n Série: "+SERIE, 
														  "Aviso", 
														  JOptionPane.YES_NO_OPTION, 
														  JOptionPane.QUESTION_MESSAGE, 
														  null , 
														  opcoes , 
														  opcoes[1]);
				
				if(escolha==0){ //Sim
						modelVenda.deleteVenda(cupomUltimaVenda, SERIE);
						
						JOptionPane.showMessageDialog(viewVenda, "Venda canceada.");
						viewVenda.getPanelLabel().getTextFieldCpoProduto().grabFocus();
				}
		} catch (VendaException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void cleanSreen(){
		TableModelProduto novoModel = new TableModelProduto();
		viewVenda.getTableProduto().getTable().setModel(novoModel);
		viewVenda.getPanelLabel().getTextFieldCpoProduto().setText("");
		viewVenda.getPanelLabel().getTextFieldCpoProduto().grabFocus();
		viewVenda.getPanelLabel().getLabelCalculoTotal().setText("0.00");
	}
	
}
