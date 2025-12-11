package Aula03_25.Exemplo01;

public class main {

    public static void main(String[] args) {
        System.out.println("Iniciando o programa pessoa.");
        Pessoa p1 = new Pessoa();

        p1.setNome("Gustavo");
        p1.setSobrenome("Rissetti");
        p1.setDnascimento("18/12/1987");
        p1.setCpf("000000000-00");

        System.out.println(p1);
        
        Pessoa p2 = new Pessoa("lilica", "Rissetti", "01/04/2010", "000000000-00");
        System.out.println("");
        
        System.out.println(p2);
        
        p2.setVida(p2.getVida() - 10);
        System.out.println("Vida " + p2.getVida());
    }
}
