package br.edu.univas.si.view.defaultcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.edu.univas.si.view.util.MyColor;

public class ButtonsPanelCadastro extends JPanel {

	private static final long serialVersionUID = -6801362317252349009L;

	private JButton incluiButton;
	private JButton alteraButton;
	private JButton excluiButton;
	private JButton sairButton;

	private GridBagConstraints gbcIncluiButton;
	private GridBagConstraints gbcAlteraButton;
	private GridBagConstraints gbcExcluiButton;
	private GridBagConstraints gbcSairButton;
	
	private ArrayList<ButtonsListenersCadastro> listeners = new ArrayList<>();

	public ButtonsPanelCadastro() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(0,80));
		
		this.add(this.getIncluiButton(), this.getGbcIncluiButton());
		this.add(this.getAlteraButton(), this.getGbcAlteraButton());
		this.add(this.getExcuiButton(), this.getGbcExcluiButton());
		this.add(this.getSairButton(), this.getGbcSairButton());
	}

	private JButton getIncluiButton() {
		if (incluiButton == null) {
			incluiButton = new JButton("Incluir");
			incluiButton.setBackground(MyColor.WHITE_SMOKE);
			incluiButton.setFont(new Font("Century",Font.PLAIN,14));
			incluiButton.setPreferredSize(new Dimension(100, 40));
			incluiButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					incluiClicked();
				}
			});
		}
		return incluiButton;
	}

	private JButton getAlteraButton() {
		if(alteraButton == null){
			alteraButton = new JButton("Alterar");
			alteraButton.setBackground(MyColor.WHITE_SMOKE);
			alteraButton.setFont(new Font("Century",Font.PLAIN,14));
			alteraButton.setPreferredSize(new Dimension(100, 40));
			alteraButton.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					alteraClicked();
				}
			}); 
		}
		return alteraButton;
	}
	
	private JButton getExcuiButton(){
		if(excluiButton == null){
			excluiButton = new JButton("Excluir");
			excluiButton.setBackground(MyColor.WHITE_SMOKE);
			excluiButton.setFont(new Font("Century",Font.PLAIN,14));
			excluiButton.setPreferredSize(new Dimension(100, 40));
			excluiButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					excluiClicked();					
				}
			});
			
			
		}
		return excluiButton;
	}

	private JButton getSairButton() {
		if(sairButton==null){
			sairButton = new JButton("Sair");
			sairButton.setBackground(MyColor.WHITE_SMOKE);
			sairButton.setFont(new Font("Century",Font.PLAIN,14));
			sairButton.setPreferredSize(new Dimension(100, 40));
			sairButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sairClicked();					
				}
			});
		}
		return sairButton;
	}

	private GridBagConstraints getGbcIncluiButton() {
		if (gbcIncluiButton == null) {
			gbcIncluiButton = new GridBagConstraints();
			gbcIncluiButton.insets = new Insets(3, 3, 3, 3);
			gbcIncluiButton.gridx = 1;
			gbcIncluiButton.gridy = 0;
			gbcIncluiButton.fill = GridBagConstraints.BOTH;
		}
		return gbcIncluiButton;
	}

	private GridBagConstraints getGbcAlteraButton() {
		if(gbcAlteraButton == null){
			gbcAlteraButton = new GridBagConstraints();
			gbcAlteraButton.insets = new Insets(3,3,3,3);
			gbcAlteraButton.gridx = 2;
			gbcAlteraButton.gridy = 0;
		}
		return gbcAlteraButton;
	}
	
	private GridBagConstraints getGbcExcluiButton(){
		if(gbcExcluiButton ==null){
			gbcExcluiButton = new GridBagConstraints();
			gbcExcluiButton.insets = new Insets(3,3,3,3);
			gbcExcluiButton.gridx = 3;
			gbcExcluiButton.gridy = 0;
		}
		return gbcExcluiButton;
	}

	private GridBagConstraints getGbcSairButton() {
		if(gbcSairButton == null){
			gbcSairButton = new GridBagConstraints();
			gbcSairButton.insets = new Insets(3, 3, 3, 3);
			gbcSairButton.gridx = 0;
			gbcSairButton.gridy = 0;
		}
		return gbcSairButton;
	}
	
	public void addButtonsListener(ButtonsListenersCadastro listener){
		listeners.add(listener); //adiciona ouviente no array de ouvientes
	}
	
	private void incluiClicked() {
		for(ButtonsListenersCadastro l : listeners){
			l.incluiPerformed();
		}
	}
	
	private void alteraClicked(){
		for(ButtonsListenersCadastro l : listeners){
			l.alteraPerformed();
		}
	}
	
	private void excluiClicked(){
		for(ButtonsListenersCadastro l : listeners){
			l.excluiPerformed();
		}
	}
	
	private void sairClicked(){
		for(ButtonsListenersCadastro l : listeners){
			l.SairPerformed();
		}
	}
}
