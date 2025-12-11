
package Aula05_20.Trabalho02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        
        lista.adicionar(new Ponto("8", "9"));
        lista.adicionar(new Ponto("7", "5"));
        lista.adicionar(new Ponto("1", "4"));
        lista.adicionar(new Ponto("2", "3"));
        lista.adicionar(new Ponto("6", "8"));
        lista.adicionar(new Ponto("3", "6"));
        
        lista.listarInicio();
        
        lista.listarFim();
        
        System.out.println("\n--------------Mostra Vizinhos--------------");
        System.out.println("---Escolha a posição que queira mostrar---");
        System.out.print("Escolha:");
        int escolha = en.nextInt();
        
        lista.imprimevizinho(escolha);
        
    }
}
