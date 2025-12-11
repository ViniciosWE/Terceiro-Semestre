package Aula05_06.TrabalhoConta;

public class Elemento {

    private Conta conta;
    private Elemento proximo;

    public Elemento() {
    }

    public String toString() {
        return "\nNome: " + conta.getNome() + "\nValor: " + conta.getValor() + "\nSituação: " + conta.getSituacao() +"\n";
    }

    public Elemento(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setPróximo(Elemento proximo) {
        this.proximo = proximo;
    }

}
