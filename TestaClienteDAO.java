package br.com.ifrsrestinga.progii.testes;

import java.util.List;
import java.util.Scanner;

import br.com.ifrsrestinga.progii.entidades.Cliente;
import br.com.ifrsrestinga.progii.jdbc.ClienteDAO;

public class TestaClienteDAO{
	
	public TestaClienteDAO(){

/*{

	public static void main(String[] args) {
	
	*/
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
			deletarCliente();
			break;
		case 4:
			testeListarTodos();
			break;
		case 5:
			testeProcurarPorId();
			break;
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
		// MÉTODO SALVAR CLIENTE
	private static void salvarCliente() {
		Scanner n = new Scanner(System.in);
		Cliente cliente  = new Cliente();

		System.out.println("Digite o nome do cliente:");
		cliente.setNome(n.nextLine());
		System.out.println("Digite o CPF do cliente:");
		cliente.setCPF(n.next());
		System.out.println("Digite o email do cliente:");
		cliente.setEmail(n.next());
		System.out.println("Digite a conta do cliente:");
		cliente.setConta(n.nextInt());
		System.out.println("Digite a senha do cliente");
		cliente.setSenha(n.next());
		
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.salvarCliente(cliente);
	}
		// MÉTODO ATUALIZAR INFORMAÇÕES DO CLIENTE
	private static void atualizarCliente() {
		Scanner n = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
		System.out.println("Digite o CPF do cliente:");
		cliente.setCPF(n.nextLine());
		System.out.println("Digite o novo nome do cliente:");
		cliente.setNome(n.nextLine());
		
		//System.out.println("Digite o novo email do cliente:");
		//cliente.setEmail(n.next());
		//System.out.println("Digite a nova conta do cliente:");
		//cliente.setConta(n.nextInt());
		//System.out.println("Digite a nova senha do cliente");
		//cliente.setSenha(n.next());
		
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.atualizarCliente(cliente);
	}
		// MÉTODO DELETAR CLIENTE
	private static void deletarCliente() {
		Scanner n = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
		System.out.println("Digite o id do cliente para remover:");
		cliente.setId(n.nextInt());
				
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.deletarCliente(cliente);
	}
		// MÉTODO LISTAR TODOS OS CLIENTES DO BANCO
	private static void testeListarTodos() {
		ClienteDAO clienteDao = new ClienteDAO();
		List<Cliente> listaDeClientes =  clienteDao.listarTodos();
		
		for (Cliente u : listaDeClientes){
			System.out.println(u.getId() + " | " +  u.getNome() + " | " + u.getCPF() + " | " + u.getSenha());
		}
	}
	private static void testeProcurarPorId() {
		Scanner n = new Scanner(System.in);
		ClienteDAO clienteDao = new ClienteDAO();
		//System.out.println(usuDao.procurarPorId(4));
		System.out.println("Digite o id do cliente para procurar:");
		
		Cliente retorno_cliente = clienteDao.procurarPorId(n.nextInt());
		
		if (retorno_cliente != null)
			System.out.println("Nome: " + retorno_cliente.getNome() + " | CPF:" + retorno_cliente.getCPF() + " | E-mail:" + retorno_cliente.getEmail());
		else
			System.out.println("ID nao localizado");
	}
}
