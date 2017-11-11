package br.edu.univas.si.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection openConnection() throws SQLException{
		
		try{
				Class.forName("org.postgresql.Driver");
				
				String url = "jdbc:postgresql://localhost:5432/postgres";
				String username = "postgres";
				String password = "abc123";
				
				Connection connection = DriverManager.getConnection(url, username, password);
				
				return connection;
				
		}catch(ClassNotFoundException  e){
			throw new SQLException(e);
		}	
	}

	public static void closeConnection(Connection connection){
		
		if(connection != null){
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
