package br.edu.univas.si.model.dao.processes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.model.util.DBUtil;

public class ProdutoDAO {

	public void insertNewProduto(ProdutoTO produto) throws ProdutoException{
		
		String sql = "INSERT INTO Produto"
				   + " (codigo_de_barras, descricao, preco_venda, quantidade, codigo_um)"
				   + " VALUES(?, Upper(?), ?, ?, Upper(?))";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setLong(1, produto.getCodigoDeBarras());
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
	
	public void deleteProduto(long codidoBarras) throws ProdutoException{
		
		String sql = "DELETE FROM Produto"
				   + " WHERE codigo_de_barras = ?";
		
		Connection connection= null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setLong(1, codidoBarras);
				
				statement.execute();
		}catch (Exception e){
			throw new ProdutoException("Erro ao tentar excluir "+codidoBarras+" - "
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
				
				statement.setLong(5, produto.getCodigoDeBarras());
				
				statement.execute();
		}catch (Exception e){
			throw new ProdutoException("Erro ao alterar produto "+produto.getCodigoDeBarras()+" - "
									  + produto.getDescricao()+"\n"
									  + e);			
		}finally{
			DBUtil.closeConnection(connection);
		}
	}

}