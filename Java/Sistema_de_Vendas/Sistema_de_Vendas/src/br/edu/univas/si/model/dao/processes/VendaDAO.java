package br.edu.univas.si.model.dao.processes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.edu.univas.si.model.exception.VendaException;
import br.edu.univas.si.model.to.CabecalhoVendaTO;
import br.edu.univas.si.model.to.ItensVendaTO;
import br.edu.univas.si.model.util.DBUtil;

public class VendaDAO {

	public void insertNewVenda(CabecalhoVendaTO cabecalho, /*ArrayList<ItensVendaTO>*/ItensVendaTO itens) throws VendaException{ //FIXME itens deve ser um array
		
		String sqlCabecalho = "INSERT INTO Cabecalho_Venda"
							+ " (numero_cupom, serie_cupom, data_emissao, valor_mercadoria, "
							+ "		   forma_pagamento, cpf, valor_desconto, valor_total)"
							+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		String sqlItens = "INSERT INTO Itens_Venda"
						+ " (numero_cupom, serie_cupom, item, codigo_de_barras, quantidade, valor_unitario,"
						+ "		   valor_venda, codigo_unidadeMedida)"
						+ "	VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statementCabecalho = connection.prepareStatement(sqlCabecalho);
				PreparedStatement statementItens = connection.prepareStatement(sqlItens);
				
				statementCabecalho.setInt	(1, cabecalho.getNumeroCupom());
				statementCabecalho.setString(2, cabecalho.getSerieCupom());
				statementCabecalho.setDate	(3, (Date) cabecalho.getDataEmissao());
				statementCabecalho.setFloat	(4, cabecalho.getValorMercadoria());
				statementCabecalho.setString(5, cabecalho.getFormaPagamento());
				statementCabecalho.setLong	(6, cabecalho.getCpfUsuario());
				statementCabecalho.setFloat	(7, cabecalho.getValorDesconto());
				statementCabecalho.setFloat	(8, cabecalho.getValorTotal());
				statementCabecalho.execute();
				
				//FIXME colocar dentro de um for
				statementItens.setInt	(1, itens.getNumeroCupom());
				statementItens.setString(2, itens.getSerieCupom());
				statementItens.setInt	(3, itens.getItem());
				statementItens.setLong	(4, itens.getCodigoDeBarras());
				statementItens.setFloat	(5, itens.getQuantidade());
				statementItens.setFloat	(6, itens.getQuantidade());
				statementItens.setFloat	(7, itens.getValorUnitario());
				statementItens.setFloat	(8, itens.getValorVenda());
				statementItens.setString(9, itens.getCodigoUnidadeMedida());
				statementItens.execute();
					
		}catch (Exception e){
			throw new VendaException("Erro ao tentar gravar a venda: "+cabecalho.getNumeroCupom()+"\n"
							  + e); 
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
	
	public void deleteVenda(CabecalhoVendaTO cabecalho, ItensVendaTO itens ) throws VendaException{ //FIXME itens deve ser um array
		
		String sqlCabecalho = "DELETE FROM Cabecalho_Venda"
							+ " WHERE numero_cupom = ?, serie_cupom = ?";
		
		String sqlItens = "DELETE FROM Itens_Venda"
						+ " WHERE numero_cupom = ?, serie_cupom = ?, item = ?";		
		
		Connection connection = null;		
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statementCabecalho = connection.prepareStatement(sqlCabecalho);
				PreparedStatement statementItens = connection.prepareStatement(sqlItens);
				
				statementCabecalho.setInt(1, cabecalho.getNumeroCupom());
				statementCabecalho.setString(2, cabecalho.getSerieCupom());
				
				//FIXME colocar dentro de um for
				statementItens.setInt(1, itens.getNumeroCupom());
				statementItens.setString(2, itens.getSerieCupom());
				statementItens.setInt(3, itens.getItem());
				
				statementCabecalho.execute();
				statementItens.execute();
				
		}catch(Exception e){
			throw new VendaException("Erro ao tentar deletar venda: "+cabecalho.getNumeroCupom()+"\n"+e);
		}finally {
			DBUtil.closeConnection(connection);
		}
	}
}
