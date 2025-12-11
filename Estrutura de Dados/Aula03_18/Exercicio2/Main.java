package AgendaSimples;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	static String contatos[] = new String[20];
	static int contador = 0;
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		cls();		
		progresso("Iniciando a Agenda do Gustavo", 60, 80, false);
		cls();
		int op = -1;
		while(true) {	
			
			System.out.println("--------------------------------------------------------");
			System.out.println("0 - Inserir");
			System.out.println("1 - Listar");
			System.out.println("2 - Buscar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			System.out.println("5 - Sair");
			System.out.print("------> ");
			
			String sop = entrada.nextLine();
			
			if(sop.matches("[0-5]")) {
				op = Integer.parseInt(sop);
			}else {
				cls();
				continue;
			}
			
			switch (op) {
			case 0:
				inserir();
				break;
			case 1:
				listar();
				break;
			case 2:
				buscar();
				break;
			case 3:
				alterar();
				break;
			case 4:
				excluir();
				break;
			default:
				cls();
				progresso("Encerrando a Agenda do Gustavo", 60, 40, true);
				cls();
				System.exit(0);
				break;
			}
		}		
	}
	
	
	public static void excluir() {
		cls();
		int c = buscar();
		if(c != -1) {
			System.out.print("Excluir contato? (s/n): ");
			String r = entrada.nextLine();			
			if(r.equals("s")) {				
				contatos[c] = "-";								
				contatos[c+1] = "-";			
			}
		}
		
	}
	
	public static void alterar() {
		cls();
		int c = buscar();
		if(c != -1) {
			System.out.print("Alterar nome? (s/n): ");
			String r = entrada.nextLine();
			if(r.equals("s")) {
				System.out.print("Digite o novo nome do contato: ");
				contatos[c] = entrada.nextLine();			
			}
			System.out.print("Alterar email? (s/n): ");
			r = entrada.nextLine();
			if(r.equals("s")) {
				System.out.print("Digite o novo email do contato: ");
				contatos[c+1] = entrada.nextLine();			
			}
		}
	}
	
	public static int buscar() {
		cls();
		System.out.println("--------------------------------------------------------");
		System.out.print("Digite o nome do contato: ");
		String nome = entrada.nextLine();
		nome = nome.toLowerCase();
		for(int i = 0; i<contador; i+=2) {
			if(nome.equals(contatos[i].toLowerCase())){
				System.out.println("Nome: " + contatos[i] + " - Email: " + contatos[i+1]);
				return i;
			}
		}
		System.out.println("Contato não encontrado!");
		return -1;
	}
	
	public static void inserir() {
		cls();
		System.out.println("--------------------------------------------------------");
		System.out.print("Digite o nome do contato: ");
		String nome = entrada.nextLine();
		System.out.print("Digite o email do contato: ");
		String email = entrada.nextLine();			
		contatos[contador] = nome;		
		contatos[contador+1] = email;
		contador+=2;
	}
	
	public static void listar() {
		cls();
		System.out.println("--------------------------------------------------------");
		System.out.println("----------------   AGENDA DE CONTATOS   ----------------");
		System.out.println("--------------------------------------------------------");
		for(int i = 0; i < contador; i+=2) {
			if(contatos[i] != "-") {
				System.out.println("Nome: " + contatos[i] + " - Email: " + contatos[i+1]);
			}
		}
		System.out.println("--------------------------------------------------------");
	}

	public static void cls() {
		for(int i = 0; i<50; i++) {
			System.out.println();
		}
	}
	
	public static void progresso(String msg, int tam, long intervalo, boolean rev){
		char ini = '░';
		char fim = '█';
		StringBuilder builder = new StringBuilder();
		Stream.generate(() -> ini).limit(tam).forEach(builder::append);
		System.out.println(msg);
		if(rev) {
			for(int i = tam; i >= 0; i--) {
				imprimirProgresso(intervalo, fim, builder, i);
			}
		}else {
			for(int i = 0; i < tam;  i++) {
				imprimirProgresso(intervalo, fim, builder, i);
			}
		}
	}

	private static void imprimirProgresso(long intervalo, char fim, StringBuilder builder, int i) {
		builder.replace(i,i+1,String.valueOf(fim));
		String progresso = "\r"+builder;
		System.out.print(progresso);
		try {
			Thread.sleep(intervalo);
		} catch (InterruptedException ex){}
	}
}