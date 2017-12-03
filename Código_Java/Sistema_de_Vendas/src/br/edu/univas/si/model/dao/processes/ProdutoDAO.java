package br.edu.univas.si.model.dao.processes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe contém métodos responsáveis por Inserir, deletar e alterar cadastro de Produto no banco de dados 
 * @author Súlivan Simões Silva
 */

public class ProdutoDAO {

	public void insertNewProduto(ProdutoTO produto) throws ProdutoException{
		
		String sql = "INSERT INTO Produto"
				   + " (codigo_de_barras, descricao, preco_venda, quantidade, codigo_um)"
				   + " VALUES(?, Upper(?), ?, ?, Upper(?))";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, produto.getCodigoDeBarras());
				statement.setString(2, produto.getDescricao());
				statement.setFloat(3, produto.getPrecoVenda());
				statement.setFloat(4, produto.getQuantidade());
				statement.setString(5, produto.getCodigo_unidadeMedida());
				
				statement.execute();
				
		}catch( Exception e){
			throw new ProdutoException("Erro ao tentar incluir "+ produto.getCodigoDeBarras()+ " - "
									  + produto.getDescricao()+"\n"
									  + e );						
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public void deleteProduto(String codigoBarras) throws ProdutoException{
		
		String sql = "DELETE FROM Produto"
				   + " WHERE codigo_de_barras = ?";
		
		Connection connection= null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, codigoBarras);
				
				statement.execute();
		}catch (Exception e){
			throw new ProdutoException("Erro ao tentar excluir "+codigoBarras+" - "
									  + e);			
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateProduto(ProdutoTO produto) throws ProdutoException{
		
		String sql = "UPDATE Produto"
				   + " SET descricao = Upper(?), preco_venda =  ?, quantidade = ?, codigo_um = Upper(?)"
				   + " WHERE codigo_de_barras = ?";
		
		Connection connection= null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, produto.getDescricao());
				statement.setFloat(2, produto.getPrecoVenda());
				statement.setFloat(3, produto.getQuantidade());
				statement.setString(4, produto.getCodigo_unidadeMedida());
				
				statement.setString(5, produto.getCodigoDeBarras());
				
				statement.execute();
		}catch (Exception e){
			throw new ProdutoException("Erro ao alterar produto "+produto.getCodigoDeBarras()+" - "
									  + produto.getDescricao()+"\n"
									  + e);			
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	
	public ProdutoTO searchProduto(String codigoDeBarras) throws ProdutoException{
		String sql = "SELECT codigo_de_barras, descricao, preco_venda, quantidade, codigo_um"
				   + " FROM produto"
				   + " WHERE codigo_de_barras = ?";
		
		Connection connection = null;
		try{
			connection = DBUtil.openConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
						
			statement.setString(1, codigoDeBarras);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()){
				ProdutoTO produto = new ProdutoTO();
				produto.setCodigoDeBarras(rs.getString(1));
				produto.setDescricao(rs.getString(2));
				produto.setPrecoVenda(rs.getFloat(3));
				produto.setQuantidade(rs.getFloat(4));
				produto.setCodigo_unidadeMedida(rs.getString(5));
				return produto;
			}
		}catch(Exception e){
			throw new ProdutoException("Erro ao pesquisar produto em class ProdutoDAO - searchProduo() "+codigoDeBarras+"\n" + e);
		}finally{
			DBUtil.closeConnection(connection);
		}
		return  null;
	}

}