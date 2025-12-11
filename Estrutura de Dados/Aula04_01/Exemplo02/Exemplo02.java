package Aula04_01.Exemplo02;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Exemplo02 {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("Data/Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        
        int hora = c.get(Calendar.HOUR_OF_DAY);
        
        if (hora > 6 && hora <12) {
            System.out.println("Bom Dia");
        } else if(hora > 12 && hora < 18){
            System.out.println("Boa Tarde");
        }else{
            System.out.println("Boa Noite");
        }
        
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data brasileira: " + f.format(c.getTime()));
        
        f = DateFormat.getDateInstance (DateFormat.LONG); System.out.println("Data sem o dia descrito: "+f.format(c.getTime()));
       
        f = DateFormat.getDateInstance (DateFormat.MEDIUM); System.out.println("Data resumida 1: "+f.format(c.getTime()));
       
        f = DateFormat.getDateInstance (DateFormat.SHORT); System.out.println("Data resumida 2: "+f.format(c.getTime()));
    }
}