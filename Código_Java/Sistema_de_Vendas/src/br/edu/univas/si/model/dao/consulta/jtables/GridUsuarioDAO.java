package br.edu.univas.si.model.dao.consulta.jtables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe cont�m m�todo responsavel por retornar lista de todos Usuarios cadastrados no banco de dados.
 * @author S�livan Sim�es Silva
 */
public class GridUsuarioDAO {
	
	public ArrayList<UsuarioTO> populateGridUsuario() throws UsuarioException{
		
		ArrayList<UsuarioTO> list = new ArrayList<UsuarioTO>() ;
		String sql = "SELECT cpf,nome,caixa,administrador FROM Usuario"
				   + " ORDER BY nome";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					UsuarioTO usuario  = new UsuarioTO(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getBoolean(4));
					list.add(usuario);
				}
			
				return list;
		}catch(Exception e){
			throw new UsuarioException("Erro ao fazer consulta em GridUsuarioDAO \n"+e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}

}
