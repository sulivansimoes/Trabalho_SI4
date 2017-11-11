package br.edu.univas.si.view.realizarvenda;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.edu.univas.si.view.util.MyColor;

public class ButtonsPanelListenersVendas extends JPanel {

	private static final long serialVersionUID = -6403228859985244533L;
	
	private JButton buttonFinaliza;
	private JButton buttonCancela;
	private JButton buttonAbandona;
	
	private ArrayList<ButtonsListenersVendas> listeners = new ArrayList<>();
	
	
	public ButtonsPanelListenersVendas(){
		setLayout(new FlowLayout());
		initialize();
	}
	
	private void initialize(){
		add(getButtonFinaliza());
		add(getButtonAbandona());
		add(getButtonCancela());
	}
	
	private JButton getButtonFinaliza() {
		if(buttonFinaliza==null){
			buttonFinaliza = new JButton("Finaliza Venda");
			buttonFinaliza.setFont(new Font("Century",Font.PLAIN,14));
			buttonFinaliza.setBackground(MyColor.SKY_BLUE2);
			buttonFinaliza.setPreferredSize(new Dimension(100, 40));
			buttonFinaliza.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					finalizaClicked();					
				}
			});
		}
		return buttonFinaliza;
	}
	private JButton getButtonCancela() {
		if(buttonCancela==null){
			buttonCancela = new JButton("Cancela Venda");
			buttonCancela.setFont(new Font("Century",Font.PLAIN,14));
			buttonCancela.setBackground(MyColor.WHITE_SMOKE);
			buttonCancela.setPreferredSize(new Dimension(100, 40));
			buttonCancela.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cancelaClicked();					
				}
			});
		}
		return buttonCancela;
	}
	private JButton getButtonAbandona() {
		if(buttonAbandona==null){
			buttonAbandona = new JButton("Abandona Venda");
			buttonAbandona.setFont(new Font("Century",Font.PLAIN,14));
			buttonAbandona.setBackground(MyColor.WHITE_SMOKE);
			buttonAbandona.setPreferredSize(new Dimension(100, 40));
			buttonAbandona.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					abandonaClicked();
				}
			});
		}
		return buttonAbandona;
	}
	
	public void addButtonListenersVendas(ButtonsListenersVendas listener){
		listeners.add(listener); //Adicionando ouvinte no array de ouvintes
	}
	
	private void finalizaClicked(){
		for(ButtonsListenersVendas l : listeners){
			l.finalizaPerformed();
		}
	}
	
	private void cancelaClicked(){
		for(ButtonsListenersVendas l : listeners){
			l.cancelaPerformed();
		}
	}
	
	private void abandonaClicked(){
		for(ButtonsListenersVendas l : listeners){
			l.abandonaPerformed();
		}
	}
}
