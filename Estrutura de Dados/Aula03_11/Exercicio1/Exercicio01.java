
package Aula03_11.Exercicio1;

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = entrada.nextLine();
        int total = 0;
        int[] contadorVogais = new int[5]; 
        
        for (int i = 0; i < frase.length(); i++) {
            char letra = Character.toUpperCase(frase.charAt(i));
            switch (letra) {
                case 'A':
                    contadorVogais[0]++;
                    total++;
                    break;
                case 'E':
                    contadorVogais[1]++;
                    total++;
                    break;
                case 'I':
                    contadorVogais[2]++;
                    total++;
                    break;
                case 'O':
                    contadorVogais[3]++;
                    total++;
                    break;
                case 'U':
                    contadorVogais[4]++;
                    total++;
                    break;
            }
        }
        
        System.out.println("Contagem de vogais:");
        System.out.println("A: " + contadorVogais[0]);
        System.out.println("E: " + contadorVogais[1]);
        System.out.println("I: " + contadorVogais[2]);
        System.out.println("O: " + contadorVogais[3]);
        System.out.println("U: " + contadorVogais[4]);
        System.out.println("Total de vogais é: " + total);
    }
}
