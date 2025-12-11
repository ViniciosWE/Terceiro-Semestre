
package Aula04_11.Exemplo01;

public class Vendedor extends Empregado {
    double vendas;
    
    public Vendedor(String nome, String dataAdmissao, String nascimento, double salarioBase, double vendas) {
        super(nome, dataAdmissao, nascimento, salarioBase);
        this.vendas = vendas;
        super.setSalarioBase(super.calculaSalario());
    }
    
     public double calculaSalario(){
        /**salario base para todos empregados
         * salario base + 10%
         **/
        return this.getSalarioBase()+ (this.vendas * 0.2);
    }
    
}
