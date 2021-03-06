package br.edu.univas.si.view.cadastrousuario;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.view.util.MyMask;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 6008535953111164538L;

	private JLabel labelCpf;
	private JLabel labelNome;
	private JLabel labelCaixa;
	private JLabel labelAdministrador;
	private JLabel labelSenha;

	private JFormattedTextField textFieldCpf;
	private JFormattedTextField textFieldNome;
	private JCheckBox checkBoxCaixa;
	private JCheckBox checkBoxAdminstrador;
	private JPasswordField textFieldSenha;

	public PanelUsuario(){
		setLayout(new GridLayout(5, 2,3,10));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		initialize();
	}
	
	private void initialize(){
		add(getLabelCpf());
		add(getTextFieldCpf());
		add(getLabelNome());
		add(getTextFieldNome());
		add(getLabelSenha());
		add(getTextFieldsenha());
		add(getLabelAdministrador());
		add(getCheckBoxAdminstrador());
		add(getLabelCaixa());
		add(getCheckBoxCaixa());
	}
	
	private JLabel getLabelCpf() {
		if (labelCpf == null) {
			labelCpf = new JLabel("Cpf: *");
			labelCpf.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelCpf;
	}

	private JLabel getLabelNome() {
		if (labelNome == null) {
			labelNome = new JLabel("Nome: *");
			labelNome.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelNome;
	}

	private JLabel getLabelCaixa() {
		if (labelCaixa == null) {
			labelCaixa = new JLabel("Acesso caixa: ");
			labelCaixa.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelCaixa;
	}

	private JLabel getLabelAdministrador() {
		if (labelAdministrador == null) {
			labelAdministrador = new JLabel("Acesso Administrador: ");
			labelAdministrador.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelAdministrador;
	}

	private JLabel getLabelSenha() {
		if(labelSenha==null){
			labelSenha = new JLabel("Senha: *");
			labelSenha.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelSenha;
	}

	public JFormattedTextField getTextFieldCpf() {
		if(textFieldCpf==null){
			textFieldCpf = new JFormattedTextField();
			MyMask.maskCpf(textFieldCpf);
		}
		return textFieldCpf;
	}

	public JFormattedTextField getTextFieldNome() {
		if(textFieldNome==null){
			textFieldNome = new JFormattedTextField();
		}
		return textFieldNome;
	}

	public JCheckBox getCheckBoxCaixa() {
		if(checkBoxCaixa==null){
			checkBoxCaixa = new JCheckBox();
		}
		return checkBoxCaixa;
	}

	public JCheckBox getCheckBoxAdminstrador() {
		if(checkBoxAdminstrador==null){
			checkBoxAdminstrador = new JCheckBox();
		}
		return checkBoxAdminstrador;
	}

	public JPasswordField getTextFieldsenha() {
		if(textFieldSenha==null){
			textFieldSenha = new JPasswordField();
		}
		return textFieldSenha;
	}

}
