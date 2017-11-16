package br.edu.univas.si.runners.updates;

import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;

public class JDBCRunnerUpdateUnidadeMedida {

	public static void main(String[] args) {
		
		UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
		UnidadeMedidaTO unidadeMedidaTO = new  UnidadeMedidaTO("pt", "pote");
		
		try {
			unidadeMedidaDAO.updateUnidadeMedida(unidadeMedidaTO);
			System.out.println("Alterado com sucesso");
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}

}
