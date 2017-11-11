package br.edu.univas.si.runners.inserts;

import br.edu.univas.si.model.dao.processes.ProdutoDAO;
import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.model.util.Encryption;

public class JDBCRunnerInsertUnidadeMedida {

//	public static void main(String[] args) {
//		UnidadeMedidaDAO unidadeMedidaDAO = new  UnidadeMedidaDAO();
//		UnidadeMedidaTO unidadeMedidaTO = new 	UnidadeMedidaTO("un", "unidade");
//		
//		try {
//			unidadeMedidaDAO.insertNewUnidadeMedida(unidadeMedidaTO);
//			System.out.println("Sucesso ao salvar unidade de medida");
//			
//		} catch (UnidadeMedidaException e) {
//			e.printStackTrace();
//		}
//	}
	
//	public static void main(String[] args) {
//		UsuarioDAO usuarioDAO = new  UsuarioDAO();
//		UsuarioTO usuarioTO = new 	UsuarioTO(23456787332L,"Maria Luiza", true, true, "minhasenha");
//		
//		try {
//			usuarioDAO.insertNewUsuario(usuarioTO);
//			System.out.println("Sucesso ao salvar unidade de medida");
//			
//		} catch (UsuarioException e) {
//			e.printStackTrace();
//		}
//	}
////	
//	public static void main(String[] args) {
//		ProdutoDAO produtoDAO = new  ProdutoDAO();
//		ProdutoTO produtoTO = new 	ProdutoTO(123948L,"coca cola",9.50f,"pt");
//		
//		try {
//			produtoDAO.insertNewProduto(produtoTO);
//			System.out.println("Sucesso ao salvar unidade de medida");
//			
//		} catch (ProdutoException e) {
//			e.printStackTrace();
//		}
//	}
}
