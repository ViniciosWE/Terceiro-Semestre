package Aula04_01.Desafio01;

import java.util.Calendar;
import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        long cronometroInicial = c.getTimeInMillis();
        
        System.out.print("Digite um valor em milissegundos: ");
        int var = en.nextInt();
        long cronometroFinal = cronometroInicial + var;
        
        System.out.println("Início do programa");
        
        for (int i = 1; i <= var / 1000; i++) {
            System.out.println("Segundo: " + i);
            long pausa = System.currentTimeMillis() + 1000;
            while (System.currentTimeMillis() < pausa) {
            }
        }

        while (cronometroInicial < cronometroFinal) {
            c = Calendar.getInstance();
            cronometroInicial = c.getTimeInMillis();
        }

        System.out.println("Data/Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + (c.get(Calendar.MONTH) + 1)); 
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        
        en.close();
    }
}