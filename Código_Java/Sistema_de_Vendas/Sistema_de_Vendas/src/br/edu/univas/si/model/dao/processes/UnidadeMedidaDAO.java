package br.edu.univas.si.model.dao.processes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.model.util.DBUtil;

public class UnidadeMedidaDAO {

	public void insertNewUnidadeMedida(UnidadeMedidaTO to) throws UnidadeMedidaException{
		
		String sql = "INSERT INTO Unidade_Medida"
				   + " (codigo, descricao)"
				   + " VALUES (Upper(?), Upper(?))";
		
		Connection connection = null;
		
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, to.getCodigo());
				statement.setString(2, to.getDescricao());
								
				statement.execute();
			
		}catch (Exception e){		
			throw new UnidadeMedidaException("Erro ao tentar salvar " +to. getCodigo()+" - "
											+ to.getDescricao() +"\n"
											+ e);
		}finally {			
			DBUtil.closeConnection(connection);
		}
		
	}
	
	public void deleteUnidadeMedida(String codigo) throws UnidadeMedidaException{
			
		String sql = "DELETE FROM Unidade_Medida "
				   + "WHERE codigo = Upper(?) ";
		
		Connection connection = null;
		
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, codigo);
				
				statement.execute();
				
		}catch (Exception e){
			throw new UnidadeMedidaException("Erro ao tentar excluir "+ codigo +"\n"
											+ e);
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateUnidadeMedida(UnidadeMedidaTO to) throws UnidadeMedidaException{
		
		String sql = "UPDATE Unidade_Medida "
				   + " SET descricao = Upper(?)"
				   + " WHERE codigo = Upper(?) "; 
		
		Connection 	connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, to.getDescricao());
				statement.setString(2, to.getCodigo());
				
				statement.execute();
		}catch(Exception e){
			throw new UnidadeMedidaException("Erro tentar alterar "+ to.getCodigo()+" - "
											+ to.getDescricao()+"\n"
											+ e);
		}finally {
			DBUtil.closeConnection(connection);
		}
		
	}
}
