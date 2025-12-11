package Aula03_21.Exemplo;

public class Pessoa {

    private int id;
    private String nome;
    private String CPF;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    // métados construtores
    Pessoa(int cod, String nome, String cpf) {
        this.id = cod;
        this.nome = nome;
        this.CPF = cpf;
    }

    Pessoa() {

    }

    Pessoa(int cod, String nome) {
        this.id = cod;
        this.nome = nome;
    }

    void mostracpf() {
        System.out.println("CPF: " + this.CPF);
    }

    void mostracod() {
        System.out.println("COD: " + this.id);
    }

    void mostranome() {
        System.out.println("nome: " + this.nome);
    }

}
