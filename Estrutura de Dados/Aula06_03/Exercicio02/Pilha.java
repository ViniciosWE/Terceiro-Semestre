
package Aula06_03.Exercicio02;

public class Pilha {
    private Elemento topo;
    private int tamanho;
    
    public void empilhar(char letra){
        if (this.topo == null) {
            this.topo = new Elemento(letra);
        }else{
            Elemento e = this.topo;
            this.topo = new Elemento(letra);
            this.topo.setAnterior(e);
        }
        this.tamanho++;
    }
    
    public char deseimpilhar(){
        this.tamanho--;
        if (this.topo == null) {
            return '0';
        }else{
            Elemento e = this.topo;
            this.topo = e.getAnterior();
            return e.getLetra();
        }
    }
    
    public boolean vazia(){
        if(this.topo == null) {
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
            System.out.println(e.getLetra());
            while(e.getAnterior() != null){
                e = e.getAnterior();
                System.out.println(e.getLetra());
            }
        }else{
            vazia();
        }
    }

}
