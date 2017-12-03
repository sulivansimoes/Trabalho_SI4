package br.edu.univas.si.controller.usuario;

import br.edu.univas.si.model.dao.consulta.jtables.GridUsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.tablemodel.TableModelUsuario;

public class ControllerConsulta {

	private GridUsuarioDAO modelUsuario;
	
	
	//Popula um TableModelUsuario para retornar no JScrollPane
	public TableModelUsuario searchUsuario(){
		modelUsuario = new GridUsuarioDAO();
		try {
			return new TableModelUsuario(modelUsuario.populateGridUsuario());
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return null;
	}
}
