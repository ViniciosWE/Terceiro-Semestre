
package Aula03_11.Exercicio2;

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        
        char vogais[] = {'a','e','i','o','u'};
        char alfabeto[] = new char[26];
        int quantidadesCon[] = new int[26];
        
        for (int i = 0; i < quantidadesCon.length; i++) {
            quantidadesCon[i] = 0;
        }
        
        for (int i = 0; i <alfabeto.length; i++) {
            alfabeto[i] = (char) (i+97);
        }
        for (int i = 0; i < alfabeto.length; i++) {
            for (int j = 0; j < vogais.length; j++) {
                if (alfabeto[i] == vogais[j]) {
                    alfabeto[i] = '-';
                }
            }
        }
        
        System.out.println("Digite uma frase: ");
        String frase = en.nextLine();
        char vetFrase[] = frase.toLowerCase().toCharArray();
        
        for (int i = 0; i <vetFrase.length; i++) {
            for (int j = 0; j <alfabeto.length; j++) {
                if (alfabeto[j] == vetFrase[i]) {
                    quantidadesCon[j]++;
                    break;
                }
            }
        }
        System.out.println("\nCON:");
        for (int i = 0; i < quantidadesCon.length; i++) {
           if(alfabeto[i] != '-'){
            System.out.println(alfabeto[i] + ": " + quantidadesCon[i]);
           } 
        }
        en.close();
    }
}
