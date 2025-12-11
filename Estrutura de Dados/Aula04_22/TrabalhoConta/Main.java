package Aula05_06.TrabalhoConta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaEncadeada lista;
        Arquivo arq = new Arquivo("Contas");

        boolean op = true;
        System.out.println("-------------------------------");
        System.out.println("---CONTROLE MENSAL DE CONTAS---");
        System.out.println("-------------------------------");
        while(op) {
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Remover conta");
            System.out.println("3 - Listar contas");
            System.out.println("4 - Alterar situação");
            System.out.print("Escolha: ");
            int escolha = in.nextInt();
            in.nextLine();
            

            switch (escolha) {
                case 1:
                    lista = arq.ler();
                    Conta conta = new Conta();
                    System.out.print("Nome da conta: ");
                    conta.setNome(in.nextLine());
                    System.out.print("Valor da conta: ");
                    conta.setValor(in.nextLine());
                    System.out.print("Situação da conta: ");
                    conta.setSituacao(in.nextLine());
                    lista.adicionar(conta);
                    arq.gravar(lista);
                    System.out.println("Conta cadastrada\n");
                    break;

                case 2:
                    lista = arq.ler();
                    System.out.print("Nome da conta para ser removida: ");
                    String removida = in.nextLine();
                    if (lista.remover(removida)) {
                        arq.gravar(lista);
                        System.out.println("Conta removida\n");
                    } else {
                        System.out.println("Conta não encontrada\n");
                    }
                    break;

                case 3:
                    lista = arq.ler();
                    lista.listar();
                    break;

                case 4:
                    lista = arq.ler();
                    System.out.print("Nome da conta que deseja alterar: ");
                    String nome = in.nextLine();
                    System.out.print("Nova situação da conta: ");
                    String situacao = in.nextLine();
                    if (lista.alterar(nome, situacao)) {
                        arq.gravar(lista);
                        System.out.println("Situação alterada\n");
                    } else {
                        System.out.println("Conta não encontrada\n");
                        
                    }
                    break;
                    
                default:
                    System.exit(0);
            }
        }
    }
}
