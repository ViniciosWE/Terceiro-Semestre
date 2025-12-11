package Aula03_25.Exemplo01;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String dnascimento;
    private int vida = 100;
    
    public Pessoa(){}
    
    public Pessoa(String nome, String sobrenome, String dnascimento, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dnascimento = dnascimento;
        this.cpf = cpf;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDnascimento() {
        return this.dnascimento;
    }

    public void setDnascimento(String dnascimento) {
        this.dnascimento = dnascimento;
    }
    
    public String toString(){
        return "NOME: " + this.nome + "\nSOBRENOME: " + this.sobrenome + "\nDATA NASCIMENTO: " + this.dnascimento + "\nCPF: " + this.cpf ;
    }
}
