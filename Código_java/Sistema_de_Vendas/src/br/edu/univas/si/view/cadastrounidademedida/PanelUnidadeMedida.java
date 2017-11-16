package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.view.util.MyMask;

public class PanelUnidadeMedida extends JPanel{
	
	private static final long serialVersionUID = 6064706009774464765L;
	
	private JLabel labelCodigo;
	private JLabel labelDescricao;
	private JFormattedTextField textFieldCodigo;
	private JFormattedTextField textFieldDescricao;
	
	
	public PanelUnidadeMedida(){
		setLayout(new GridLayout(2, 2,3,10));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		initialize();
	}
	
	private void initialize(){
		add(getLabelCodigo());
		add(getTextFieldCodigo());
		add(getLabelDescricao());
		add(getTextFieldDescricao());
	}
	
	private JLabel getLabelCodigo(){
		if(labelCodigo ==null){
			labelCodigo = new JLabel("Codigo: *");
			labelCodigo.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelCodigo;
	}
	
	private JLabel getLabelDescricao(){
		if(labelDescricao==null){
			labelDescricao = new JLabel("Descri��o: *");
			labelDescricao.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelDescricao;
	}
	
	public JFormattedTextField getTextFieldCodigo(){
		if(textFieldCodigo==null){
			textFieldCodigo = new JFormattedTextField();
			MyMask.maskUnidadeMedida(textFieldCodigo);
		}
		return textFieldCodigo;
	}
	
	public JFormattedTextField getTextFieldDescricao(){
		if(textFieldDescricao==null){
			textFieldDescricao = new JFormattedTextField();			
		}
		return textFieldDescricao;
	}
}
