package Aula04_25.Explicacao02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    public void gravar() throws IOException {
        String texto = "1;daniel;daniel@mail.com;34";
        FileOutputStream arquivo = new FileOutputStream("teste01.csv", true);
        DataOutputStream insere = new DataOutputStream(arquivo);
        try {
            insere.writeBytes(texto + "\n");
        } catch (IOException e) {
            System.out.println("Erro :" + e.getMessage());
        }
        arquivo.close();

    }

    public void ler() throws FileNotFoundException, IOException{
        File arq = new File("teste01.csv");

        FileReader leitor = new FileReader(arq);
        BufferedReader ler = new BufferedReader(leitor);
        String linha;
        try{
        do {
            linha = ler.readLine();
            if (linha != null) {
                System.out.println(linha);
            }
        } while (linha != null);
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        leitor.close();

    }

}
