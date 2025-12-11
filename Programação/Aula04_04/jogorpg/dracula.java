/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04_04.jogorpg;

/**
 *
 * @author admin
 */
import java.util.Scanner;

public class dracula
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Na noite sinistra dos Walpurgis, você, Renfield, um advogado, está a caminho do castelo do Conde Drácula nos montes Cárpatos.");
        System.out.println("Sua missão é concluir o contrato de aluguel da Abadia Carfax em Londres para seu misterioso cliente.");
        System.out.println("1. Seguir até o castelo e concluir sua missão.");
        System.out.println("2. Recusar a missão e voltar para a cidade.");
        
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            iniciarJogo(scanner);
        } else {
            System.out.println("Você decide voltar, mas sente que algo sinistro se esconde na noite...");
        }
        scanner.close();
    }
    
    public static void iniciarJogo(Scanner scanner) {
        System.out.println("Você chega ao castelo do Conde Drácula. A carruagem some na escuridão, deixando-o diante do imenso portão negro...");
        for (int fase = 1; fase <= 10; fase++) {
            System.out.println("\n--- Fase " + fase + " ---");
            jogarFase(scanner, fase);
        }
        System.out.println("Após sua jornada sombria, você se encontra diante do próprio Conde Drácula. Será que sua escolha final determinará seu destino?");
    }
    
    public static void jogarFase(Scanner scanner, int fase) {
        System.out.println("Você avança pelo castelo e se depara com um novo desafio...");
        for (int pergunta = 1; pergunta <= 10; pergunta++) {
            System.out.println("Pergunta " + pergunta + " da fase " + fase + ":");
            apresentarDesafio(scanner, fase, pergunta);
        }
    }
    
    public static void apresentarDesafio(Scanner scanner, int fase, int pergunta) {
        if (fase == 1) {
            System.out.println("Você janta com o Conde Drácula. Ele oferece vinho. Você aceita?");
        } else if (fase == 5) {
            System.out.println("Você encontra uma passagem secreta no castelo. Entra ou foge?");
        } else if (fase == 10) {
            System.out.println("Você encontra Van Helsing e John Seward. Juntos, devem enfrentar Drácula. O que fazer?");
        } else {
            System.out.println("Diante de você, surge um enigma sombrio...");
        }
        
        System.out.println("1. Enfrentar o desafio com coragem.");
        System.out.println("2. Tentar escapar pela escuridão.");
        
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            System.out.println("Você encara o perigo de frente e avança com determinação.");
        } else {
            System.out.println("Você tenta fugir, mas algo invisível parece observá-lo...");
        }
    }
}
