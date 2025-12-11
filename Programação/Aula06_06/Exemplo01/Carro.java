
package Aula06_06.Exemplo01;

public class Carro extends Veiculo{

    public Carro(String cor, String chassis) {
        super(cor, chassis);
    }

    @Override
    void mover() {
        System.out.println("Carro movendo sobre rodas");
    }
    
}
