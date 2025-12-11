
package Aula04_22.Explicacao;

public class Main {
    public static void main(String[] args) {
       // int a =5;
       
       Elemento a = new Elemento(5);
        //int b = 18;
        Elemento b = new Elemento(18);
        System.out.println("Valor A: " + a);
        System.out.println("Valor B: " + b);
        
        a = b;
        
        System.out.println("\nValor A: " + a);
        System.out.println("Valor B: " + b);
        
        b.setN(9);
        
        System.out.println("\nValor A: " + a);
        System.out.println("Valor B: " + b);
        
        Elemento c = a;
        c.setN(37);
        
        System.out.println("\nValor A: " + a);
        System.out.println("Valor B: " + b);
        System.out.println("Valor c: " + c);
       
    }
}
