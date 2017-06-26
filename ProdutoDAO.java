package br.com.ifrsrestinga.progii.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				Integer precoUnitario = produto.getcodigoProduto();
				
				//prepara.setInt(1, id);
				prepara.setInt(1, codigo);
				prepara.setString(2, nomeProduto);
				prepara.setInt(3,precoUnitario);
				
				prepara.execute();
				prepara.close();
				
				System.out.println("Registro produto -salvo- com sucesso");
			}catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
		}
	}
		public void atualizarProduto(Produto produto) {
			String sql = "UPDATE PRODUTOS set nomeProduto=('Batata') where id=1";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				//substitindo os pontos de interrogacao com os dados
				
				Integer id = produto.getId();
				Integer codigo = produto.getcodigoProduto();
				String nomeProduto = produto.getnomeProduto();
				Integer precoUnitario = produto.getcodigoProduto();
				
				prepara.setInt(1, id);
				prepara.setInt(2, codigo);
				prepara.setString(3, nomeProduto);
				prepara.setInt(4, precoUnitario);
				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Registro cliente -alterado- com sucesso");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
}
