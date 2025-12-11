package Aula05_06.TrabalhoConta;

public class ListaEncadeada {

    private Elemento inicio;

    public Elemento getInicio() {
        return inicio;
    }

    public void setInicio(Elemento inicio) {
        this.inicio = inicio;
    }

    public void adicionar(Conta conta) {
        if (this.inicio == null) {
            this.inicio = new Elemento(conta);
        } else {
            Elemento e = this.inicio;
            while (e.getProximo() != null) {
                e = e.getProximo();
            }
            e.setPróximo(new Elemento(conta));
        }
    }

    public void listar() {
        if (this.inicio == null) {
            System.out.println("Lista Vazia");
        } else {
            Elemento e = this.inicio;
            while (e != null) {
                System.out.println(e.getConta());
                e = e.getProximo();
            }
        }
    }

    public boolean remover(String nome) {
        Elemento e = this.inicio;
        if (e == null) {
            return false;
        }
        if (e.getConta().getNome().equals(nome)) {
            this.inicio = e.getProximo();
            return true;
        }
        while (e.getProximo() != null) {
            if (e.getProximo().getConta().getNome().equals(nome)) {
                e.setPróximo(e.getProximo().getProximo());
                return true;
            }
            e = e.getProximo();
        }

        return false;
    }

    public boolean alterar(String nome, String situacao) {
        Elemento e = this.inicio;
        while (e != null) {
            if (e.getConta().getNome().equals(nome)) {
                e.getConta().setSituacao(situacao);
                return true;
            }
            e = e.getProximo();
        }
        return false;
    }
}
