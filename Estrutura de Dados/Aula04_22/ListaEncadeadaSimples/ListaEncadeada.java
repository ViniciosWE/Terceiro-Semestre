package ListaEncadeadaSimples;

public class ListaEncadeada {

    // Referência para o primeiro elemento da lista
    private Elemento inicio;
    // Variável para controlar o tamanho da lista
    private int tamanho;
    // Variável para armazenar posição (não usada diretamente no código)
    private int posicao;

    // Retorna o tamanho atual da lista
    public int getTamanho() {
        return tamanho;
    }

    // Adiciona um elemento no final da lista
    public void adicionar(String elemento) {
        // Se a lista está vazia, o novo elemento vira o início
        if (this.inicio == null) {
            this.inicio = new Elemento(elemento);
        } else {
            // Caso contrário, percorre a lista até o último elemento
            Elemento e = this.inicio;
            while (e.getProximo() != null) {
                e = e.getProximo();
            }
            // Adiciona o novo elemento depois do último
            e.setProximo(new Elemento(elemento));
        }
        // O tamanho deveria ser incrementado aqui, mas está faltando no código atual
        tamanho++;
    }

    // Adiciona um elemento em uma posição específica
    public void adicionar(String elemento, int posicao) {
        // Se a posição for maior que o tamanho atual, adiciona no final
        if (posicao > this.tamanho) {
            adicionar(elemento);
        } else {
            // Só adiciona se o elemento não existir na lista
            if (!contem(elemento)) {
                // Inserção no início da lista (posição 0)
                if (posicao == 0) {
                    Elemento e = this.inicio;           // Guarda o início atual
                    this.inicio = new Elemento(elemento);// Cria novo elemento e define como início
                    this.inicio.setProximo(e);          // Novo aponta para o antigo início
                    this.tamanho++;                     // Incrementa tamanho
                } else {
                    // Inserção em posição intermediária ou final
                    int c = 0;
                    Elemento e = this.inicio;
                    // Percorre até o elemento anterior à posição desejada
                    while (c < posicao - 1) {
                        e = e.getProximo();
                        c++;
                    }
                    Elemento prox = e.getProximo();        // Guarda o próximo elemento
                    e.setProximo(new Elemento(elemento));  // Novo elemento inserido após 'e'
                    e.getProximo().setProximo(prox);       // Novo elemento aponta para o próximo original
                    this.tamanho++;                        // Incrementa tamanho
                }
            }
        }
    }

    // Imprime o elemento na posição informada
    public void listar(int posicao) {
        if (this.inicio == null) {
            System.out.println("Lista vazia.");  // Lista está vazia
            return;
        } else {
            if (posicao > this.tamanho) {
                System.out.println("Posição não existe"); // Posição inválida
                return;
            }
        }
        Elemento e = this.inicio;
        if (posicao == 0) {
            System.out.println(e.getElemento()); // Imprime elemento do início
        } else {
            int c = 0;
            // Percorre até a posição desejada
            while (c < posicao - 1) {
                e = e.getProximo();
                c++;
            }
            System.out.println(e.getElemento()); // Imprime o elemento encontrado
        }
    }

    // Imprime todos os elementos da lista na ordem
    public void listar() {
        Elemento e = this.inicio;
        System.out.println(e.getElemento()); // Imprime o primeiro elemento
        // Percorre e imprime o restante dos elementos
        while (e.getProximo() != null) {
            e = e.getProximo();
            System.out.println(e.getElemento());
        }
    }

    // Verifica se o elemento existe na lista
    public boolean contem(String elemento) {
        Elemento e = this.inicio;

        // Percorre a lista até encontrar o elemento ou chegar ao fim
        while (e != null) {
            if (e.getElemento().equals(elemento)) {
                return true; // Elemento encontrado
            }
            e = e.getProximo();
        }
        return false; // Elemento não encontrado
    }

    // Remove o elemento informado da lista
    public void remover(String info) {
        Elemento e = this.inicio;
        // Caso o elemento a ser removido seja o primeiro
        if (e.getElemento().equals(info)) {
            this.inicio = e.getProximo(); // Atualiza início para o próximo elemento
            this.tamanho--;               // Decrementa tamanho
        } else {
            // Percorre a lista procurando o elemento anterior ao que será removido
            while (e.getProximo() != null) {
                if (e.getProximo().getElemento().equals(info)) {
                    // Remove o elemento ajustando os ponteiros
                    e.setProximo(e.getProximo().getProximo());
                    this.tamanho--; // Decrementa tamanho
                    break;          // Sai do laço após remoção
                } else {
                    e = e.getProximo();
                }
            }
        }
    }

    // Retorna uma string representando o objeto ListaEncadeada (útil para depuração)
    @Override
    public String toString() {
        return "ListaEncadeada{" + "inicio=" + inicio + ", tamanho=" + tamanho + '}';
    }
}
