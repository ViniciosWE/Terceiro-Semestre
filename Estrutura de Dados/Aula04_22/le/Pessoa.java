
public class Pessoa {
	private String cpf;
	private String nome;
	private String sobrenome;
	private Data data;
		
	public Pessoa() {}
	
	public Pessoa(String cpf, String nome, String sobrenome, Data data) {		
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data = data;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public String toString() {
		return "CPF: " + cpf + "\nNome: " + nome + "\nSobrenome: " + sobrenome 
				+ "\nData de Nascimento: " + data + "\n";
	}
}
