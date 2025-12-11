package ListaEncadeadaDupla;

public class Main {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        /*lista.adicionar("1");
        lista.adicionar("2");
        lista.adicionar("3");
        lista.adicionar("4");
        lista.adicionar("5");
        
        
        lista.remover("2");
         */
        lista.adicionar("1", 0);
        lista.adicionar("2", 1);
        lista.adicionar("3", 2);
        lista.adicionar("4", 3);

        //lista.listar();

        System.out.println("movendo");
        //lista.adicionar("5", 2);
        
        //lista.listar();
        
        
        lista.listar(3);

    }
}
