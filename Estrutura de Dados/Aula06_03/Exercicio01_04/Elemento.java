
package Aula06_03.Exercicio01_04;

public class Elemento {
    public Elemento anterior;
    int n;

    public Elemento(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }
    
    public Elemento getAnterior() {
        return anterior;
    }

    public void setAnterior(Elemento anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Elemento{" + "anterior=" + anterior + '}';
    }
}
