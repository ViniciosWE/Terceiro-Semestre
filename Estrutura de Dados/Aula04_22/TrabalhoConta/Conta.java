package Aula05_06.TrabalhoConta;

public class Conta {

    private String nome;
    private String Valor;
    private String situacao;

    public String toString() {
        return "\nNome: " + nome + "\nValor: " + Valor + "\nSituacão: " + situacao + "\n";
    }

    public Conta() {
    }

    public Conta(String nome, String Valor, String situacao) {
        this.nome = nome;
        this.Valor = Valor;
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
