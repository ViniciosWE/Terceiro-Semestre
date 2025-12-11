
public class Main {

	public static void main(String[] args) {

		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adicionar(new Pessoa("000", "Gustavo", "Rissetti", new Data(18, 12, 1987)));

		Data dn = new Data(1, 6, 2024);
		Pessoa edu = new Pessoa("001", "Eduardo", "Rissetti", dn);
		
		lista.adicionar(edu);
		
		lista.adicionar(new Pessoa("002", "Lilica", "Rissetti", new Data(1, 4, 2010)));
		
		lista.listar();
		
		System.out.println("Removendo 002:");
		Pessoa removida = lista.remover("002");
		lista.listar();
		
		
		System.out.println("Foi Removido:");
		System.out.println(removida);
		
	}

}
