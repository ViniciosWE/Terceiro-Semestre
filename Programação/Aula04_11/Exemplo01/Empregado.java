
package Aula04_11.Exemplo01;


public class Empregado {
   private String nome;
   private String dataAdmissao;
   private String nascimento;
   private double salarioBase;
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    

    public Empregado(String nome, String dataAdmissao, String nascimento) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.nascimento = nascimento;
    }

    public Empregado(String nome, String dataAdmissao, String nascimento, double salarioBase) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.nascimento = nascimento;
        this.salarioBase = salarioBase;
    }
    
    
    
    public double calculaSalario(){
        /**salario base para todos empregados
         * salario base + 10%
         **/
        return this.salarioBase * 1.1;
    }
   
}


