package Aula04_25.betdaads;

import java.io.IOException;
import java.util.Scanner;

public class BetdaADS {

    public static JavaConsole console = new JavaConsole();

    public static void main(String[] args) throws IOException {
        Scanner en = new Scanner(System.in);
        int op = 0;
        while (op != 4) {
            console.limparTela();
            logojogo();
            System.out.println("╔═════════════════════╗");
            System.out.println("║1 - Lançar os jogos  ║");
            System.out.println("║2 - Listar os jogos  ║");
            System.out.println("║3 - Cadastrar times  ║");
            System.out.println("║4 - sair             ║");
            System.out.println("╚═════════════════════╝");
            System.out.print("Opção : ");
            op = en.nextInt();

            switch (op) {
                case 1:
                    Partidas addP = new Partidas();
                    addP.adionarPartidas();
                    break;
                case 2:
                    Arquivo arq = new Arquivo();
                    arq.mostraPartidas();
                    break;
                case 3:
                    Times add = new Times();
                    add.adionarTime();
                    break;
                case 4:
                    fimPrograma();
                    break;
                default:
                    continue;
            }
        }
    }

    public static void logojogo() {
        System.out.println("██████╗ ███████╗████████╗    ██████╗  █████╗      █████╗ ██████╗ ███████╗");
        System.out.println("██╔══██╗██╔════╝╚══██╔══╝    ██╔══██╗██╔══██╗    ██╔══██╗██╔══██╗██╔════╝");
        System.out.println("██████╔╝█████╗     ██║       ██║  ██║███████║    ███████║██║  ██║███████╗");
        System.out.println("██╔══██╗██╔══╝     ██║       ██║  ██║██╔══██║    ██╔══██║██║  ██║╚════██║");
        System.out.println("██████╔╝███████╗   ██║       ██████╔╝██║  ██║    ██║  ██║██████╔╝███████║");
        System.out.println("╚═════╝ ╚══════╝   ╚═╝       ╚═╝ ╚═╝ ╚═╝  ╚═╝    ╚═╝  ╚═╝╚═════╝ ╚══════╝");
        System.out.println("Bem vindo");
    }

    public static void fimPrograma() {
        System.out.println("███████╗██╗███╗   ███╗ ");
        System.out.println("██╔════╝██║████╗ ████║   ");
        System.out.println("█████╗  ██║██╔████╔██║   ");
        System.out.println("██╔══╝  ██║██║╚██╔╝██║   ");
        System.out.println("██║     ██║██║ ╚═╝ ██║   ");
        System.out.println("╚═╝     ╚═╝╚═╝     ╚═╝   ");
        System.out.println("FIM DO PROGRAMA");
    }
}
