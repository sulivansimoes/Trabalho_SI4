package br.edu.univas.si.startaplication;

import br.edu.univas.si.controller.principal.ControllerLogin;

public class StartAplication {
	
	public static void main(String[] args) {
		
		//Aplicação só inicia se usuário for autenticado...
		ControllerLogin controllerLogin = new ControllerLogin();
		controllerLogin.inititalize();		
	}

}
