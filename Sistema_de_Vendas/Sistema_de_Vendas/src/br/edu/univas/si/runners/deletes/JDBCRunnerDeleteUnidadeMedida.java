package br.edu.univas.si.runners.deletes;

import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;

public class JDBCRunnerDeleteUnidadeMedida {

	public static void main(String[] args) {
		
		UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
		try {
			unidadeMedidaDAO.deleteUnidadeMedida("PT");
			System.out.println("Deletado com sucesso");
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}

}
