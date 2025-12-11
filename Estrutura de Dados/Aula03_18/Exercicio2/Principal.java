package Aula03_18.Exercicio2;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        String[] VetorContNom = new String[10];
        String[] VetorContEma = new String[10];
        Scanner en = new Scanner(System.in);

      
        System.out.println("Digite a opção que deseja");
        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Excluir");
        System.out.println(" 3 - Alterar");
        System.out.println(" 4 - Buscar contato");
        System.out.println(" 5 - Sair");
        
        int op = en.nextInt();
        en.nextLine(); 
        int quant;

       
        if (op == 1) {
            System.out.println("Digite quantos contatos quer adicionar: ");
            quant = en.nextInt();
            en.nextLine(); 

            if (quant > 0 && quant <= 10) {
                for (int i = 0; i < quant; i++) {
                    System.out.println("Digite o nome do contato: ");
                    VetorContNom[i] = en.nextLine();
                    System.out.println("Digite o email do contato: ");
                    VetorContEma[i] = en.nextLine();  
                }
            } else {
                System.out.println("Valor inválido. Você pode cadastrar no máximo 10 contatos.");
            }
        } 
        
        if (op == 2) {
           
        }

       
        if (op == 3) {
            
        }

        
        if (op == 4) {
            
        }

       
        if (op == 5) {
            System.out.println("Saindo...");
        }
    }
}
