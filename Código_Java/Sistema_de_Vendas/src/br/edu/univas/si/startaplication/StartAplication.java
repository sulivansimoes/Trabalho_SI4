package br.edu.univas.si.startaplication;

import br.edu.univas.si.controller.principal.ControllerLogin;

public class StartAplication {
	
	public static void main(String[] args) {
		
		//Aplica��o s� inicia se usu�rio for atenticado...
		ControllerLogin controllerLogin = new ControllerLogin();
		controllerLogin.inititalize();		
	}

}
