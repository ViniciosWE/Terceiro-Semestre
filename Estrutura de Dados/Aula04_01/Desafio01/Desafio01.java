
package Aula04_01.Desafio01;

import java.util.Calendar;

public class Desafio01 {
    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        long cronometroInicial = c.getTimeInMillis();
        long cronometroFinal = cronometroInicial + 2000; //2 segundos
        System.out.println("inicio do programa");
        
        while(cronometroInicial < cronometroFinal){
            c = Calendar.getInstance();
            System.out.println();
            cronometroInicial = c.getTimeInMillis();
        }
        
        
        System.out.println("Data/Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        
    }
}
