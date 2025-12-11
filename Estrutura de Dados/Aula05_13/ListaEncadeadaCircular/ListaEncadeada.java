package ListaEncadeadaCircular;

// Classe que representa uma lista encadeada circular de strings
public class ListaEncadeada {

    // Referência para o primeiro elemento da lista
    private Elemento inicio;
    // Quantidade de elementos na lista
    private int tamanho;
    // Variável para controle de posição (não usada diretamente neste código)
    private int posicao;

    // Método que retorna o tamanho atual da lista
    public int getTamanho() {
        return tamanho;
    }

    // Método para adicionar um elemento no final da lista
    public void adicionar(String elemento) {
        // Se a lista estiver vazia
        if (this.inicio == null) {
            // Cria o primeiro elemento que aponta para ele mesmo (circular)
            this.inicio = new Elemento(elemento);
            this.inicio.setProximo(this.inicio);
        } else {
            // Se não estiver vazia, percorre até o último elemento (que aponta para o início)
            Elemento e = this.inicio;
            while (!e.getProximo().getElemento().equals(this.inicio.getElemento())) {
                e = e.getProximo();
            }
            // Cria novo elemento e atualiza os ponteiros para manter a circularidade
            e.setProximo(new Elemento(elemento));
            e.getProximo().setProximo(this.inicio);
        }
        // Atualiza o tamanho da lista
        tamanho++;
    }

    // Método para adicionar um elemento em uma posição específica
    public void adicionar(String elemento, int posicao) {
        if (posicao > this.tamanho) {
            adicionar(elemento);
        } else {
            if (!contem(elemento)) {
                if (posicao == 0) {
                    // Inserir no início da lista
                    Elemento novo = new Elemento(elemento);
                    if (this.inicio == null) {
                        // Se a lista estiver vazia, o novo elemento aponta para si mesmo
                        novo.setProximo(novo);
                        this.inicio = novo;
                    } else {
                        // Percorre até o último elemento para atualizar seu ponteiro depois
                        Elemento ultimo = this.inicio;
                        while (!ultimo.getProximo().equals(this.inicio)) {
                            ultimo = ultimo.getProximo();
                        }
                        // Novo elemento aponta para o início atual
                        novo.setProximo(this.inicio);
                        // Último elemento passa a apontar para o novo início
                        ultimo.setProximo(novo);
                        // Atualiza o início para o novo elemento
                        this.inicio = novo;
                    }
                    this.tamanho++;
                } else {
                    // Inserir em posição intermediária ou final (exceto no final, pois posicao > tamanho chama adicionar no final)
                    int c = 0;
                    Elemento e = this.inicio;
                    while (c < posicao - 1) {
                        e = e.getProximo();
                        c++;
                    }
                    // Novo elemento aponta para o próximo de 'e'
                    Elemento novo = new Elemento(elemento);
                    novo.setProximo(e.getProximo());
                    // 'e' passa a apontar para o novo elemento
                    e.setProximo(novo);
                    this.tamanho++;
                }
            }
        }
    }

    // Método que lista o elemento na posição específica passada
    public void listar(int posicao) {
        // Se a lista estiver vazia, avisa
        if (this.inicio == null) {
            System.out.println("Lista Vazia");
        } else {
            // Se a posição não existir na lista, avisa
            if (posicao > this.tamanho) {
                System.out.println("Posição não existe");
            }
        }
        // Percorre até a posição e imprime o elemento
        Elemento e = this.inicio;
        if (posicao == 0) {
            System.out.println(e.getElemento());
        } else {
            int c = 0;
            while (c < posicao - 1) {
                e = e.getProximo();
                c++;
            }
            System.out.println(e.getElemento());
        }
    }

    // Método que lista todos os elementos da lista circular
    public void listar() {
        // Começa pelo primeiro elemento
        Elemento e = this.inicio;
        // Imprime o primeiro elemento
        System.out.println(e.getElemento());
        // Percorre enquanto o próximo elemento não for o início, imprimindo cada elemento
        while (!e.getProximo().getElemento().equals(this.inicio.getElemento())) {
            e = e.getProximo();
            System.out.println(e.getElemento());
        }
    }

    // Método para remover um elemento pelo seu valor
    public void remover(String elemento) {
        Elemento e = this.inicio;
        // Se o elemento a ser removido for o início
        if (e.getElemento().equals(elemento)) {
            // Atualiza o início para o próximo elemento
            this.inicio = e.getProximo();
            // Percorre até o último elemento para atualizar seu ponteiro para o novo início
            while (!e.getProximo().getElemento().equals(elemento)) {
                e = e.getProximo();
            }
            e.setProximo(this.inicio);
        } else {
            // Caso contrário, percorre a lista para encontrar e remover o elemento
            while (!e.getProximo().getElemento().equals(this.inicio.getElemento())) {
                if (!e.getProximo().getElemento().equals(elemento)) {
                    e = e.getProximo();
                } else {
                    // Remove o elemento ajustando o ponteiro do anterior para o próximo do removido
                    e.setProximo(e.getProximo().getProximo());
                }
            }
        }
    }

    // Método para verificar se um elemento está contido na lista
    public boolean contem(String elemento) {
        // Se lista vazia, retorna falso
        if (this.inicio == null) {
            return false;
        }

        Elemento e = this.inicio;
        boolean primeiraVez = true;

        // Percorre a lista circular até voltar ao início
        while (e != this.inicio || primeiraVez) {
            if (e.getElemento().equals(elemento)) {
                return true;
            }
            e = e.getProximo();
            primeiraVez = false;
        }

        // Se não encontrou, retorna falso
        return false;
    }

    // Método toString para exibir informações da lista (início e tamanho)
    @Override
    public String toString() {
        return "ListaEncadeada{" + "inicio=" + inicio + ", tamanho=" + tamanho + '}';
    }
}
