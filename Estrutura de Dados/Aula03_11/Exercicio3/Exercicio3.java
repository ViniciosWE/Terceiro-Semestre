package Aula03_11.Exercicio3;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        System.out.println("Digite uma frase:");
        String frase = en.nextLine();
        
        
        char[] vetFrase = frase.toLowerCase().toCharArray();

        for (int i = 0; i < vetFrase.length; i++) {
            if (vetFrase[i] >= 'a' && vetFrase[i] <= 'z') { 
                if (vetFrase[i] == 'z') {
                    vetFrase[i] = 'a';
                } else {
                    vetFrase[i]++; 
                }
            }
        }

        
        String novaFrase = new String(vetFrase);
        System.out.println("\nNOVA FRASE: " + novaFrase);
        
        en.close();
    }
}

