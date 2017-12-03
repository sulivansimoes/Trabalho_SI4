package br.edu.univas.si.view.realizarvenda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.listeners.PressTeclaListener;
import br.edu.univas.si.view.util.MyMask;

public class PanelLabelsVenda extends JPanel {

	private static final long serialVersionUID = 7353931951702424129L;
	
	private JLabel labelProduto;
	private JLabel labelTotal;
	private JLabel labelCalculoTotal;
	private JFormattedTextField cpoProduto;
	
	private PressTeclaListener listener;
	
	
	public PanelLabelsVenda() {
		setLayout(new FlowLayout()); 
		setPreferredSize(new Dimension(500, 0));
		initialize();
	}

	private void initialize() {
		add(getLabelProduto());
		add(getTextFieldCpoProduto());
		add(getLabelTotal());
		add(getLabelCalculoTotal());
	}
	
	private JLabel getLabelProduto(){
		if(labelProduto==null){
			labelProduto = new JLabel("Produto ");
			labelProduto.setFont(new Font("Century",Font.BOLD,25));
		}		
		return labelProduto;
	}
	
	public JFormattedTextField getTextFieldCpoProduto(){
		if(cpoProduto==null){
			cpoProduto = new JFormattedTextField();
			cpoProduto.setColumns(30);
			cpoProduto.setPreferredSize(new Dimension(40, 40));
			cpoProduto.setFont(new Font("Century",Font.PLAIN,18));
			cpoProduto.grabFocus();
			cpoProduto.setSelectedTextColor(Color.red);
			MyMask.maskCodigoBarras(cpoProduto);
			cpoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
	              public void keyPressed(java.awt.event.KeyEvent evt) {
	                  if (evt.getKeyCode() == KeyEvent.VK_ENTER){ //caso precionado enter
	                	  pressTeclaEnter();
	                  }
	               }
	           });
		}
		return cpoProduto;
	}
	
	private JLabel getLabelTotal(){
		if(labelTotal==null){
			labelTotal = new JLabel("Total");
			labelTotal.setBorder(new EmptyBorder(200, 200, 3, 200));
			labelTotal.setFont(new Font("Century",Font.BOLD,30));
		}
		return labelTotal;
	}
	
	public JLabel getLabelCalculoTotal() {
		if(labelCalculoTotal==null){
			labelCalculoTotal = new JLabel("0,00");
			labelCalculoTotal.setFont(new Font("Century",Font.BOLD,25));
			labelCalculoTotal.setForeground(Color.RED);
		}
		return labelCalculoTotal;
	}	
	
	public void setPressTeclaPerformed(PressTeclaListener listener){
		this.listener = listener; //seta ouvinte.
	}
		
	private void pressTeclaEnter(){
		listener.pressKeyPerformed();
	}
}
