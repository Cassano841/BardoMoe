package br.com.ifrsrestinga.progii.entidades;
import java.util.Scanner;

import br.com.ifrsrestinga.progii.testes.TestaClienteDAO;
import br.com.ifrsrestinga.progii.testes.TestaProdutoDAO;

public class Menu {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int op = 0;
		System.out.println("Escolha a função que deseja realizar:");
		System.out.println("--------------------------");
		System.out.println("|1 - Clientes             |");
		System.out.println("|2 - Produtos             |");
		System.out.println("|3 - Relatorios           |");
		System.out.println("|4 - Vendas               |");
		System.out.println("|4 - Sair                 |");
		System.out.println("---------------------------");
		op = n.nextInt();
		
		switch (op) {
		case 1:
			System.out.println("Chama TestaCLiente"); // será que é possivel?
			TestaClienteDAO cliente  = new TestaClienteDAO();
			break;
		case 2:
			System.out.println("Chama TestaProduto"); // será que é possivel?
			TestaProdutoDAO produto = new TestaProdutoDAO();
			break;
		case 3:
		//	acessoRelatorios();
			break;
		case 4:
		//	sair();
			break;
		default:
			System.out.println("Opcao invalida!");
			break;
		}
	}
		
}
