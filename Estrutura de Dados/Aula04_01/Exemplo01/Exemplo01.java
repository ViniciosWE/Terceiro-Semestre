package Aula04_01.Exemplo01;

import java.util.Arrays;

public class Exemplo01 {
    public static void main(String[] args) {
        char nota[] = { 'E', 'C', 'A', 'D', 'B' };

        for (int i = 0; i < nota.length; i++) {
            System.out.println("Nota: " + nota[i]);
        }

        Arrays.sort(nota);
        System.out.println("Vetor Ordenado");

        for (int i = 0; i < nota.length; i++) {
            System.out.println("Nota: " + nota[i]);
        }

        int v1[] = { 1, 2, 3, 4, 5 };
        int v2[] = { 1, 2, 3, 4, 5 };

        if (Arrays.equals(v1, v2)) {
            System.out.println("Vetores Iguais");
        } else {
            System.out.println("Vetores Diferentes");
        }

        int v3[] = new int[5];
        Arrays.fill(v3, 5);
        System.out.println("Vetor Preenchido");

        for (int i = 0; i < v3.length; i++) {
            System.out.println("Elemento: " + v3[i]);
        }

        int pos = Arrays.binarySearch(nota, 'C');
        System.out.println("O elemento C está na posição " + pos);
    }
}
