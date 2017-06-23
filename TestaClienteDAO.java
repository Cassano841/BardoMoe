package br.com.ifrsrestinga.progii.testes;

import java.util.Scanner;

import br.com.ifrsrestinga.progii.entidades.Cliente;
import br.com.ifrsrestinga.progii.jdbc.ClienteDAO;

public class TestaClienteDAO {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int op = 0;
		System.out.println("Informe qual ação deseja realizar:");
		System.out.println("--------------------------");
		System.out.println("|1 - Adicionar Cliente   |");
		System.out.println("|2 - Atualizar Cliente   |");
		System.out.println("|3 -  Deletar Cliente    |");
		System.out.println("|4 -  Listar Clientes    |");
		System.out.println("|5 - Procurar Id Cliente |");
		System.out.println("|6 -  Procurar Por Nome  |");
		System.out.println("|7 - Procurar Por Login  |");
		System.out.println("--------------------------");
		op = n.nextInt();
		
		switch (op) {
		case 1:
			salvarCliente();
			break;
		case 2:
			atualizarCliente();
			break;
		case 3:
			//deletarCliente();
			break;
		case 4:
			//testeListarTodos();
			//break;
		case 5:
			//testeProcurarPorId();
			//break;
		case 6:
			//testeProcurarPorNome();
			//break;
		case 7:
			//testeProcurarPorLogin();
			//break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	private static void salvarCliente() {
		Scanner n = new Scanner(System.in);
		Cliente cliente  = new Cliente();
		
		//cliente.setId(1);
		System.out.println("Digite o nome do cliente:");
		cliente.setNome(n.next());
		System.out.println("Digite o CPF do cliente:");
		cliente.setCPF(n.next());
		System.out.println("Digite o email do cliente:");
		cliente.setEmail(n.next());
		System.out.println("Digite a conta do cliente:");
		cliente.setConta(n.next());
		System.out.println("Digite a senha do cliente");
		cliente.setSenha(n.next());
		
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.salvarCliente(cliente);
	}
	
	private static void atualizarCliente() {
		Scanner n = new Scanner(System.in);
		Cliente cliente = new Cliente();
				
		cliente.setId(1);
		System.out.println("Digite o novo nome do cliente:");
		cliente.setNome(n.next());
		System.out.println("Digite o novo CPF do cliente:");
		cliente.setCPF(n.next());
		System.out.println("Digite o novo email do cliente:");
		cliente.setEmail(n.next());
		System.out.println("Digite a nova conta do cliente:");
		cliente.setConta(n.next());
		System.out.println("Digite a nova senha do cliente");
		cliente.setSenha(n.next());
		
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.atualizarCliente(cliente);
	}
}