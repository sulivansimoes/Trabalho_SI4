package br.edu.univas.si.model.dao.processes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.model.util.DBUtil;
import br.edu.univas.si.model.util.Encryption;

/**
 * Summary: Classe contém métodos responsáveis por autenfificar login, Inserir, deletar e alterar cadastro de Usuario no banco de dados 
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
	
	public boolean autentifica(UsuarioTO usuario) throws UsuarioException{
		
		UsuarioTO user =  searchUser(usuario.getCpf());
		
		//Senha default do usuario admin.
		if(usuario.getCpf().equals("00000000000") && usuario.getSenha().equals(Encryption.encrypt(("admin"))) ){
			return true;
		}		
		
		//Demais usuarios
		if(user==null){
			return false;
		}else if(usuario.getCpf().equals(user.getCpf()) && usuario.getSenha().equals(user.getSenha())){ 
			return true;
		}
		return false;
	}
	
	
	private UsuarioTO searchUser(String cpf) throws UsuarioException{
		
		String sql = "SELECT CPF, SENHA FROM USUARIO"
				   + " WHERE CPF = ?";
		
		
		UsuarioTO user;
		Connection connection = null;
		try{
			connection = DBUtil.openConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, cpf);

			ResultSet rs = statement.executeQuery();
			
			if(rs.next()){
				user = new UsuarioTO();
				user.setCpf(rs.getString(1));
				user.setSenhaPura(rs.getString(2)); //Seta a senha senha sem fazer criptografia no no TO, pois já chega aqui criptografada.
				return user;
			}
			
		}catch(Exception e){
			new UsuarioException("Erro ao fazer consulta do usuario em Class.UsuarioDAO - searchUser() \n"+e);
		}finally{
			DBUtil.closeConnection(connection);
		}
		
		return null ;
	}
}
