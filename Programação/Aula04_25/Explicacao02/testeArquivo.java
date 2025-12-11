
package Aula04_25.Explicacao02;

import java.io.IOException;

public class testeArquivo {
    public static void main(String[] args) {
        /*
        Arquivo arq = new Arquivo();
        
        try {
            arq.gravar();
        } catch (IOException ex) {
            System.out.println("ERRO: ");
        }
        
        try {
            arq.ler();
        } catch (IOException ex) {
            System.out.println("ERRO: ");
        }
        */
        
        String linha2="1;daniel;daniel@mail.com;34";
        String vet[]=linha2.split(";");
        for(int i=0;i<vet.length;i++)
        System.out.println(vet[i]);

    }
}
