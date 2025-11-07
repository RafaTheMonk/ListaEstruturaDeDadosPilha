package exercicio;

import java.util.Scanner;
import java.util.Stack;

public class PilhaPalindromo {

	private static Stack<Character> pilhaPalindromo = new Stack<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;

		System.out.println("SISTEMA DE VERIFICACAO DE PALINDROMO");

		do {
			exibirMenu();
			opcao = lerOpcao();

			switch (opcao) {
				case 1:
					verificarPalindromo();
					break;
				case 2:
					System.out.println("\nEncerrando o programa...");
					break;
				default:
					System.out.println("\nOpcao invalida! Tente novamente.");
			}

			if (opcao != 2) {
				System.out.println("\nPressione ENTER para continuar...");
				scanner.nextLine();
			}

		} while (opcao != 2);

		scanner.close();
	}

	private static void exibirMenu() {
		System.out.println("\nMENU");
		System.out.println("1 - Verificar Palindromo");
		System.out.println("2 - Sair");
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

	private static void verificarPalindromo() {
		System.out.println("\nInforme a palavra ou frase que deseja verificar:");
		
		try {
			String entrada = scanner.nextLine();
			
			String palavraLimpa = entrada.replaceAll("[^a-zA-Z]", "").toLowerCase();
			
			if (palavraLimpa.isEmpty()) {
				System.out.println("Nenhum caractere valido foi informado!");
				return;
			}
			
			pilhaPalindromo.clear();
			
			for (int i = 0; i < palavraLimpa.length(); i++) {
				pilhaPalindromo.push(palavraLimpa.charAt(i));
			}
			
			StringBuilder palavraInvertida = new StringBuilder();
			
			while (!pilhaPalindromo.isEmpty()) {
				palavraInvertida.append(pilhaPalindromo.pop());
			}
			
			if (palavraLimpa.equals(palavraInvertida.toString())) {
				System.out.println("\n'" + entrada + "' E um palindromo!");
			} else {
				System.out.println("\n'" + entrada + "' Nao e um palindromo!");
			}
			
			System.out.println("Palavra original (limpa): " + palavraLimpa);
			System.out.println("Palavra invertida: " + palavraInvertida);
			
		} catch (Exception e) {
			System.out.println("Entrada invalida! " + e);
		}
	}
}