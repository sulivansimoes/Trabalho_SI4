package br.edu.univas.si.model.dao.processes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe contém métodos responsáveis por Inserir, deletar e alterar cadastro de Usuario no banco de dados 
 * @author Súlivan Simões Silva
 */
public class UsuarioDAO {
	
	public void insertNewUsuario(UsuarioTO usuario) throws UsuarioException{
		
		String sql = "INSERT INTO Usuario "
				   + " (cpf, nome, senha, caixa, administrador)"
				   + " VALUES(?, ?, ?, ?, ?)";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, usuario.getCpf());
				statement.setString(2, usuario.getNome());
				statement.setString(3, usuario.getSenha());
				statement.setBoolean(4, usuario.isCaixa());
				statement.setBoolean(5, usuario.isGerente());
				
				statement.execute();
				
		}catch (Exception e ){
			throw new UsuarioException("Erro ao tentar salvar "+ usuario.getCpf()+" - "
									  + usuario.getNome()+"\n"
									  + e );
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public void deleteUsuario(String cpf) throws UsuarioException{
		
		String sql = "DELETE FROM Usuario"
				   + " WHERE cpf = ?";
		
		Connection connection = null;
		
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, cpf);
				
				statement.execute();
		}catch (Exception e){
			new UsuarioException("Erro ao tentar excluir "+ cpf+"\n"
								+ e);
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateUsuario(UsuarioTO usuario) throws UsuarioException{
		
		String sql = "UPDATE Usuario"
				   + " SET nome = ?, caixa = ?,  administrador = ?, senha = ?"
				   + " WHERE cpf = ?";
		
		Connection connection = null;
		
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, usuario.getNome());
				statement.setBoolean(2, usuario.isCaixa());
				statement.setBoolean(3, usuario.isGerente());
				statement.setString(4, usuario.getSenha());
				
				statement.setString(5, usuario.getCpf());
				
				statement.execute();
		}catch(Exception e) {
			throw new UsuarioException("Erro ao tentar alterar "+usuario.getCpf()+" - "
									  + usuario.getNome()+"\n"
									  + e);
		}finally {
			DBUtil.closeConnection(connection);
		}
	}

}
