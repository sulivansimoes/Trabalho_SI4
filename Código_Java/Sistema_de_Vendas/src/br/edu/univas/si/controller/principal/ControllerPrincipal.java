package br.edu.univas.si.controller.principal;

import br.edu.univas.si.controller.vendaproduto.ControllerVenda;
import br.edu.univas.si.view.cadastroproduto.FramePrincipalProduto;
import br.edu.univas.si.view.cadastrounidademedida.FramePrincipalUnidadeMedida;
import br.edu.univas.si.view.cadastrousuario.FramePrincipalUsuario;
import br.edu.univas.si.view.menu.JmenuBar;
import br.edu.univas.si.view.realizarvenda.FrameVenda;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerPrincipal {

	
	JmenuBar viewMenu;
	FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida;
	FramePrincipalProduto viewPrincipalProduto;
	FramePrincipalUsuario viewPrincipalUsuario;
	FrameVenda viewPrincipalVenda;
		
	
	public ControllerPrincipal() {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		viewMenu = new JmenuBar(this);
	}
	
	public void initialize(){
		viewMenu.setVisible(true);		
	}
	
	public void callScreenUnidadeMedida(){
		viewPrincipalUnidadeMedida = new FramePrincipalUnidadeMedida();
		viewPrincipalUnidadeMedida.setVisible(true);
	}
	
	public void callScrennProduto(){
		viewPrincipalProduto = new FramePrincipalProduto();
		viewPrincipalProduto.setVisible(true);
	}
	
	public void callScreenUsuario(){
		viewPrincipalUsuario = new FramePrincipalUsuario();
		viewPrincipalUsuario.setVisible(true);
	}
	
	public void callScreenVendas(){
		ControllerVenda controllerVenda = new ControllerVenda();
		viewPrincipalVenda = new FrameVenda(controllerVenda);
		controllerVenda.initialize();		
	}
	
}
