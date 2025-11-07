package exercicio;

public class PilhaTarefasEstrutura {
	private String[] pilhaTarefas;
	private int topo, capacidade;
	
	public void inicializarPilha(int tamanho) {
	    this.capacidade = tamanho;   
	    this.pilhaTarefas = new String[tamanho];
	    this.topo = -1;
	    
	    System.out.println("Pilha inicializada com capacidade de " + tamanho + " tarefas.");
	}
	
	public void push(String tarefa) {
	    if (topo == capacidade - 1) {
	        System.out.println("ERRO: Pilha cheia! Não é possível adicionar mais tarefas.");
	        return;
	    }
	    
	    topo++;
	    pilhaTarefas[topo] = tarefa;
	    
	    System.out.println("Tarefa adicionada: " + tarefa);
	}
	
	public String pop() {
	    if (topo == -1) {
	        System.out.println("ERRO: Pilha vazia! Não há tarefas para remover.");
	        return null;
	    }
	    
	    String tarefaRemovida = pilhaTarefas[topo];    
	    pilhaTarefas[topo] = null;
	    
	    topo--;
	    
	    System.out.println("Tarefa removida: " + tarefaRemovida);
	    if (topo == -1) {
	        System.out.println("Todas as tarefas foram concluídas!");
	    }
	    return tarefaRemovida;
	}
}
