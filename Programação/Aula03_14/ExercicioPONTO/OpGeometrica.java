package Aula03_14.ExercicioPONTO;

public class OpGeometrica {

    // d=V((x2-x1)^2+(y2-y1)^2)
    double calculadistancia(Ponto P1, Ponto P2) {
        double d = Math.sqrt(Math.pow(P2.X - P1.X, 2) + Math.pow(P2.Y - P1.Y, 2));
        return d;
    }
    
    void mostraResultado(Ponto P1, Ponto P2) {
        System.out.println("O valor da distância = " + calculadistancia(P1, P2));
    }
}
