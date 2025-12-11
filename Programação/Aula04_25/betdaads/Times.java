package Aula04_25.betdaads;

import java.io.IOException;
import java.util.Scanner;

public class Times {

    Arquivo arquivo = new Arquivo();

    public void adionarTime() throws IOException {
        Scanner en = new Scanner(System.in);
        boolean op = true;

        while (op) {
            System.out.println("\nDIGITE O NOME DO TIME QUE QUER ADICIONAR");
            System.out.print("NOME: ");
            String time = en.nextLine();

            if (arquivo.existeTime(time)) {
                System.out.println("\nO TIME JÁ FOI ADICIONADO!");
            } else {
                arquivo.arqTimes(time);
                System.out.println("\nTIME ADICIONADO COM SUCESSO!");
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
                    System.out.println("Valor inválido");
                    continue;
                }
                en.nextLine();
            }
        }
    }
}
