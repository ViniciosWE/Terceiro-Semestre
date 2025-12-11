
package Aula03_25.Exercicio01;

public class Ponto {
    private double x;
    private double y;
    
    public Ponto(){
        
    }

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getx() {
        return x;
    }

    public void setx(double x) {
        this.x = x;
    }

    public double gety() {
        return y;
    }

    public void sety(double y) {
        this.y = y;
    }
    
    public String toString(){
    return "[" + this.x + ", " + this.y + "]\n";
    }
    
    public double getDistancia(Ponto p2){
        double xquadrado = Math.pow((this.x - p2.getx()),2);
        double yquadrado = Math.pow((this.y - p2.gety()),2);
        return Math.sqrt(xquadrado + yquadrado);
        
    }
    
    
}
