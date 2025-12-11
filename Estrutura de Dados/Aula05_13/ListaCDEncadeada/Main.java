package ListaCDEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaCDE lista = new ListaCDE();

        // Adiciona pontos
        lista.adicionar(new Ponto("8", "7", "6"));
        lista.adicionar(new Ponto("7", "5", "8"));
        lista.adicionar(new Ponto("1", "4", "3"));

        System.out.println("Lista completa:");
        lista.listar();

        System.out.println("\nImprime vizinhos do elemento na posição 0:");
        lista.imprimevizinho(0);

        System.out.println("\nImprime vizinhos do elemento na posição 2:");
        lista.imprimevizinho(2);

        System.out.println("\nRemovendo o último elemento...");
        lista.remover();

        System.out.println("\nLista após remover o último elemento:");
        lista.listar();

        System.out.println("\nRemovendo o último elemento novamente...");
        lista.remover();

        System.out.println("\nLista após remover mais um elemento:");
        lista.listar();

        System.out.println("\nRemovendo o último elemento pela terceira vez...");
        lista.remover();

        System.out.println("\nLista após remover o último elemento (deve ficar vazia):");
        lista.listar();

        System.out.println("\nTentando remover em lista vazia:");
        lista.remover(); // deve mostrar mensagem que lista está vazia
    }
}
