
package Aula02_23;

public class Cliente {
    String nome;
    String cpf;
    String endereco;
    double salario;
    
    public String grauDoCliente(){
        String grau = "Ouro";
        
        if (salario < 1500) 
            grau = "Broze";
        
        if ((salario>=1500)&&(salario<5000)) 
            grau = "Prata";
        
        return grau;
    }
    
    public void mostraDados(){
        System.out.println("nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereco: " + endereco);
    }
    
    public String retornaDados(){
        return "nome: " + nome + "\nCPF: " + cpf + "\nendereco: " + endereco;
    }
}
