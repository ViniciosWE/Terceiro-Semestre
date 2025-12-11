
package Aula02_23;

public class Funcionario {
    String nome;
    double salario;
    
    private double calcularSalario(){
        double novoSalario = 0;
        if (salario < 1500) {
            novoSalario = salario + salario * 0.25;
        }
        if (salario >= 1500 && salario < 3000) {
            novoSalario = salario + salario * 0.2;
        }
        if (salario >= 3000 && salario < 6000) {
            novoSalario = salario + salario * 0.15;
        }
        if (salario >= 6000) {
            novoSalario = salario + salario * 0.1;
        }
        return novoSalario;
    }
    
    public void mostraValores(){
        System.out.println("O funcionario " + nome + " recebe " + salario + " com o reajuste recebe " + calcularSalario());
    }
}
