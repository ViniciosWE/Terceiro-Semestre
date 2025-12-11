package ListaCDEncadeada;

public class ListaCDE {

    private Elemento inicio;
    private int tamanho;

    public ListaCDE() {
        this.tamanho = 0;
        this.inicio = null;
    }

    // Adiciona no final da lista
    public void adicionar(Ponto p) {
        Elemento novo = new Elemento(p);

        if (inicio == null) {
            // Lista vazia: novo aponta para si mesmo
            novo.setProximo(novo);
            novo.setAnterior(novo);
            inicio = novo;
        } else {
            Elemento fim = inicio.getAnterior(); // último elemento
            fim.setProximo(novo);
            novo.setAnterior(fim);
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
        }
        tamanho++;
    }

    // Adiciona em uma posição específica (0 a tamanho)
    public void adicionar(int pos, Ponto p) {
        if (pos < 0 || pos > tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        Elemento novo = new Elemento(p);

        if (inicio == null) {
            // Lista vazia, só aceita pos 0
            if (pos == 0) {
                novo.setProximo(novo);
                novo.setAnterior(novo);
                inicio = novo;
                tamanho++;
            } else {
                System.out.println("Posição inválida para lista vazia.");
            }
            return;
        }

        if (pos == 0) {
            // Inserir no início
            Elemento fim = inicio.getAnterior();
            novo.setProximo(inicio);
            novo.setAnterior(fim);
            inicio.setAnterior(novo);
            fim.setProximo(novo);
            inicio = novo;  // atualiza início
            tamanho++;
        } else {
            // Inserir no meio ou fim
            Elemento atual = inicio;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.getProximo();
            }
            Elemento proximo = atual.getProximo();
            atual.setProximo(novo);
            novo.setAnterior(atual);
            novo.setProximo(proximo);
            proximo.setAnterior(novo);
            tamanho++;
        }
    }

    // Lista todos os elementos
    public void listar() {
        if (inicio == null) {
            System.out.println("Lista Vazia");
            return;
        }

        Elemento e = inicio;
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Pos " + i + ": " + e.getP().toString());
            e = e.getProximo();
        }
    }

    // Lista elemento em posição
    public void listar(int pos) {
        if (pos < 0 || pos >= tamanho || inicio == null) {
            System.out.println("Null");
            return;
        }
        Elemento e = inicio;
        for (int i = 0; i < pos; i++) {
            e = e.getProximo();
        }
        System.out.println(e.getP().toString());
    }

    // Remove elemento da posição
    public void remover() {
        if (inicio == null) {
            System.out.println("Lista vazia. Nada para remover.");
            return;
        }

        if (tamanho == 1) {
            // Só um elemento, remove e lista fica vazia
            inicio = null;
            tamanho = 0;
            return;
        }

        // Lista com mais de um elemento
        Elemento fim = inicio.getAnterior(); // último elemento
        Elemento penultimo = fim.getAnterior();

        // Ajusta os ponteiros para remover o fim
        penultimo.setProximo(inicio);
        inicio.setAnterior(penultimo);

        tamanho--;
    }

    // Imprime anterior, atual e próximo do elemento na posição
    public void imprimevizinho(int pos) {
        if (pos < 0 || pos >= tamanho || inicio == null) {
            System.out.println("Null");
            return;
        }
        Elemento e = inicio;
        for (int i = 0; i < pos; i++) {
            e = e.getProximo();
        }
        System.out.println("Anterior: " + e.getAnterior().getP().toString());
        System.out.println("Atual: " + e.getP().toString());
        System.out.println("Próximo: " + e.getProximo().getP().toString());
    }

}
