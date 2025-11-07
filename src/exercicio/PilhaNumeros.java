package exercicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PilhaNumeros {

	private static Stack<Integer> pilhaPares = new Stack<>();
	private static List<Integer> todosNumeros = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	private static boolean numerosInformados = false;

	public static void main(String[] args) {
		int opcao = 0;

		System.out.println("SISTEMA DE GERENCIAMENTO DE PILHA");

		do {
			exibirMenu();
			opcao = lerOpcao();

			switch (opcao) {
				case 1:
					informarNumeros();
					break;
				case 2:
					listarNumerosPares();
					break;
				case 3:
					informarTopo();
					break;
				case 4:
					informarTamanho();
					break;
				case 5:
					listarTodosNumeros();
					break;
				case 6:
					System.out.println("\nEncerrando o programa. Ate logo!");
					break;
				default:
					System.out.println("\nOpcao invalida! Tente novamente.");
			}

			if (opcao != 6) {
				System.out.println("\nPressione ENTER para continuar...");
				scanner.nextLine();
			}

		} while (opcao != 6);

		scanner.close();
	}

	private static void exibirMenu() {
		System.out.println("MENU");
		System.out.println("1 - Informar os numeros!");
		System.out.println("2 - Listar os numeros pares inseridos na pilha!");
		System.out.println("3 - Informar o topo da pilha!");
		System.out.println("4 - Informar o tamanho da pilha!");
		System.out.println("5 - Listar todos os numeros informados pelo usuario");
		System.out.println("6 - Sair");
		System.out.print("Escolha uma opcao: ");
	}

	private static int lerOpcao() {
		try {
			int opcao = scanner.nextInt();
			scanner.nextLine(); 
			return opcao;
		} catch (Exception e) {
			scanner.nextLine();
			return -1;
		}
	}

	private static void informarNumeros() {
		System.out.println("INFORMAR OS NUMEROS (15 no total)");

		pilhaPares.clear();
		todosNumeros.clear();

		System.out.println("\nDigite 15 numeros inteiros:");

		for (int i = 1; i <= 15; i++) {
			System.out.print("Numero " + i + ": ");
			try {
				int numero = scanner.nextInt();
				scanner.nextLine(); 

				todosNumeros.add(numero);

				if (numero % 2 == 0) {
					pilhaPares.push(numero);
					System.out.println("  -> " + numero + " e PAR! Adicionado a pilha.");
				} else {
					System.out.println("  -> " + numero + " e IMPAR. Nao sera adicionado a pilha.");
				}
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("  -> Entrada invalida! Digite um numero inteiro.");
				i--;
			}
		}

		numerosInformados = true;

		System.out.println("Processamento concluido!");
		System.out.println("Total de numeros pares na pilha: " + pilhaPares.size());

		System.out.println("\nA pilha esta vazia? " + pilhaPares.isEmpty());
	}

	private static void listarNumerosPares() {
		System.out.println("NUMEROS PARES NA PILHA");

		if (!numerosInformados) {
			System.out.println("\nNenhum numero foi informado ainda!");
			System.out.println("Por favor, escolha a opcao 1 primeiro.");
			return;
		}

		if (pilhaPares.isEmpty()) {
			System.out.println("\nA pilha esta VAZIA!");
			System.out.println("Nenhum numero par foi informado.");
			return;
		}

		System.out.println("\nListando do TOPO para a BASE da pilha:");
		System.out.println("(Ordem de insercao: Do topo para a base da pilha)\n");

		Iterator<Integer> iterator = pilhaPares.iterator();
		int posicao = 1;

		while (iterator.hasNext()) {
			Integer numero = iterator.next();
			System.out.println("  Posicao " + posicao + ": " + numero);
			posicao++;
		}

		System.out.println("\nTotal de numeros pares: " + pilhaPares.size());
	}

	private static void informarTopo() {
		System.out.println("TOPO DA PILHA");

		if (!numerosInformados) {
			System.out.println("\nNenhum numero foi informado ainda!");
			System.out.println("Por favor, escolha a opcao 1 primeiro.");
			return;
		}

		if (pilhaPares.isEmpty()) {
			System.out.println("\nA pilha esta VAZIA!");
			System.out.println("Nao ha topo para exibir.");
			return;
		}

		Integer topo = pilhaPares.peek();
		System.out.println("\nO numero no TOPO da pilha e: " + topo);
		System.out.println("(Este foi o ultimo numero par inserido)");
	}

	private static void informarTamanho() {
		System.out.println("TAMANHO DA PILHA");

		if (!numerosInformados) {
			System.out.println("\nNenhum numero foi informado ainda!");
			System.out.println("Por favor, escolha a opcao 1 primeiro.");
			return;
		}

		int tamanho = pilhaPares.size();
		System.out.println("\nA pilha contem " + tamanho + " numero(s) par(es).");

		System.out.println("\nA pilha esta vazia? " + pilhaPares.isEmpty());

		if (tamanho > 0) {
			System.out.println("\nInformacoes adicionais:");
			System.out.println("  - Topo: " + pilhaPares.peek());
			System.out.println("  - Total de numeros informados: " + todosNumeros.size());
			System.out.println("  - Numeros impares descartados: " + (todosNumeros.size() - tamanho));
		}
	}

	private static void listarTodosNumeros() {
		System.out.println("  TODOS OS NUMEROS INFORMADOS (15)");

		if (!numerosInformados) {
			System.out.println("\nNenhum numero foi informado ainda!");
			System.out.println("Por favor, escolha a opcao 1 primeiro.");
			return;
		}

		System.out.println("\nListando na ordem em que foram digitados:\n");

		for (int i = 0; i < todosNumeros.size(); i++) {
			Integer numero = todosNumeros.get(i);
			String tipo = (numero % 2 == 0) ? "PAR (na pilha)" : "IMPAR (descartado)";
			System.out.println("  " + (i + 1) + ". " + numero + " - " + tipo);
		}

		System.out.println("\nTotal: " + todosNumeros.size() + " numeros");
		System.out.println("Pares (na pilha): " + pilhaPares.size());
		System.out.println("Impares (descartados): " + (todosNumeros.size() - pilhaPares.size()));
	}
}
