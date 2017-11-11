package br.edu.univas.si.model.dao.consulta.jtables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.model.util.DBUtil;

public class GridProdutoDAO {

	public ArrayList<ProdutoTO> populateGridProduto() throws ProdutoException{
		
		ArrayList<ProdutoTO> list = new ArrayList<ProdutoTO>();
		
		String sql = "SELECT codigo_de_barras, descricao, codigo_um, preco_venda"
				   + " FROM Produto"
				   + " ORDER BY descricao";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
			
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					ProdutoTO produto = new ProdutoTO(rs.getLong(1), rs.getString(2), rs.getFloat(4), rs.getString(3));	
					list.add(produto);
				}
				
				return list;
				
		}catch(Exception e){
			throw new ProdutoException("Erro ao carregar grid produto em GridProdutoDAO \n"+e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}