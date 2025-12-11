
package Aula03_18.Exercicio3;

import java.util.Scanner;


public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        char[][] matriz = {
            {'#','#', '#'},
            {'#','#', '#'},
            {'#','#', '#'}
        };
        
        System.out.println("-----------------------------------------------------");
        System.out.println("------------------JOGO DA VELHA----------------------");
        System.out.println("-----------------------------------------------------");
        
        System.out.println("1|2|3"); 
        System.out.println("4|5|6"); 
        System.out.println("7|8|9 "); 
        
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Escolha as posições");
                int pos1 = en.nextInt();
                int pos2 = en.nextInt();
                
                if (matriz[pos1][pos2] == 'X' && matriz[pos1][pos2] == 'O') {
                    System.out.println("LOCAL Já escolhido");
                }
                if (matriz[pos1][pos2] == '#') {
                    matriz[pos1][pos2] = 'X';
                }
                if(matriz[pos1][pos2] == '#' && matriz[pos1][pos2] != 'X' ){
                   matriz[pos1][pos2] = 'O'; 
                }
                for (int k = 0; k < matriz.length; k++) {
                    for (int l = 0; l < matriz.length; l++) {
                        System.out.print(matriz[k][l] + " ");
                    }
                    System.out.println("");
                }
            }  
        }
    }
}
