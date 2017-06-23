package br.com.ifrsrestinga.progii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	public static Connection getConnection(){
		Connection con = null;
		
		String url_mysql = "jdbc:mysql://localhost:3306/barDoMoe";
		String usuario_mysql = "root";
		String senha_mysql = "cassano841!";

		try{ 
			con = DriverManager.getConnection(url_mysql,usuario_mysql,senha_mysql);
			//fiz esta alteração para ficar mais legivel e também resolver um warning do mysql
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo","root", "root"); 
			System.out.println("Conectado com sucesso!");
		}catch (SQLException e){
			System.out.println("Falha na conexao");
		}
		return con;
	}
}