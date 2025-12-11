
package Aula04_01.Exercicio02;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        int numeros[] = new int[5];
        
        System.out.println("Digite 5 numeros inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Numero " + (i+1) + ": ");
            numeros[i] = en.nextInt();
        }
        VetorNum vet = new VetorNum(numeros);

        en.close();
    }
 
}
