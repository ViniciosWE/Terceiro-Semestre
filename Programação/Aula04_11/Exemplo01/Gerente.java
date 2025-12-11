
package Aula04_11.Exemplo01;

public class Gerente extends Empregado{
    String cargo;
    int nivel;
    String departamento;
    Vendedor subordinados[];

    public Gerente(String nome, String dataAdmissao, String nascimento) {
        super(nome, dataAdmissao, nascimento);
    }

    public Gerente(String cargo, int nivel, String departamento, Vendedor[] subordinados, String nome, String dataAdmissao, String nascimento) {
        super(nome, dataAdmissao, nascimento);
        this.cargo = cargo;
        this.nivel = nivel;
        this.departamento = departamento;
        this.subordinados = subordinados;
    }

    public Gerente(String nome, String dataAdmissao, String nascimento, double salarioBase) {
        super(nome, dataAdmissao, nascimento, salarioBase);
        super.setSalarioBase(super.calculaSalario());
        
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Vendedor[] getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(Vendedor[] subordinados) {
        this.subordinados = subordinados;
    }
    
    public double calculaSalario(){
        return super.getSalarioBase()*1.4;
    }
}
