
package Aula06_06.Exemplo01;


public abstract class Veiculo {
    private String cor;
    private String chassis;

    public Veiculo(String cor, String chassis) {
        this.cor = cor;
        this.chassis = chassis;
    }
    
    public void mostrarDados(){
        System.out.println("Cor: " + this.cor);
        System.out.println("Chassis: " + this.chassis);
    
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }
    
    abstract void mover();
}
