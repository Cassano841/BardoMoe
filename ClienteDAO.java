package br.com.ifrsrestinga.progii.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				//Integer id = cliente.getId();
				String nome = cliente.getNome();
				String cpf = cliente.getCPF();
				String email = cliente.getEmail();
				Integer conta = cliente.getConta(); 
				String senha = cliente.getSenha();
				
				//prepara.setInt(1,id);
				prepara.setString(1,nome); //inserindo nome no primeiro '?' 
				prepara.setString(2,cpf); //inserindo nome no segundo '?' 
				prepara.setString(3,email); //inserindo nome no terceiro '?'
				prepara.setInt(4,conta);
				prepara.setString(5,senha);
				//executando no banco de dados o comando sql
				prepara.execute();   //execute retorna um booleano
				prepara.close();

				System.out.println("Cliente registrado com sucesso!");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}

		public void atualizarCliente(Cliente cliente) {
			String sql = "update cliente set nome=(?) where cpf=?";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				//substitindo os pontos de interrogacao com os dados
				
				String cpf = cliente.getCPF();
				String nome = cliente.getNome();
				//int conta = cliente.getConta();
				//String senha = cliente.getSenha();
				//int id = cliente.getId();
				
				prepara.setString(1,nome);
				prepara.setString(2,cpf);
				//prepara.setInt(2,conta); 
				//prepara.setString(3,senha); 
				//prepara.setInt(4,id); //atualizando pelo id que eh inteiro
				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Alteração de informações do cliente realizada com sucesso!");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
		public void deletarCliente (Cliente cliente){
			//montando o sql
			String sql = "DELETE FROM cliente WHERE id=?";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				
				int id = cliente.getId();
				prepara.setInt(1,id); //deletando pelo id que eh inteiro
				
				//executando no banco de dados o comando sql
				prepara.execute();
				prepara.close();

				System.out.println("Operação realizada com sucesso, cliente");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
		}
		
		public List<Cliente> listarTodos(){ //procurar todos nao tem parametro
			
			List<Cliente> listaDeUsuarios = new ArrayList<Cliente>();
			
			//montando o sql
			String sql = "SELECT * FROM cliente";
			
			try{
				//preparando PreparedStatment com o SQL
				//quem prepara eh o connection
				PreparedStatement prepara = con.prepareStatement(sql);
				//executando ---CONSULTA--- no banco de dados o comando sql
				ResultSet resultado = prepara.executeQuery(); //retorna resultado da consulta da query -> tipo ResultSet
				
				while(resultado.next()){ //buscando valor das colunas, registro por registro
					
					Cliente cliente  = new Cliente();

					int id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					String cpf = resultado.getString("cpf");
					String email = resultado.getString("email");
					int conta = resultado.getInt("conta");
					String senha = resultado.getString("senha");

					cliente.setId(id);
					cliente.setNome(nome);
					cliente.setCPF(cpf);
					cliente.setEmail(email);
					cliente.setConta(conta);
					cliente.setSenha(senha);

					listaDeUsuarios.add(cliente);
				}
				prepara.close();

				System.out.println("Listando Todos os Registros");

			} catch(SQLException e){ 
				//se comando sql nao estiver correto ira imprimir o erro gerado
				e.printStackTrace();
			}
			
			return listaDeUsuarios;
		}
		//metodos auxiliares de CRUD
		public Cliente procurarPorId(Integer id){ //procurar pelo id

			//montando o sql
			String sql = "SELECT * FROM cliente WHERE id = ?";
					
			Cliente cliente = null;

			try{
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setInt(1,id); //informando o id que deve ser buscado

				ResultSet resultado = prepara.executeQuery(); 
						
					if (resultado.next()){ 	
						cliente = new Cliente();
							
							 //colocando id buscado (resultante) para objeto usuario
							id = resultado.getInt("id");
							String nome = resultado.getString("nome");
							String cpf = resultado.getString("cpf");
							String email = resultado.getString("email");
							Integer conta = resultado.getInt("conta");
							String senha = resultado.getString("senha");

							cliente.setId(id);
							cliente.setNome(nome);
							cliente.setCPF(cpf);
							cliente.setEmail(email);
							cliente.setConta(conta);
							cliente.setSenha(senha);
						}
						prepara.close();
						System.out.println("Listando Registro do ID: " + id);

					} catch(SQLException e){ 
						//se comando sql nao estiver correto ira imprimir o erro gerado
						e.printStackTrace();
					}
					return cliente;
				}

}
