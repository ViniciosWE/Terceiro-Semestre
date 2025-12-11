package ListaEncadeadaSimples;

public class Main {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        /*lista.adicionar("1");
        lista.adicionar("2");
        lista.adicionar("3");
        lista.adicionar("4");
        lista.adicionar("5");
        
        lista.listar();
        
        lista.remover("2");
        
        lista.listar();
         */
        System.out.println("adionando na posicão");
        lista.adicionar("00", 0);

        lista.adicionar("44", 1);

        lista.adicionar("66", 2);

        lista.adicionar("44", 0);

        lista.adicionar("88", 1);
        
        lista.listar();
        System.out.println("posição escolhida");
        lista.listar(2);
    
    
    }
}