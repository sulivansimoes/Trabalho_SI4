package br.edu.univas.si.view.realizarvenda;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.univas.si.view.util.MyMask;

public class JTextProdutoAndLabels extends JPanel{

	private static final long serialVersionUID = 2644673785275200541L;
	
	private JFormattedTextField textProduto;
	private JLabel labelValorTotal;
	
	public JTextProdutoAndLabels(){
		initialize();
	}
	
	private void initialize(){
		this.add(getTextProduto());
		this.add(getLabelValorTotal());
	}
	
	private JFormattedTextField getTextProduto() {
		if(textProduto==null){
			textProduto = new JFormattedTextField();
			MyMask.maskCodigoBarras(textProduto);
		}
		return textProduto;
	}
	private JLabel getLabelValorTotal() {
		if(labelValorTotal==null){
			labelValorTotal = new JLabel("Valor Total");
		}
		return labelValorTotal;
	}
}
