
package Aula03_11.Exercicio1;

import java.util.Scanner;

public class Exercicio01Melhor {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        char vogais[] = {'a', 'e', 'i','o','u'};
        int quantidadesVogais[] = {0,0,0,0,0};
        
        System.out.println("Digite uma frase: ");
        
        String frase = en.nextLine();
        char vetFrase[] = frase.toLowerCase().toCharArray();
        
        for (int i = 0; i <vetFrase.length; i++) {
            for (int j = 0; j <vogais.length; j++) {
                if (vogais[j] == vetFrase[i]) {
                    quantidadesVogais[j]++;
                    break;
                }
            }
        }
        System.out.println("\nVOGAIS:");
        for (int i = 0; i < quantidadesVogais.length; i++) {
            System.out.println(vogais[i] + ": " + quantidadesVogais[i]);
        }
        en.close();
    }   
}
