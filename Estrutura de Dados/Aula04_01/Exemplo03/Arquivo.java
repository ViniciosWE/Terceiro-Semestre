
package Aula04_01.Exemplo03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    private BufferedWriter bw;
    private BufferedReader br;
    private String arquivo;
    
    public Arquivo(String arquivo){
        this.arquivo = arquivo;
    }
    
    public void gravar(String frase){
        try{
            bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt", true)); // o true pode editar o arquivo e não subtitui
            bw.write(frase);
            bw.write("\n");
            bw.close();
            System.out.println("A frase: " + frase + " foi gravada no arquivo.");
            
        } catch(IOException e){
            System.out.println("Erro ao criar arquivo para gravação.");
            e.printStackTrace();
        }
    }
    public String ler(){
        String conteudo = "";
        String texto = "";
        try{
            br = new BufferedReader(new FileReader(this.arquivo + ".txt"));
            while((conteudo = br.readLine()) != null){
                texto = texto + conteudo + "\n";
            }
            br.close();
        } catch(IOException e){
            System.out.println("Erro ao criar arquivo para gravação.");
        }
        return texto;
    }
}
