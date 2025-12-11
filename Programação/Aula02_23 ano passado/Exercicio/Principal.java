
package Aula02_23;

public class Principal {
    public static void main(String[] args) {
        Funcionario funcionarioUm = new Funcionario();
        funcionarioUm.nome = "joao";
        funcionarioUm.salario = 1400;
        funcionarioUm.mostraValores();
        
        Funcionario funcionarioDois = new Funcionario();
        funcionarioDois.nome = "maria";
        funcionarioDois.salario = 2000;
        funcionarioDois.mostraValores();
        
        Funcionario funcionarioTres = new Funcionario();
        funcionarioTres.nome = "roberto";
        funcionarioTres.salario = 4000;
        funcionarioTres.mostraValores();
        
        Funcionario funcionarioQuatro = new Funcionario();
        funcionarioQuatro.nome = "carlos";
        funcionarioQuatro.salario = 7000;
        funcionarioQuatro.mostraValores();
        
    }
}
