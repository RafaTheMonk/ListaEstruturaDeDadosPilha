package exercicio;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class PilhaLivros {

	private static Stack<String> pilhaLivros = new Stack<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcao = 0;

		System.out.println("SISTEMA DE GERENCIAMENTO DE LIVROS");

		do {
			exibirMenu();
			opcao = lerOpcao();

			switch (opcao) {
				case 1:
					inserirNaPilha();
					break;
				case 2:
					consultarNaPilha();
					break;
				case 3:
					removerNaPilha();
					break;
				case 4:
					esvaziarNaPilha();
					break;
				case 5:
					System.out.println("\nEncerrando o programa. Ate logo!");
					break;
				default:
					System.out.println("\nOpcao invalida! Tente novamente.");
			}

			if (opcao != 5) {
				System.out.println("\nPressione ENTER para continuar...");
				scanner.nextLine();
			}

		} while (opcao != 5);

		scanner.close();
	}

	private static void exibirMenu() {
		System.out.println("MENU");
		System.out.println("1 - Inserir na Pilha!");
		System.out.println("2 - Consultar na Pilha!");
		System.out.println("3 - Remover na Pilha!");
		System.out.println("4 - Esvaziar na Pilha!");
		System.out.println("5 - Sair");
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

	private static void inserirNaPilha() {
		System.out.println("\nInforme o nome do livro que deseja inserir:)");
		try {
			String livro = scanner.nextLine();
			pilhaLivros.push(livro);
			System.out.println("O livro: " + (livro) + (" adicionado com sucesso!"));
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Entrada invalida! " + e);
		}

		System.out.println("Inserção concluida!");
	}

	private static void consultarNaPilha() {
		if (pilhaLivros.isEmpty()) {
			System.out.println("\nA lista esta vazia!");
			System.out.println("Nenhum livro foi informado.");
			return;
		}
		System.out.println("\nLivros para leitura:");
		System.out.println("\nListando do topo para a base da lista:");
	
		Iterator<String> iterator = pilhaLivros.iterator();
		int posicao = 1;

		while (iterator.hasNext()) {
			String livro = iterator.next();
			System.out.println(posicao + " - " + livro);
			posicao++;
		}
	}

	private static void removerNaPilha() {
		try {
	        if (pilhaLivros.isEmpty()) {
	            System.out.println("\nA pilha está vazia!");
	            return;
	        }
	        
	        String livroRemovido = pilhaLivros.pop();
	        System.out.println("\nLivro removido do topo: " + livroRemovido);
	        
	    } catch (Exception e) {
	        scanner.nextLine();
	        System.out.println("Entrada inválida! " + e);
	    }
	}

	private static void esvaziarNaPilha() {
		if(pilhaLivros.isEmpty()) {
			System.out.println("A pilha já estava vazia!");
		}else {
			System.out.println("Apagando a lista...");
			pilhaLivros.clear();
		}
	}

}
