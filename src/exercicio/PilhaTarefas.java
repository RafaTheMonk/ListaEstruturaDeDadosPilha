package exercicio;

import java.util.Scanner;
import java.util.Stack;

public class PilhaTarefas {

	private static Stack<String> pilhaTarefas = new Stack<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcao = 0;

		System.out.println("SISTEMA DE GERENCIAMENTO DE TAREFAS");

		do {
			exibirMenu();
			opcao = lerOpcao();

			switch (opcao) {
				case 1:
					inserirTarefa();
					break;
				case 2:
					obterProximo();
					break;
				case 3:
					System.out.println("\nEncerrando o programa. Ate logo!");
					break;
				default:
					System.out.println("\nOpcao invalida! Tente novamente.");
			}

			if (opcao != 3) {
				System.out.println("\nPressione ENTER para continuar...");
				scanner.nextLine();
			}

		} while (opcao != 3);

		scanner.close();
	}

	private static void exibirMenu() {
		System.out.println("MENU");
		System.out.println("1 - Inserir Tarefa!");
		System.out.println("2 - Obter a próxima tarefa!");
		System.out.println("3 - Sair");
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

	private static void inserirTarefa() {
		System.out.println("\nInforme a tarefa que deseja inserir:)");
		try {
			String tarefa = scanner.nextLine();
			pilhaTarefas.push(tarefa);
			System.out.println("A tarefa: " + (tarefa) + (" foi agendada com sucesso!"));
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Entrada invalida! " + e);
		}

		System.out.println("Inserção concluida!");
	}

	private static void obterProximo() {
		
		if (!pilhaTarefas.isEmpty()) {	
			System.out.println(pilhaTarefas.peek());
			pilhaTarefas.pop();
			return;
		}else {
			System.out.println("\nA agenda esta vazia!");
			System.out.println("Nenhuma tarefa foi informada.");
		}
	}
}
