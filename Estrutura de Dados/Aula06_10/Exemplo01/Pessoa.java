package Aula06_10.Exemplo01;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    protected String nome;
    protected String sobrenome;
    protected String cpf;
    protected String dn;

    public Pessoa(String nome, String sobrenome, String cpf, String dn) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dn = dn;

    }

    public Pessoa() {
    }

    public String toString() {
        return "NOME: " + nome + "\nSOBRENOME: " + sobrenome + "\nCPF: " + cpf + "\nDATA NASCIMENTO: " + dn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public int getIdade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(this.dn, formatter);
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNascimento, dataAtual).getYears();
    }

}
