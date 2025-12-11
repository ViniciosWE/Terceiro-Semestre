
package Aula04_01.Exercicio02;

public class VetorNum {
    private int[] v;
    
    public VetorNum(int[] v){
        this.v = v;
    }

    public int[] getV() {
        return v;
    }

    public void setV(int[] v) {
        this.v = v;
    }
    
    public String toString(){
        return "Numero: " + this.v;
    }
}
