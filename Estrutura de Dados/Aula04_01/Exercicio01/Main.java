package Aula04_01.Exercicio01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Arquivo arq;
		Scanner e = new Scanner(System.in);
		
		int escolha = 0;
        while (escolha != 3) {
            System.out.println("1 - Cadastrar Usu�rio");
            System.out.println("2 - Fazer Login");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            escolha = Integer.parseInt(e.nextLine());	            
            switch (escolha) {
                case 1:
                	Usuario user = new Usuario();
                    System.out.print("Nome de Usu�rio: ");
                    user.setNome(e.nextLine());
                    System.out.print("Senha: ");
                    user.setSenha(e.nextLine());   
                    arq = new Arquivo(user.getNome());
                    arq.gravar(user);
                    System.out.println("-------------------------------");
                    System.out.println("Usu�rio Cadastrado com Sucesso!");
                    System.out.println("-------------------------------");
                    break;
                case 2:
                	System.out.println("-------------------------------");
                    System.out.println("Fa�a seu Login:");                    
                    System.out.println("-------------------------------");                                        
                    System.out.print("Nome de Usu�rio: ");
                    String nome = e.nextLine();
                    System.out.print("Senha: ");
                    String senha = e.nextLine();
                    
                    arq = new Arquivo(nome);
                    
                    Usuario userArq = arq.ler();
                    
                    if(userArq == null) {
                    	System.out.println("Usu�rio n�o cadastrado!!");
                    }else {
                    
                    if(nome.equals(userArq.getNome()) && senha.equals(userArq.getSenha())) {
                    	System.out.println("-------------------------------");
                        System.out.println("Login Efetuado com Sucesso!!");                    
                        System.out.println("-------------------------------");
                    }else {
                    	System.out.println("-------------------------------");
                        System.out.println("Usu�rio ou Senha Incorreto!!");                    
                        System.out.println("-------------------------------");
                    }
                    }
                    break;
                default:                	
                	e.close();
                	System.exit(0);
            }

        }
	}

}
