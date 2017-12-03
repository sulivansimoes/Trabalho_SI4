package br.edu.univas.si.view.menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.controller.principal.ControllerPrincipal;
import br.edu.univas.si.view.util.MyJFrame;

public class JmenuBar extends MyJFrame {

	private static final long serialVersionUID = 5137564865427383013L;
	
	private JMenuBar menuBar;
	
	private JMenu jmCadastro;
	private JMenu jmVendas;
	
	private JMenuItem jmCadastroUnidadeMedida;
	private JMenuItem jmCadastroProduto;
	private JMenuItem jmCadastroUsuarios;
	private JMenuItem jmRealizarVendas;
	
	private ControllerPrincipal controller;
	
	
	public JmenuBar(ControllerPrincipal controller) {
		super("Sistema de Vendas");
		
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		initialize();
		
		setPreferredSize(new Dimension(700, 600));
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		menuBar = new JMenuBar();
		menuBar.setBorder(new EmptyBorder(30, 30, 30, 30)); 
		
		//Cadastros
		getMenuCadastro().add(getJmCadastroUnidadeMedida());
		getMenuCadastro().add(getJmCadastroProduto());
		getMenuCadastro().add(getJmCadastroUsuarios());
		menuBar.add(getMenuCadastro());
		
		//Vendas
		getMenuVendas().add(getJmRealizarVendas());
		menuBar.add(getMenuVendas());
		
		add(menuBar);
	}
	
	private JMenu getMenuCadastro() {
		if(jmCadastro==null){
			jmCadastro = new JMenu("Cadastros");
			jmCadastro.setFont(new Font("Century",Font.PLAIN,16));
			jmCadastro.add(getJmCadastroProduto());
		}
		return jmCadastro;
	}
	
	private JMenu getMenuVendas() {
		if(jmVendas==null){
			jmVendas = new JMenu("Vendas");
			jmVendas.setFont(new Font("Century",Font.PLAIN,16));
			
		}
		return jmVendas;
	}
	
	private JMenuItem getJmCadastroUnidadeMedida() {
		if(jmCadastroUnidadeMedida==null){
			jmCadastroUnidadeMedida = new JMenuItem("Unidade Medida");
			jmCadastroUnidadeMedida.setFont(new Font("Century",Font.PLAIN,15));
			jmCadastroUnidadeMedida.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.callScreenUnidadeMedida();
				}
			});
		}
		return jmCadastroUnidadeMedida;
	}
	
	private JMenuItem getJmCadastroProduto() {
		if(jmCadastroProduto==null){
			jmCadastroProduto = new JMenuItem("Produto");
			jmCadastroProduto.setFont(new Font("Century",Font.PLAIN,15));
			jmCadastroProduto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.callScrennProduto();					
				}
			});
		}
		return jmCadastroProduto;
	}
	
	private JMenuItem getJmCadastroUsuarios() {
		if(jmCadastroUsuarios==null){
			jmCadastroUsuarios = new JMenuItem("Usuário");
			jmCadastroUsuarios.setFont(new Font("Century",Font.PLAIN,15));
			jmCadastroUsuarios.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.callScreenUsuario();					
				}
			});
		}
		return jmCadastroUsuarios;
	}
	
	private JMenuItem getJmRealizarVendas() {
		if(jmRealizarVendas==null){
			jmRealizarVendas = new JMenuItem("Atendimento");
			jmRealizarVendas.setFont(new Font("Century",Font.PLAIN,15));
			jmRealizarVendas.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.callScreenVendas();
				}
			});
		}
		return jmRealizarVendas;
	}
}
