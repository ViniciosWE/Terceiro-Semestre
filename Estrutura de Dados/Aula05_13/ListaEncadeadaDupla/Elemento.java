
package ListaEncadeadaDupla;

public class Elemento {
   private String elemento;
   private Elemento proximo;
   private Elemento anterior;

    public Elemento(String elemento, Elemento proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Elemento() {
    }

    public Elemento(String elemento) {
        this.elemento = elemento;
    }

    public String getElemento() {
        return elemento;
    }
    
    public void setElemento(String elemento) {
        this.elemento = elemento;
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

    @Override
    public String toString() {
        return "Elemento{" + "elemento=" + elemento + ", proximo=" + proximo + ", anterior=" + anterior + '}';
    }
}
