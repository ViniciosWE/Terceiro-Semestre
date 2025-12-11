
package Aula03_18.Exercicio1;

import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        String frase = en.nextLine();
        
        char[] vetFrase = frase.toLowerCase().toCharArray();
        
         for (int i = 0; i < vetFrase.length; i++) {
            if (vetFrase[i] <= 'z' && vetFrase[i] >= 'a') { 
                if (vetFrase[i] == 'a') {
                    vetFrase[i] = 'z';
                } else {
                    vetFrase[i]--; 
                }
            }
        }
        String novaFrase = new String(vetFrase);
        System.out.println("\nNOVA FRASE: " + novaFrase);
        
        en.close();
    }
}
