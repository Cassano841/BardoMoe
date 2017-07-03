package br.com.ifrsrestinga.progii.testes;

import java.util.Scanner;

import br.com.ifrsrestinga.progii.entidades.Operacoes;
import br.com.ifrsrestinga.progii.jdbc.OperacoesDAO;

public class TestaOperacoes {
	
	public TestaOperacoes(){
			Scanner n = new Scanner(System.in);
			int op = 0;
			System.out.println("Informe qual operacao deseja realizar:");
			System.out.println("---------------------");
			System.out.println("|1 - Deposito       |");
			System.out.println("|2 - Transferencia  |");
			System.out.println("|3 - Saldo          |");
			System.out.println("|4 - Voltar         |");
			System.out.println("|5 - Sair           |");
			System.out.println("---------------------");
			op = n.nextInt();
			
			switch (op) {
			case 1:
				depositar();
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
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}

		private static void depositar() {
			Scanner n = new Scanner(System.in);
			OperacoesDAO operacoes = new OperacoesDAO();
			
			System.out.println("Informe a conta do cliente:");
			//operacoes.salvarOperacaoDepositar(operacoes);
			    
	   }		
}
