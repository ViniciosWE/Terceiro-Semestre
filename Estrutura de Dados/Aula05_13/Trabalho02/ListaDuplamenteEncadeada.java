package Aula05_20.Trabalho02;

public class ListaDuplamenteEncadeada {

    private Elemento inicio;
    private Elemento fim;
    private int tamanho;
    private int cont;

    public ListaDuplamenteEncadeada() {
        this.tamanho = 0;
    }

    public void adicionar(Ponto p) {
        Elemento novo = new Elemento(p);
        if (this.inicio == null) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            novo.setAnterior(this.fim);
            this.fim.setProximo(novo);
            this.fim = novo;
        }
        this.tamanho++;
    }

    public void listarInicio() {
        Elemento e = this.inicio;
        System.out.println("\n---INICIO---");
        while (e != null) {
            System.out.println("POS: " + (this.cont+1) + "|" + e.getP());
            e = e.getProximo();
            this.cont++;
        }
    }

    public void listarFim() {
        Elemento e = this.fim;
        System.out.println("\n---FIM---");
        while (e != null) {
            System.out.println("POS: " + (this.cont) + "|" + e.getP());
            e = e.getAnterior();
            this.cont--;
        }
    }

    public void imprimevizinho(int pos) {
        if (pos < 0 || pos-1 >= tamanho || inicio == null) {
            System.out.println("Null");
            return;
        }
        Elemento e = inicio;
        for (int i = 0; i < pos-1; i++) {
            e = e.getProximo();
        }
        if (e.getAnterior() != null && e.getProximo() != null) {
            System.out.println("Anterior: " + e.getAnterior().getP().toString());
            System.out.println("Atual: " + e.getP().toString());
            System.out.println("Próximo: " + e.getProximo().getP().toString());
        } else {
            if (e.getAnterior() == null && e.getProximo() != null) {
                System.out.println("Anterior: " + "Não tem Anterior");
                System.out.println("Atual: " + e.getP().toString());
                System.out.println("Próximo: " + e.getProximo().getP().toString());
            }
            else{
                System.out.println("Anterior: " + e.getAnterior().getP().toString());
                System.out.println("Atual: " + e.getP().toString());
                System.out.println("Próximo: " + "Não tem Próximo");
            }

        }
    }

}
