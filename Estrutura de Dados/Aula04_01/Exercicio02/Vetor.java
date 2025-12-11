package Aula04_01.Exercicio02;

import java.util.Arrays;

public class Vetor {
	
	private int[] vet;
	
	public Vetor() {}
	
	public Vetor(int[] vet) {
		this.vet = vet;
	}
	
	public void setVet(int[] vet) {
		this.vet = vet;
	}
	
	public int[] getVet() {
		return this.vet;
	}
	
	public void toVetInt(String vs) {
		String vetString[] = vs.split("\n");
		int vetInt[] = new int[vetString.length];
		for(int i = 0; i<vetInt.length; i++) {
			vetInt[i] = Integer.parseInt(vetString[i]);
		}
		this.vet = vetInt;
	}
	
	
	public String toString() {
		return Arrays.toString(this.vet);
	}
}
