package br.edu.univas.si.view.login;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.view.util.MyMask;

public class PanelLogin extends JPanel{

	private static final long serialVersionUID = -8455360724520146986L;

	private JFormattedTextField textFieldUser;
	private JPasswordField textFieldSenha;
	private JLabel labelUser;
	private JLabel labelSenha;
	
	public PanelLogin(){
		setBorder(new EmptyBorder(10, 20, 20, 20));
		
		setLayout(new GridLayout(2,2,10,10));
				
		initialize();
	}
	
	private void initialize(){
		
		add(getLabelUser());
		add(getTextFieldUser());
		add(getLabelSenha());
		add(getTextFieldSenha());
		
	}
	
	private JLabel getLabelUser(){
		if(labelUser==null){
			labelUser = new JLabel("Usuário: ");
			labelUser.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelUser;
	}
	
	public JFormattedTextField getTextFieldUser() {
		if(textFieldUser==null){
			textFieldUser = new JFormattedTextField();
			MyMask.maskCpf(textFieldUser);
		}
		return textFieldUser;
	}
	
	private JLabel getLabelSenha(){
		if(labelSenha==null){
			labelSenha = new JLabel("Senha: ");
			labelSenha.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelSenha;
	}

	public JPasswordField getTextFieldSenha() {
		if(textFieldSenha==null){
			textFieldSenha = new JPasswordField();
			textFieldSenha.setColumns(20);
		}
		return textFieldSenha;
	}	
}
