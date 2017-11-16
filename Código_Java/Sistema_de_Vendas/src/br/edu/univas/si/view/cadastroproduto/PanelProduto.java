package br.edu.univas.si.view.cadastroproduto;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.view.util.MyMask;

/**
 * Summary: Classe monta um JPanel com os campos e labels de um produto.
 * @author: S�livan Sim�es Silva
 */
public class PanelProduto extends JPanel{

	private static final long serialVersionUID = -3143617596255316967L;
	
	private JLabel labelCodigoDeBarras;
	private JLabel labelDescricao;
	private JLabel labelPrecoVenda;
	private JLabel labelQuantidade;
	private JLabel labelCodigoUnidadeMedida;
	
	private JFormattedTextField textFieldCodigoDeBarras;
	private JFormattedTextField  textFieldDescricao;
	private JFormattedTextField textFieldPrecoVenda;
	private JFormattedTextField textFieldQuantidade;
	private JFormattedTextField textFieldCodigoUnidadeMedida;
	
	public PanelProduto(){
		
		setLayout(new GridLayout(5, 1,3,10));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		initialize();
		
	}
	
	private void initialize(){
		add(getLabelCodigoDeBarras());
		add(getTextFieldCodigoDeBarras());
		
		add(getLabelDescricao());
		add(getTextFieldDescricao());
		
		add(getLabelCodigoUnidadeMedida());
		add(getTextFieldCodigoUnidadeMedida());
		
		add(getLabelQuantidade());
		add(getTextFieldQuantidade());
		
		add(getLabelPrecoVenda());
		add(getTextFieldPrecoVenda());
	}
	
	private JLabel getLabelCodigoDeBarras() {
		if(labelCodigoDeBarras==null){
			labelCodigoDeBarras = new JLabel("C�digo de Barras: *");
			labelCodigoDeBarras.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelCodigoDeBarras;
	}
	private JLabel getLabelDescricao() {
		if(labelDescricao==null){
			labelDescricao = new JLabel("Descri��o: *");
			labelDescricao.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelDescricao;
	}
	private JLabel getLabelPrecoVenda() {
		if(labelPrecoVenda==null){
			labelPrecoVenda = new JLabel("Pre�o Venda: *");
			labelPrecoVenda.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelPrecoVenda;
	}
	private JLabel getLabelQuantidade() {
		if(labelQuantidade==null){
			labelQuantidade = new JLabel("Quantidade Venda: *");
			labelQuantidade.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelQuantidade;
	}
	private JLabel getLabelCodigoUnidadeMedida() {
		if(labelCodigoUnidadeMedida==null){
			labelCodigoUnidadeMedida = new JLabel("Unidade Medida: *");
			labelCodigoUnidadeMedida.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelCodigoUnidadeMedida;
	}
	public JFormattedTextField getTextFieldCodigoDeBarras() {
		if(textFieldCodigoDeBarras==null){
			textFieldCodigoDeBarras = new JFormattedTextField();
			MyMask.maskCodigoBarras(textFieldCodigoDeBarras);
		}
		return textFieldCodigoDeBarras;
	}
	public JFormattedTextField getTextFieldDescricao() {
		if(textFieldDescricao==null){
			textFieldDescricao = new JFormattedTextField();
			MyMask.maskDescricaoProduto(textFieldDescricao);
		}
		return textFieldDescricao;
	}
	public JFormattedTextField getTextFieldPrecoVenda() {
		if(textFieldPrecoVenda==null){
			textFieldPrecoVenda = new JFormattedTextField();
		}
		return textFieldPrecoVenda;
	}
	public JFormattedTextField getTextFieldQuantidade() {
		if(textFieldQuantidade==null){
			textFieldQuantidade = new JFormattedTextField();
		}
		return textFieldQuantidade;
	}
	public JFormattedTextField getTextFieldCodigoUnidadeMedida() {
		if(textFieldCodigoUnidadeMedida==null){
			textFieldCodigoUnidadeMedida = new JFormattedTextField();
			MyMask.maskUnidadeMedida(textFieldCodigoUnidadeMedida);
		}
		return textFieldCodigoUnidadeMedida;
	}
}
