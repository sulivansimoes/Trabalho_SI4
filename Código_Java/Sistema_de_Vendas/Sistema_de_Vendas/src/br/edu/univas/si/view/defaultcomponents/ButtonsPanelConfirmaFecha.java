package br.edu.univas.si.view.defaultcomponents;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.view.util.MyColor;

public class ButtonsPanelConfirmaFecha extends JPanel {

	private static final long serialVersionUID = -4746675624105735520L;
	
	private JButton confirmaButton;
	private JButton fechaButton;
	
	private ArrayList<ButtonsListenersConfirmaFecha> listeners = new ArrayList<>();
	
	public ButtonsPanelConfirmaFecha(){
		initialize();
	}
	
	private void initialize(){
		
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setLayout(new FlowLayout());		 //TODO avaliar
		this.setPreferredSize(new Dimension(0, 80));
		
		add(getConfirmaButton());
		add(getFechaButton());		
	}
	
	private JButton getConfirmaButton(){
		if(confirmaButton == null){
			confirmaButton = new JButton("Confirmar");
			confirmaButton.setBackground(MyColor.DEEP_SKY_BLUE);
			confirmaButton.setFont(new Font("Century",Font.PLAIN,14));
			confirmaButton.setPreferredSize(new Dimension(100, 40));
			confirmaButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					confirmaClicked();
				}
			});
		}		
		return confirmaButton;
	}
	
	private JButton getFechaButton(){
		if(fechaButton==null){
			fechaButton = new JButton("Fechar");
			fechaButton.setBackground(MyColor.WHITE_SMOKE);
			fechaButton.setFont(new Font("Century",Font.PLAIN,14));
			fechaButton.setPreferredSize(new Dimension(100,40));
			fechaButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fechaClicked();					
				}
			});
			 
		}
		return fechaButton;
	}
	
	public void addButtonsListenersConfirmaFecha(ButtonsListenersConfirmaFecha listener){
		listeners.add(listener); //adicionando ouvinte no array de ouvintes
	}
	
	private void confirmaClicked(){
		for(ButtonsListenersConfirmaFecha l : listeners){
			l.confirmaPerformed();
		}
	}
	
	private void fechaClicked(){
		for(ButtonsListenersConfirmaFecha l : listeners){
			l.fechaPerformed();
		}
	}

}
