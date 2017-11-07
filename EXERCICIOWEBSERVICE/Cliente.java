package calc;

import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Cliente {
	static Scanner scan = new Scanner(System.in);

	public static String incluir() {
		System.out.println("Informe o codigo: ");
		int codigo = scan.nextInt();

		System.out.println("Informe a descricao: ");
		scan.nextLine();
		String descricao = scan.nextLine();

		System.out.println("Informe o estoque: ");
		int estoque = scan.nextInt();

		System.out.println("Codigo: " + codigo + "\nDescricao: " + descricao + "\nEstoque" + estoque);

		return ""; 
	}

	public static String consultar() {
		System.out.println("Informe o codigo: ");
		int codigo = scan.nextInt();

		System.out.println("Codigo: " + codigo);

		return ""; 
	}

	public static String vender() {
		System.out.println("Informe o codigo: ");
		int codigo = scan.nextInt();

		System.out.println("Informe a quantidade: ");
		int quantidade = scan.nextInt();

		System.out.println("Codigo: " + codigo + "\nQuantidade: " + quantidade);

		return ""; 
	}

	public static String reposicao() {
		System.out.println("Informe o codigo: ");
		int codigo = scan.nextInt();

		System.out.println("Informe a quantidade: ");
		int quantidade = scan.nextInt();

		System.out.println("Codigo: " + codigo + "\nQuantidade: " + quantidade);

		return ""; // retorna o que o webservice retotrna
	}

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://127.0.0.1:5000/venda?wsdl");
		QName qname = new QName("http://webservice.vendas.com.br/", "VendaServiceImplService");
		Service ws = Service.create(url, qname);

		VendaService end = ws.CalculadoraServerImpl(VendaService.class);

		int opcao = -1;
		String resultado = "";

		do {
			System.out.println("Selecione uma opção : ");
			System.out.println("1 - Incluir - 1");
			System.out.println("2 - Consultar - 2");
			System.out.println("3 - Vender - 3");
			System.out.println("4 - Repor - 4");
			System.out.println("0 - Sair - 0");
			System.out.println("Opcao: ");

			try {
				opcao = scan.nextInt();
				System.out.println("");
			} catch (Exception e) {
				System.out.println("Opcao invalida.");
			}

			switch (opcao) {
			case 1:
				resultado = incluir();
				break;

			case 2:
				resultado = consultar();
				break;

			case 3:
				resultado = vender();
				break;

			case 4:
				resultado = reposicao();
				break;

			default:
				System.out.println("Opcao invalida.");
				opcao = -3;
				break;
			}

			if (opcao != -3)
				System.out.println(resultado + "\n");

		} while (opcao != 0);
	}
}
