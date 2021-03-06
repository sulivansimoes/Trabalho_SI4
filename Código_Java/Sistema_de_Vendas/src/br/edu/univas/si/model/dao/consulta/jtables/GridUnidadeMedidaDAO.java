package br.edu.univas.si.model.dao.consulta.jtables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe cont�m m�todo responsavel por retornar lista de todos Unidade de Medida cadastrados no banco de dados.
 * @author S�livan Sim�es Silva
 */
public class GridUnidadeMedidaDAO {

	public ArrayList<UnidadeMedidaTO> populateGridUnidadeMedida() throws UnidadeMedidaException{
		
		
		ArrayList<UnidadeMedidaTO> list = new ArrayList<UnidadeMedidaTO>();
		
		String sql = "SELECT codigo, descricao FROM unidade_medida"
				   + " ORDER BY codigo";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					UnidadeMedidaTO unidade = new UnidadeMedidaTO(rs.getString(1), rs.getString(2));
					list.add(unidade);
				}
			
				return list;
		}catch(Exception e ){
			throw new UnidadeMedidaException("Erro ao fazer consulta em GridUniadeMedidaDAO \n"+e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
