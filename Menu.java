import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int op = 0;
		System.out.println("Escolha a funÁ„o que deseja realizar:");
		System.out.println("--------------------------");
		System.out.println("|1 - Clientes             |");
		System.out.println("|2 - Produtos             |");
		System.out.println("|3 - Relatorios           |");
		System.out.println("|4 - Sair                 |");
		System.out.println("--------------------------");
		op = n.nextInt();
		
		switch (op) {
		case 1:
			System.out.println("Chama TestaCLiente"); // ser· que È possivel?
			break;
		case 2:
			System.out.println("Chama TestaProduto"); // ser· que È possivel?
			//acessoProdutos();
			break;
		case 3:
		//	acessoRelatorios();
			break;
		case 4:
		//	sair();
			break;
		default:
			System.out.println("Op√ß√£o inv√°lida!");
			break;
		}
	}
		
	}
	

			

		
	

