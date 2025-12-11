package Aula04_25.Explicacao01;

/**
 * 
 * @author Vinicios
 * 
 */

public class divisao {

    public static void main(String[] args) {
        try {
            int i = 5571;
            i = i / 0;
            System.out.println("O resultado " + i);
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
        
        try{
        Conta d = null;
            System.out.println("SALDO atual " + d.getSaldo());
        
        }catch(Exception ex1){
            System.out.println("ERRO: " + ex1.getMessage());
        }
        
    }
}
