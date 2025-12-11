
package Aula06_03.Exercicio01_04;

public class Pilha {
    private Elemento topo;
    private int tamanho;
    
    public void empilhar(int n){
        if (this.topo == null) {
            this.topo = new Elemento(n);
        }else{
            Elemento e = this.topo;
            this.topo = new Elemento(n);
            this.topo.setAnterior(e);
        }
        this.tamanho++;
    }
    
    public int deseimpilhar(){
        this.tamanho--;
        if (this.topo == null) {
            return -1;
        }else{
            Elemento e = this.topo;
            System.out.println(e.getN());
            this.topo = e.getAnterior();
            return e.getN();
        }
    }
    
    public boolean vazia(){
        if (this.topo == null) {
            return true;
        }
        return false;
        
    }
    
    public void tamanho(){
        if (!vazia()) {
             System.out.println(this.tamanho); 
        }else{
            System.out.println("A pilha esta vazia");
        }
    }
    
    public void listar(){
        if (!vazia()) {
            Elemento e = this.topo;
            System.out.println(e.getN());
            while(e.getAnterior() != null){
                e = e.getAnterior();
                System.out.println(e.getN());
            }
        }else{
            vazia();
        }
    }
}
