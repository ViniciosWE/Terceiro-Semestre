package Aula04_01.Exercicio01;
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
	
	public void gravar(Usuario user){
		try{					
			bw = new BufferedWriter(new FileWriter(this.arquivo + ".txt"));
			bw.write(user.getNome());
			bw.write("\n");			
			bw.write(user.getSenha());
			bw.close();			
			System.out.println("\nGravado com sucesso!\n");
		}catch (Exception e) {
			System.out.println("Erro na abertura de arquivo para grava��o.");
		}
	}
	
	public Usuario ler(){
		Usuario user = new Usuario();
		try{
			br = new BufferedReader(new FileReader(this.arquivo + ".txt"));
			user.setNome(br.readLine());
			user.setSenha(br.readLine());			
			br.close();
		}catch (Exception e) {
			//System.out.println("Erro na abertura de arquivo para leitura.");
			return null;
		}				
		return user;
	}
}
