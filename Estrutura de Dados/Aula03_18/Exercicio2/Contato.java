
package Aula03_18.Exercicio2;

import java.util.Scanner;

public class Contato {
    String nome;
    String email;
    
    public static void adicionarContato(String nome, String email){
        Scanner en = new Scanner(System.in);
        System.out.println("Digite o nome do contato: ");
        nome = en.nextLine();
        System.out.println("Digite o email do contato: ");
        email = en.nextLine();
    }
    
    public void op(){
        Scanner en = new Scanner(System.in);
        System.out.println("Digite a opção que deseja");
        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Excluir");
        System.out.println(" 3 - Alterar");
        System.out.println(" 4 - Buscar contato");
        System.out.println(" 5 - Sair");
        int op = en.nextInt();
    }
    
    
    
    
    public static void removerContato(){}
    
}
