import java.util.Iterator;
import java.util.Stack;

public class Pilha {

	public static void main(String[] args) {

		Stack<String> pilhaLivros = new Stack<>();

		System.out.println("SISTEMA DE LEITURA DE LIVROS DO SEMESTRE\n");

		System.out.println("A pilha está vazia? " + pilhaLivros.isEmpty());
		System.out.println("A pilha esta vazia? " + pilhaLivros.empty());
		System.out.println();

		System.out.println("Adicionando livros na pilha");

		pilhaLivros.push("O Senhor dos Anéis");
		System.out.println("Adicionado: O Senhor dos Anéis");

		pilhaLivros.push("1984");
		System.out.println("Adicionado: 1984");

		pilhaLivros.push("Dom Casmurro");
		System.out.println("Adicionado: Dom Casmurro");

		pilhaLivros.push("Harry Potter");
		System.out.println("Adicionado: Harry Potter");

		pilhaLivros.push("O Pequeno Príncipe");
		System.out.println("Adicionado: O Pequeno Príncipe");

		pilhaLivros.push("Clean Code");
		System.out.println("Adicionado: Clean Code");

		System.out.println();

		System.out.println("A pilha está vazia agora? " + pilhaLivros.isEmpty());
		System.out.println();

		System.out.println("INFORMAÇÕES DA PILHA");
		System.out.println("Quantidade de livros: " + pilhaLivros.size());
		System.out.println();

		System.out.println("Livro no topo (primeiro a ler): " + pilhaLivros.peek());
		System.out.println();

		System.out.println("LISTA DE TODOS OS LIVROS");
		System.out.println("(Do topo para a base da pilha):");

		Iterator<String> iterator = pilhaLivros.iterator();

		int posicao = 1;

		while (iterator.hasNext()) {
			String livro = iterator.next();
			System.out.println(posicao + ". " + livro);
			posicao++;
		}

		System.out.println();
	}

}
