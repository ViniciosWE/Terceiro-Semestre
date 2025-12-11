package Aula04_04.jogorpg;

import java.util.Random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Scanner;

// Classe principal para o jogo
public class JogoRPG {

    public static JavaConsole console = new JavaConsole();

    public static void main(String[] args) throws InterruptedException {

        Guerreiro guerreiro;
        Mago mago;
        String nome;
        Scanner scanner = new Scanner(System.in);
        console.limparTela();
        desenhatela1();
        System.out.println("\n            BEM VINDO AO JOGO !!\n\n");
        Thread.sleep(2000);
        console.limparTela();
        desenhatela2();
        System.out.print("\n\nJogador 1, personagem Guerreiro (Digite seu nome):");
        nome = scanner.nextLine();
        guerreiro = new Guerreiro(nome, 100, 20);
        System.out.print("\nJogador 2, personagem Mago (Digite seu nome):");
        nome = scanner.nextLine();
        mago = new Mago(nome, 80, 25);
        System.out.println("--- Início da Batalha ---");

        // Loop de combate
        while (guerreiro.estaVivo() && mago.estaVivo()) {
            System.out.println();
            System.out.println("--- STATUS DOS PERSONAGENS ---");
            mostrarBarraDeVida(guerreiro.getNome(), guerreiro.getVida(), guerreiro.getVidaMaxima());
            System.out.println();
            mostrarBarraDeVida(mago.getNome(), mago.getVida(), mago.getVidaMaxima());
            System.out.println();

            System.out.println("Turno de " + guerreiro.getNome());
            System.out.println("Escolha o poder:");
            System.out.println("1. Corte Rápido\n2. Golpe Pesado\n3. Fúria da Espada");
            int escolha = console.lerInt("Digite o número do poder: ");
            System.out.println();
            guerreiro.atacar(mago, escolha);

            if (!mago.estaVivo()) {
                break;
            }
            System.out.println("Turno de " + mago.getNome());
            System.out.println("Escolha o feitiço:");
            System.out.println("1. Bola de Fogo\n2. Raio Congelante\n3. Explosão Arcana");
            int escolha1 = console.lerInt("Digite o número do feitiço: ");
            mago.atacar(guerreiro, escolha);
            System.out.println();

            Thread.sleep(2000);
        }

        if (guerreiro.estaVivo()) {
            System.out.println();
            System.out.println(guerreiro.avatar + "  " + guerreiro.getNome() + " venceu a batalha!");
        } else {
            System.out.println();
            System.out.println(mago.avatar + "  " + mago.getNome() + " venceu a batalha!");
        }

        scanner.close();
    }

    public static String repetir(String texto, int vezes) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < vezes; i++) {
            resultado.append(texto);
        }
        return resultado.toString();
    }

    public static void mostrarBarraDeVida(String nome, int vidaAtual, int vidaMaxima) {
        int totalBlocos = 20;
        int blocosCheios = (int) ((double) vidaAtual / vidaMaxima * totalBlocos);
        int blocosVazios = totalBlocos - blocosCheios;
        String barra = repetir("█", blocosCheios) + repetir("-", blocosVazios);
        System.out.printf("%-12s [%s] %3d/%3d HP\n", nome, barra, vidaAtual, vidaMaxima);
    }

    public static void desenhatela1() {
        System.out.println("      ,   A           {}\n"
                + "     / \\, | ,        .--.\n"
                + "    |    =|= >      /.--.\\\n"
                + "     \\ /` | `       |====|\n"
                + "      `   |         |`::`|\n"
                + "          |     .-;`\\..../`;_.-^-._\n"
                + "         /\\\\/  /  |...::...|`   :   `|\n"
                + "         |:'\\ |   /'''::''|   .:.   |\n"
                + "          \\ /\\;-,/\\   ::  |..:::::..|\n"
                + "          |\\ <` >  >._::_.| ':::::' |\n"
                + "          | `\"\"`  /   ^^  |   ':'   |\n"
                + "          |       |       \\    :    /\n"
                + "          |       |        \\   :   /\n"
                + "          |       |___/   /`---'--`\\");
    }

    public static void desenhatela2() {
        System.out.println(
      "                    @@@@@@@@@@@@@@@@@@@                   " + "\n" +
      "                 @@@@@@             @@@@@@@                " + "\n" +
      "              @@@@                       @@@@              " + "\n" +
      "             @@@                             @@            " + "\n" +
      "            @@                                @@           " + "\n" +
      "           @@                     `           @@          `" + "\n" +
      "          @@                                   @@          " + "\n" +
      "          @@ @@                             @@ @@          " + "\n" +
      "          @@ @@                             @@  @          " + "\n" +
      "          @@ @@                             @@  @          " + "\n" +
      "          @@  @@                            @@ @@          " + "\n" +
      "          @@  @@                           @@  @@          " + "\n" +
      "           @@ @@   @@@@@@@@     @@@@@@@@   @@ @@           " + "\n" +
      "            @@@@ @@@@@@@@@@     @@@@@@@@@@ @@@@@           " + "\n" +
      "             @@@ @@@@@@@@@@     @@@@@@@@@@ @@@             " + "\n" +
      "    @@@       @@  @@@@@@@@       @@@@@@@@@  @@      @@@@   " + "\n" +
      "   @@@@@     @@   @@@@@@@   @@@   @@@@@@@   @@     @@@@@@  " + "\n" +
      "  @@   @@    @@     @@@    @@@@@    @@@     @@    @@   @@  " + "\n" +
      " @@@    @@@@  @@          @@@@@@@          @@  @@@@    @@@ " + "\n" +
      "@@         @@@@@@@@       @@@@@@@       @@@@@@@@@        @@" + "\n" +
      "@@@@@@@@@     @@@@@@@@    @@@@@@@    @@@@@@@@      @@@@@@@@" + "\n" +
      "  @@@@ @@@@@      @@@@@              @@@ @@     @@@@@@ @@@ " + "\n" +
      "          @@@@@@  @@@  @@           @@  @@@  @@@@@@        " + "\n" +
      "              @@@@@@ @@ @@@@@@@@@@@ @@ @@@@@@              " + "\n" +
      "                  @@ @@ @ @ @ @ @ @ @ @ @@                 " + "\n" +
      "                @@@@  @ @ @ @ @ @ @ @   @@@@@              " + "\n" +
      "            @@@@@ @@   @@@@@@@@@@@@@   @@ @@@@@            " + "\n" +
      "    @@@@@@@@@@     @@                 @@      @@@@@@@@@    " + "\n" +
      "   @@           @@@@@@@             @@@@@@@@          @@   " + "\n" +
      "    @@@     @@@@@     @@@@@@@@@@@@@@@     @@@@@     @@@    " + "\n" +
      "      @@   @@@           @@@@@@@@@           @@@   @@      " + "\n" +
      "      @@  @@                                   @@  @@      " + "\n" +
      "       @@@@                                     @@@@       "
);

    }
}
