package ListaCDEncadeada;

public class Ponto {
    private String x;
    private String y;
    private String z;

    public Ponto() {
    }

    public Ponto(String x, String y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "X: " + this.x + " Y: " + this.y + " Z: " + this.z;
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

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }
}
