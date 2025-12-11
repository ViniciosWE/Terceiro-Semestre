package Aula04_01.Exercicio02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner e = new Scanner(System.in);
		Arquivo a = new Arquivo("vetor");
		System.out.print("Digite 5 valores (separados por espa�o): ");
		
		Vetor v = new Vetor(
				new int[] {e.nextInt(), e.nextInt(), 
				            e.nextInt(), e.nextInt(), 
				            e.nextInt()}
				);		
		
		System.out.println(v);
		
		a.gravar(v);
		
		System.out.println(a.ler());
	}

}
