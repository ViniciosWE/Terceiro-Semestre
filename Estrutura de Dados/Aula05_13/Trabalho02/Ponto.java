
package Aula05_20.Trabalho02;

public class Ponto {
    private String x;
    private String y;

    public Ponto(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String toString(){
        return " X: " + this.x + "| Y: " + this.y;
    }
}
