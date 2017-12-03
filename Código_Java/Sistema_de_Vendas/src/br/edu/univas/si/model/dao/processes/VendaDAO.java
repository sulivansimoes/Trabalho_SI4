package br.edu.univas.si.model.dao.processes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.edu.univas.si.model.exception.VendaException;
import br.edu.univas.si.model.to.CabecalhoVendaTO;
import br.edu.univas.si.model.to.ItensVendaTO;
import br.edu.univas.si.model.util.DBUtil;

public class VendaDAO {

	public void insertNewVenda(CabecalhoVendaTO cabecalho, ArrayList<ItensVendaTO> itens) throws VendaException{
		
		String sqlCabecalho = "INSERT INTO Cabecalho_Venda"
							+ " (numero_cupom, serie_cupom, data_emissao, cpf_usuario, valor_total)"
							+ " VALUES(?, ?, ?, ?, ?)";
		
		String sqlItens = "INSERT INTO Itens_Venda"
						+ " (numero_cupom, serie_cupom, item, codigo_de_barras, quantidade, valor_unitario,"
						+ "		   valor_venda, codigo_um)"
						+ "	VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statementCabecalho = connection.prepareStatement(sqlCabecalho);
				PreparedStatement statementItens = connection.prepareStatement(sqlItens);
				
				statementCabecalho.setInt(1, cabecalho.getNumeroCupom());
				statementCabecalho.setString(2, cabecalho.getSerieCupom());
				statementCabecalho.setTimestamp(3, new Timestamp(cabecalho.getDataEmissao().getTime())); 
				statementCabecalho.setString(4, cabecalho.getCpfUsuario());
				statementCabecalho.setFloat(5, cabecalho.getValorTotal());
				statementCabecalho.execute();
				
				for(ItensVendaTO item : itens){
					statementItens.setInt	(1, item.getNumeroCupom());
					statementItens.setString(2, item.getSerieCupom());
					statementItens.setInt	(3, item.getItem());
					statementItens.setString(4, item.getCodigoDeBarras());
					statementItens.setFloat	(5, item.getQuantidade());
					statementItens.setFloat (6, item.getValorVenda());
					statementItens.setFloat	(7, item.getValorVenda());
					statementItens.setString(8, item.getCodigoUnidadeMedida());
					statementItens.execute();
				}
					
		}catch (Exception e){
			throw new VendaException("Erro ao tentar gravar a venda: "+cabecalho.getNumeroCupom()+"\n"
									+ "Em class VendaDAO - insertNewVenda() \n "
									+ e); 
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public void deleteVenda(int numeroCupom, String serie ) throws VendaException{ 
		
		String sqlCabecalho = "DELETE FROM Cabecalho_Venda "
							+ " WHERE numero_cupom = ? AND serie_cupom = ?";
		
		String sqlItens = "DELETE FROM Itens_Venda "
						+ " WHERE numero_cupom = ? AND serie_cupom = ?";		
		
		Connection connection = null;		
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statementCabecalho = connection.prepareStatement(sqlCabecalho);
				PreparedStatement statementItens = connection.prepareStatement(sqlItens);
				
				statementCabecalho.setInt(1, numeroCupom);
				statementCabecalho.setString(2, serie);
				
				statementItens.setInt(1, numeroCupom);
				statementItens.setString(2, serie);			
				statementItens.execute();
				statementCabecalho.execute();
				
		}catch(Exception e){
			throw new VendaException("Erro ao tentar deletar venda: "+numeroCupom + "- Série: "+serie+"\n"+e);
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public int searchUltimaVenda(String serie) throws VendaException{
		
		String sql = "SELECT numero_cupom FROM itens_venda "
				   + " WHERE serie_cupom = ? "
				   + " ORDER BY numero_cupom DESC"; 
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, serie);
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()){
					return rs.getInt(1);
				}
				return 0;
				
		}catch(Exception e){
			throw new VendaException("Erro em class VendaDAO - searchUltimavenda() \n"+ e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
