package Aula06_03.Exercicio02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        Pilha pilha = new Pilha();
        
        System.out.println("Digite uma frase: ");
        String frase = en.nextLine();
        
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);
            pilha.empilhar(letra);
        }

        String inv = "";
        while (!pilha.vazia()) {
            inv += pilha.deseimpilhar();
        }
        
        System.out.println("Invertida: " + inv);
        
        if (frase.equals(inv)) {
            System.out.println("Palíndromo");
        } else {
            System.out.println("Não é palíndromo");
        }
    }
}
