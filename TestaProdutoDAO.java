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
		do {
		System.out.println("Informe qual ação deseja realizar:");
		System.out.println("-------------------------------");
		System.out.println("|1 -    Adicionar Produto     |");
		System.out.println("|2 -    Atualizar Produto     |");
		System.out.println("|3 -     Deletar Produto      |");
		System.out.println("|4 -     Listar Produto       |");
		System.out.println("|5 - Procurar Codigo Produto  |");
		System.out.println("|6 -          Sair            |");
		System.out.println("-------------------------------");
		op = n.nextInt();
		
		switch (op) {
		case 1:
			salvarProduto();
			break;
		case 2:
			atualizarProduto();
			break;
		case 3:
			deletarProduto();
			break;
		case 4:
			listarTodos();
			break;
		case 5:
			procurarPorCodigo();
			break;
		case 6:
			System.out.println("Saindo tela menu.");
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}while(op != 6);
}
	
	// MÉTODO SALVAR PRODUTOS
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
	
	// MÉTODO ATUALIZAR PRODUTO
	private static void atualizarProduto() {
		Scanner n = new Scanner(System.in);
		Produto produto = new Produto();
		
		System.out.println("Digite o códido do produto:");
		produto.setcodigoProduto(n.nextInt());
		
		System.out.println("Digite o novo nome do produto:");
		produto.setnomeProduto(n.next());
		
		System.out.println("Digite o novo valor do produto:");
		produto.setprecoUnitario(n.nextDouble());
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		produtoDao.atualizarProduto(produto);
	}
	
	// MÉTODO DELETAR PRODUTO
	private static void deletarProduto() {
		Scanner n = new Scanner(System.in);
		Produto produto = new Produto();
		
		System.out.println("Digite o id do produto:");
		produto.setId(n.nextInt());
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		produtoDao.deletarProduto(produto);
		
	}
	
	// MÉTODO PROCURAR PELO CODIGO
	private static void procurarPorCodigo() {
		Scanner n = new Scanner(System.in);
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		System.out.println("Digite o codigo do produto para procurar:");
		
		Produto retorno_produto = produtoDao.procurarPorCodigo(n.nextInt());
		
		if (retorno_produto != null)
			System.out.println("Nome:" + retorno_produto.getnomeProduto() + " | Preço:" + retorno_produto.getprecoUnitario());
		else
			System.out.println("Login nao localizado");
	}
	
	// MÉTODO LISTAR TODOS PRODUTOS
	private static void listarTodos() {
		ProdutoDAO ProdutoDao = new ProdutoDAO();
		List<Produto> listaDeProdutos =  ProdutoDao.listarTodos();
		
		for (Produto u : listaDeProdutos){
			System.out.println(u.getId() + " | " +  u.getnomeProduto() + " |Codigo: " + u.getcodigoProduto() + " |R$: " + u.getprecoUnitario());
		}
	}
}
