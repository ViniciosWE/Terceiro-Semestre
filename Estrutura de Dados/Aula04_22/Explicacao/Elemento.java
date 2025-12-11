
package Aula04_22.Explicacao;

public class Elemento {
    private int n;

    public Elemento(int n) {
        this.n = n;
    }
    
    public Elemento(){}

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public String toString(){
        return this.n + "";
    }
    
}
