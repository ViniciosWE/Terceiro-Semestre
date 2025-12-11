
package Aula03_14.ExercicioPONTO;

public class Principal {
    public static void main(String[] args){
        Ponto Ponto1 = new Ponto();
        Ponto1.X=3;
        Ponto1.Y=2;
        
        Ponto1.mostraPonto2d();
        
        Ponto Ponto2 = new Ponto();
        Ponto2.X=7;
        Ponto2.Y=5;
        
        Ponto2.mostraPonto2d();
        
        OpGeometrica op = new OpGeometrica();
        op.mostraResultado(Ponto1, Ponto2);
        
    }
}
