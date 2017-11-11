package br.edu.univas.si.runners.updates;

import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.model.util.Encryption;

public class JDBCRunnerUpdateUsuario {

	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioTO usuarioTO = new  UsuarioTO(1332355522L, "Rafaela", true,false,Encryption.encrypt("rafaelatavares"));
		try {
			usuarioDAO.updateUsuario(usuarioTO);
			System.out.println("Alterado com sucesso");
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}

}
