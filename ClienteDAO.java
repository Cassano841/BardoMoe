package br.com.ifrsrestinga.progii.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifrsrestinga.progii.entidades.Cliente;

public class ClienteDAO {
	
	private Connection con = Conexao.getConnection();
	
		public void salvarCliente(Cliente cliente){
			//montando o sql
			String sql = "INSERT INTO cliente(nome, cpf, email, conta, senha) values (?,?,?,?,?)";
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				//substitindo os pontos de interrogacao com os dados
				Integer id = cliente.getId();
				String nome = cliente.getNome();
				String cpf = cliente.getCPF();
				String email = cliente.getEmail();
				String conta = cliente.getConta();
				String senha = cliente.getSenha();
				
				prepara.setInt(1,id+1);
				prepara.setString(2,nome); //inserindo nome no primeiro '?' 
				prepara.setString(3,cpf); //inserindo nome no segundo '?' 
				prepara.setString(4,email); //inserindo nome no terceiro '?'
				prepara.setString(5,conta);
				prepara.setString(6,senha);
				//executando no banco de dados o comando sql
				prepara.execute();   //execute retorna um booleano
				prepara.close();

				System.out.println("Registro cliente -salvo- com sucesso");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}

		public void atualizarCliente(Cliente cliente) {
			String sql = "update cliente set nome=('Bruna') where id=1";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				//substitindo os pontos de interrogacao com os dados
				
				String nome = cliente.getNome();
				String conta = cliente.getConta();
				String senha = cliente.getSenha();
				int id = cliente.getId();
				
				prepara.setString(1,nome); 
				prepara.setString(2,conta); 
				prepara.setString(3,senha); 
				prepara.setInt(4,id); //atualizando pelo id que eh inteiro
				
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