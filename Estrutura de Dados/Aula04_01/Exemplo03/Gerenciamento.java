
package Aula04_01.Exemplo03;

import java.util.Scanner;


public class Gerenciamento {
    public static void main(String[] args) {
        //Scanner en = new Scanner(System.in);
        //System.out.println("Digite a frase a ser gravada no arquvio: ");
        //String frase = en.nextLine();
        Arquivo saida = new Arquivo("teste3");
        //arq.gravar(frase);
        saida.gravar("primeira linha");
        saida.gravar("Segunda linha");
        System.out.println(saida.ler());
    }
}
