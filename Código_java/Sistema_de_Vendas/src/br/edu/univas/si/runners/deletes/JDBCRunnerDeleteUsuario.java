package br.edu.univas.si.runners.deletes;

import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;

public class JDBCRunnerDeleteUsuario {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try {
			usuarioDAO.deleteUsuario(132322L);
			System.out.println("Deletado com sucesso");
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}

}
