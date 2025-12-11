package Aula04_25.betdaads;

import java.io.IOException;
import java.util.Scanner;

public class Partidas {

    Arquivo arquivo = new Arquivo();

    public void adionarPartidas() throws IOException {
        boolean op = true;
        Scanner en = new Scanner(System.in);

        while (op) {
            System.out.println("\n DIGITE O TIME 1");
            System.out.print("NOME: ");
            String time1 = en.nextLine();

            System.out.println("\n DIGITE OS GOLS DO TIME 1");
            System.out.print("GOLS: ");
            int gols1 = en.nextInt();

            en.nextLine();

            System.out.println("\n DIGITE O TIME 2");
            System.out.print("NOME: ");
            String time2 = en.nextLine();

            System.out.println("\n DIGITE OS GOLS DO TIME 2");
            System.out.print("GOLS: ");
            int gols2 = en.nextInt();

            en.nextLine();

            if (arquivo.arqPartidas(time1, gols1, time2, gols2)) {
                System.out.println("Partida registrada com sucesso!");
            } else {
                System.out.println("Partida não adicionada. Verifique se os times existem.");
                break;
            }
            boolean j = true;
            while (j) {
                System.out.println("\nDESEJA CONTINUAR ADICIONANDO?");
                System.out.println("1- SIM");
                System.out.println("2- NÃO");
                System.out.print("OPÇÃO: ");
                int i = en.nextInt();

                if (i == 1) {
                    op = true;
                     j= false;
                } else if (i == 2) {
                    op = false;
                    j = false;
                } else {
                    System.out.println("Valor inválido. Tente novamente.");
                    continue;
                }
                en.nextLine();
            }
        }
    }
}
