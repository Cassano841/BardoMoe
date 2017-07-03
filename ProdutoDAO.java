package br.com.ifrsrestinga.progii.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifrsrestinga.progii.entidades.Cliente;
import br.com.ifrsrestinga.progii.entidades.Produto;

public class ProdutoDAO {
	
	private Connection con = Conexao.getConnection();
	
		public void salvarProduto(Produto produto) {
			//sql
			String sql = "INSERT INTO produtos (codigo, nomeProduto, precoUnitario) values (?,?,?)";
			try {
				PreparedStatement prepara = con.prepareStatement(sql);
				//substitui os ? por valores;
				
				//Integer id = produto.getId();
				Integer codigo = produto.getcodigoProduto();
				String nomeProduto = produto.getnomeProduto();
				Double precoUnitario = produto.getprecoUnitario();
				
				//prepara.setInt(1, id);
				prepara.setInt(1, codigo);
				prepara.setString(2, nomeProduto);
				prepara.setDouble(3,precoUnitario);
				
				prepara.execute();
				prepara.close();
				
				System.out.println("Produto registrado com sucesso");
			}catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
		}
	}
		public void atualizarProduto(Produto produto) {
			String sql = "UPDATE produtos set nomeProduto=(?), precoUnitario=? where codigo=?";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				//substitindo os pontos de interrogacao com os dados
				
				//Integer id = produto.getId();
				Integer codigo = produto.getcodigoProduto();
				String nomeProduto = produto.getnomeProduto();
				Integer precoUnitario = produto.getcodigoProduto();
				
				//prepara.setInt(1, id);
				prepara.setString(1, nomeProduto);
				prepara.setInt(2, precoUnitario);
				prepara.setInt(3, codigo);
				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Produto alterado com sucesso");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
		public void deletarProduto (Produto produto){
			//montando o sql
			String sql = "DELETE FROM produtos WHERE id=?";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				int id = produto.getId();
				prepara.setInt(1,id); //deletando pelo id que eh inteiro
				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Operação realizada com sucesso, produto removido!");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
		
		public Produto procurarPorCodigo(Integer codigo) {
			//montando sql
			String sql = "SELECT * FROM produtos WHERE codigo=?";
			
			Produto produto = null;
			
			try {
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setInt(1,codigo); //informando pelo id que eh inteiro
				
				ResultSet resultado = prepara.executeQuery();
				
					if(resultado.next()) {
						produto = new Produto();
						
						String nomeProduto = resultado.getString("nomeProduto");
						Integer codigoProduto = resultado.getInt("codigo");
						Integer precoUnitario = resultado.getInt("precoUnitario");
						
						
						produto.setnomeProduto(nomeProduto);
						produto.setcodigoProduto(codigoProduto);
						produto.setprecoUnitario(precoUnitario);
					}				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Informações sobre o produto:");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			
			}
			return produto;
		}
		
		public List<Produto> listarTodos(){ //procurar todos nao tem parametro
			
			List<Produto> listaDeProdutos = new ArrayList<Produto>();
			
			//montando o sql
			String sql = "SELECT * FROM produtos";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				//executando ---CONSULTA--- no banco de dados o comando sql
				ResultSet resultado = prepara.executeQuery(); //retorna resultado da consulta da query -> tipo ResultSet
				
				while(resultado.next()){ //buscando valor das colunas, registro por registro
					
					Produto produto  = new Produto();

					int id = resultado.getInt("id");
					String nomeProduto = resultado.getString("nomeProduto");
					Integer codigoProduto = resultado.getInt("codigo");
					Double precoUnitario = resultado.getDouble("precoUnitario");
					
					produto.setId(id);
					produto.setcodigoProduto(codigoProduto);
					produto.setnomeProduto(nomeProduto);
					produto.setprecoUnitario(precoUnitario);
					

					listaDeProdutos.add(produto);
				}
				prepara.close();

				System.out.println("Listando Todos os Registros de Produtos: ");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
			
			return listaDeProdutos;
		}
}
