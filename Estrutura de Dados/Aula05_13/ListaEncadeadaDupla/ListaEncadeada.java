package ListaEncadeadaDupla;

public class ListaEncadeada {

    // Referência para o primeiro elemento da lista
    private Elemento inicio;
    // Quantidade de elementos na lista
    private int tamanho;
    // Variável para armazenar posição (não usada no código atual)
    private int posicao;

    // Método que retorna o tamanho atual da lista
    public int getTamanho() {
        return tamanho;
    }

    // Método para adicionar um elemento em uma posição específica
    public void adicionar(String elemento, int posicao) {
        // Se a posição for maior que o tamanho, adiciona no final
        if (posicao > this.tamanho) {
            adicionar(elemento);
        } else {
            // Verifica se o elemento já não existe na lista
            if (!contem(elemento)) {
                // Inserir no início da lista (posição 0)
                if (posicao == 0) {
                    Elemento e = new Elemento(elemento); // Cria novo elemento
                    e.setProximo(this.inicio);           // Novo aponta para o antigo início
                    if (this.inicio != null) {           // Se a lista não está vazia
                        this.inicio.setAnterior(e);      // Antigo início aponta para o novo como anterior
                    }
                    this.inicio = e;                     // Atualiza início para o novo elemento
                } else {
                    // Inserir em outra posição (não início)
                    int c = 0;
                    Elemento e = this.inicio;
                    // Percorre até o elemento anterior à posição desejada
                    while (c < posicao - 1) {
                        e = e.getProximo();
                        c++;
                    }
                    Elemento prox = e.getProximo();        // Próximo elemento após 'e'
                    Elemento novo = new Elemento(elemento);// Cria novo elemento
                    e.setProximo(novo);                    // 'e' aponta para o novo
                    novo.setAnterior(e);                   // Novo aponta para 'e' como anterior
                    novo.setProximo(prox);                 // Novo aponta para 'prox' como próximo
                    if (prox != null) {                    // Se 'prox' existe
                        prox.setAnterior(novo);            // 'prox' aponta para novo como anterior
                    }
                }
                this.tamanho++; // Incrementa tamanho da lista
            }
        }
    }

    // Método para adicionar um elemento no final da lista
    public void adicionar(String elemento) {
        // Se a lista estiver vazia, novo elemento vira o início
        if (this.inicio == null) {
            this.inicio = new Elemento(elemento);
            this.tamanho++;
        } else {
            Elemento e = this.inicio;
            // Percorre até o último elemento (onde getProximo() == null)
            while (e.getProximo() != null) {
                e = e.getProximo();
            }
            // Cria novo elemento e adiciona depois do último
            e.setProximo(new Elemento(elemento));
            // Ajusta o ponteiro anterior do novo elemento para o último
            e.getProximo().setAnterior(e);
            tamanho++;
        }
    }

    // Método que verifica se um elemento está contido na lista
    public boolean contem(String elemento) {
        Elemento e = this.inicio;

        // Percorre a lista do início ao fim
        while (e != null) {
            if (e.getElemento().equals(elemento)) { // Se elemento encontrado, retorna true
                return true;
            }
            e = e.getProximo();
        }
        return false; // Se não encontrado, retorna false
    }

    // Método que imprime o elemento na posição passada e seu anterior (se existir)
    public void listar(int posicao) {
        if (this.inicio == null) {
            System.out.println("Lista vazia"); // Lista vazia
            return;
        }

        // Valida se a posição é válida dentro do tamanho da lista
        if (posicao < 0 || posicao >= this.tamanho) {
            System.out.println("Posição não existe"); // Posição inválida
            return;
        }

        Elemento e = this.inicio;
        int c = 0;

        // Percorre até a posição desejada
        while (c < posicao) {
            e = e.getProximo();
            c++;
        }

        // Exibe o elemento encontrado na posição
        System.out.println("Elemento na posição " + posicao + ": " + e.getElemento());

        // Exibe o elemento anterior, se existir
        if (e.getAnterior() == null) {
            System.out.println("Não tem anterior, é o primeiro da lista");
        } else {
            Elemento anterior = e.getAnterior();
            System.out.println("Anterior: " + anterior.getElemento());
        }
    }

    // Método para listar todos os elementos da lista, indo do início até o fim, e depois voltando para o início
    public void listar() {
        Elemento e = this.inicio;
        System.out.println(e.getElemento()); // Imprime primeiro elemento
        // Percorre e imprime do início ao último elemento
        while (e.getProximo() != null) {
            e = e.getProximo();
            System.out.println(e.getElemento());
        }
        // Depois percorre para trás imprimindo os elementos do fim até o início
        while (e.getAnterior() != null) {
            e = e.getAnterior();
            System.out.println(e.getElemento());
        }
    }

    // Método para remover o elemento informado da lista
    public void remover(String elemento) {
        Elemento e = this.inicio;
        // Caso o elemento a remover seja o primeiro
        if (e.getElemento().equals(elemento)) {
            this.inicio = e.getProximo(); // Atualiza o início para o próximo elemento
            if (this.inicio != null) {
                this.inicio.setAnterior(null); // Remove referência anterior do novo início
            }
            this.tamanho--;
        } else {
            // Percorre toda a lista para encontrar o elemento
            while (e != null) {
                if (e.getElemento().equals(elemento)) {
                    // Se o elemento não for o último
                    if (e.getProximo() != null) {
                        e.getAnterior().setProximo(e.getProximo()); // Ajusta ponteiro do anterior
                        e.getProximo().setAnterior(e.getAnterior()); // Ajusta ponteiro do próximo
                    } else {
                        // Se for o último, ajusta o anterior para apontar para null
                        e.getAnterior().setProximo(null);
                    }
                    this.tamanho--;
                    break; // Elemento removido, sai do loop
                }
                e = e.getProximo();
            }
        }
    }

    // Sobrescreve o método toString para mostrar informações básicas da lista
    @Override
    public String toString() {
        return "ListaEncadeada{" + "inicio=" + inicio + ", tamanho=" + tamanho + ", posicao=" + posicao + '}';
    }
}
