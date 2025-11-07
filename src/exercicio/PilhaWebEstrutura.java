package exercicio;

public class PilhaWebEstrutura {
	private String[] pilhaUrl;
	private int topo, capacidade;
	
	public void inicializarPilha(int tamanho) {
	    this.capacidade = tamanho;   
	    this.pilhaUrl = new String[tamanho];
	    this.topo = -1;
	    
	    System.out.println("Pilha inicializada com capacidade de " + tamanho + " páginas.");
	}
	
	public void push(String url) {
	    if (topo == capacidade - 1) {
	        System.out.println("ERRO: Pilha cheia! Não é possível adicionar mais páginas.");
	        return;
	    }
	    
	    topo++;
	    pilhaUrl[topo] = url;
	    
	    System.out.println("Página adicionada: " + url);
	}
	
	public String pop() {
	    if (topo == -1) {
	        System.out.println("ERRO: Pilha vazia! Não há páginas para remover.");
	        return null;
	    }
	    
	    String paginaRemovida = pilhaUrl[topo];    
	    pilhaUrl[topo] = null;
	    
	    topo--;
	    
	    System.out.println("Página removida: " + paginaRemovida);
	    return paginaRemovida;
	}
}
