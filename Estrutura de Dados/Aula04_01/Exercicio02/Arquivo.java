package Aula04_01.Exercicio02;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Arquivo {
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo;
	
	public Arquivo(String arquivo){
		this.arquivo = arquivo;
	}
	
	public void gravar(Vetor v){
		try{					
			bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt"));
			for(int i = 0; i<v.getVet().length; i++) {
				bw.write(v.getVet()[i]+"\n");				
			}			
			bw.close();			
			System.out.println("\nGravado com sucesso!\n");
		}catch (Exception e) {
			System.out.println("Erro na abertura de arquivo para grava��o.");
		}
	}
	
	public Vetor ler(){
		Vetor v = new Vetor();
		String linha = "";
		String vs = "";
		try{
			br = new BufferedReader(new FileReader(this.arquivo + ".txt"));
			while((linha = br.readLine()) != null) {
				vs += linha + "\n";
			}			
			v.toVetInt(vs);			
			br.close();
		}catch (Exception e) {
			return null;
		}				
		return v;
	}
}
