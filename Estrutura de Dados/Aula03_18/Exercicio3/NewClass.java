
package Aula03_18.Exercicio3;

import java.util.Scanner;


public class NewClass {
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
        
        System.out.println("Escolha X ou O");
        String es = en.nextLine();
        char ch = es.charAt(0);
        
        if (ch == 'X') {
            System.out.println("INICIO DO JOGO");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.println("Escolha as posições X");
                    int pos1 = en.nextInt();
                    int pos2 = en.nextInt();
                    if (matriz[pos1][pos2] == 'X' && matriz[pos1][pos2] == 'O') {
                        System.out.println("LOCAL Já escolhido");
                    }else if(matriz[pos1][pos2] == '#' && matriz[pos1][pos2] != 'O'){
                        matriz[pos1][pos2] = 'X';
                    }
                    System.out.println("Escolha as posições O");
                    int pos3 = en.nextInt();
                    int pos4 = en.nextInt();
                    if (matriz[pos3][pos4] == 'X' && matriz[pos1][pos2] == 'O') {
                        System.out.println("LOCAL Já escolhido");
                    }else if(matriz[pos3][pos4] == '#' && matriz[pos3][pos4] != 'X'){
                        matriz[pos3][pos4] = 'O';
                    }
                    for (int k = 0; k < matriz.length; k++) {
                        for (int l = 0; l < matriz.length; l++) {
                            System.out.print(matriz[k][l] + " ");
                        }
                    System.out.println("");
                    }
                }
            }
                
        }else if(ch == 'O'){
            System.out.println("INICIO DO JOGO");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.println("Escolha as posições O");
                    int pos1 = en.nextInt();
                    int pos2 = en.nextInt();
                    if (matriz[pos1][pos2] == 'X' && matriz[pos1][pos2] == 'O') {
                        System.out.println("LOCAL Já escolhido");
                    }
                    matriz[pos1][pos2] = 'O';
                    
                    System.out.println("Escolha as posições X");
                    int pos3 = en.nextInt();
                    int pos4 = en.nextInt();
                    matriz[pos3][pos4] = 'X';
                    
                    for (int k = 0; k < matriz.length; k++) {
                        for (int l = 0; l < matriz.length; l++) {
                            System.out.print(matriz[k][l] + " ");
                        }
                    System.out.println("");
                    }
                }
            } 
        }else{
            System.out.println("valor invalido");
        }
    }
}      
