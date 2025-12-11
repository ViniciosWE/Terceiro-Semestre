
package Aula06_03.Exercicio02;

public class Elemento {
    public Elemento anterior;
    char letra ;

    public char getLetra() {
        return letra;
    }

    public Elemento(char letra) {
        this.letra = letra;
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
