
package Aula06_06.Exemplo01;

public class Barco extends Veiculo {

    public Barco(String cor, String chassis) {
        super(cor, chassis);
    }

    @Override
    void mover() {
        System.out.println("Movendo sobre a água");
    }
    
}
