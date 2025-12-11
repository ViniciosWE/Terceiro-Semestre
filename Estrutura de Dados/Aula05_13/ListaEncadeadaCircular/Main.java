package ListaEncadeadaCircular;

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
        
        System.out.println("removeu");
        
        lista.listar();
        */
        
        lista.adicionar("1", 0);
        lista.adicionar("2", 1);
        lista.adicionar("3", 2);
        lista.listar(3);
        lista.listar();
    }
}