package br.com.ifrsrestinga.progii.testes;

import java.util.List;
import java.util.Scanner;

import br.com.ifrsrestinga.progii.entidades.Cliente;
import br.com.ifrsrestinga.progii.entidades.Produto;
import br.com.ifrsrestinga.progii.jdbc.ClienteDAO;
import br.com.ifrsrestinga.progii.jdbc.ProdutoDAO;


public class TestaProdutoDAO {
	
	public TestaProdutoDAO(){
		Scanner n = new Scanner(System.in);
		int op = 0;
		System.out.println("Informe qual ação deseja realizar:");
		System.out.println("------------------------------");
		System.out.println("|1 - Adicionar Produto       |");
		System.out.println("|2 - Atualizar Produto       |");
		System.out.println("|3 -  Deletar Produto        |");
		System.out.println("|4 -  Listar Produto         |");
		System.out.println("|5 - Procurar Codigo Produto |");
		System.out.println("------------------------------");
		op = n.nextInt();
		
		switch (op) {
		case 1:
			salvarProduto();
			break;
		case 2:
			//atualizarProduto();
			break;
		case 3:
			//deletarProduto();
			break;
		case 4:
			listarTodos();
			break;
		case 5:
			//procurarPorId();
			//break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}
	
	// MÉTODO SALVAR PRODUTOS - Opção 1
	private static void salvarProduto() {
		Scanner n = new Scanner(System.in);
		Produto produto  = new Produto();
		
		System.out.println("Digite o nome do produto:");
		produto.setnomeProduto(n.nextLine());
		
		System.out.println("Digite o codigo do produto:");
		produto.setcodigoProduto(n.nextInt());
		
		System.out.println("Digite o preco unitario do produto:");
		produto.setprecoUnitario(n.nextDouble());
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		produtoDao.salvarProduto(produto);
	}
	
	// MÉTODO LISTAR TODOS PRODUTOS - Opção 4
	private static void listarTodos() {
		ProdutoDAO ProdutoDao = new ProdutoDAO();
		List<Produto> listaDeProdutos =  ProdutoDao.listarTodos();
		
		for (Produto u : listaDeProdutos){
			System.out.println(u.getId() + " | " +  u.getnomeProduto() + " |Codigo: " + u.getcodigoProduto() + " |R$: " + u.getprecoUnitario());
		}
	}
}
