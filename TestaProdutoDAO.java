package br.com.ifrsrestinga.progii.testes;

import java.util.Scanner;

import br.com.ifrsrestinga.progii.entidades.Produto;
import br.com.ifrsrestinga.progii.jdbc.ProdutoDAO;


public class TestaProdutoDAO {
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int op = 0;
		System.out.println("Informe qual ação deseja realizar:");
		System.out.println("--------------------------");
		System.out.println("|1 - Adicionar Produto   |");
		System.out.println("|2 - Atualizar Produto   |");
		System.out.println("|3 -  Deletar Produto    |");
		System.out.println("|4 -  Listar Produto     |");
		System.out.println("|5 - Procurar Id Produto |");
		System.out.println("--------------------------");
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
			//listarProdutos();
			//break;
		case 5:
			//procurarPorId();
			//break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	private static void salvarProduto() {
		Scanner n = new Scanner(System.in);
		Produto produto  = new Produto();
		
		System.out.println("Digite o codigo do produto:");
		produto.setcodigoProduto(n.nextInt());
		System.out.println("Digite o nome do produto:");
		produto.setnomeProduto(n.next());
		System.out.println("Digite o preco unitario do produto:");
		produto.setprecoUnitario(n.nextInt());
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		produtoDao.salvarProduto(produto);
	}
}