
package Aula05_20.Trabalho02;

public class Elemento {
    private Ponto p;
    private Elemento proximo;
    private Elemento anterior;

    public Elemento() {
    }

    public Elemento(Ponto p) {
        this.p = p;
    }

    public Ponto getP() {
        return p;
    }

    public void setP(Ponto p) {
        this.p = p;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }

    public Elemento getAnterior() {
        return anterior;
    }

    public void setAnterior(Elemento anterior) {
        this.anterior = anterior;
    }
    
    public String toString(){
        return p.toString();
    }
}
