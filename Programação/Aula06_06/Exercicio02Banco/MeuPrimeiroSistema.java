package Aula06_06.Exercicio02Banco;

import java.io.IOException;
import java.util.Scanner;

public class MeuPrimeiroSistema {

    public static JavaConsole console = new JavaConsole();

    static Controller ctrProd = new Controller();

    public static void main(String[] args) throws IOException {
        Scanner en = new Scanner(System.in);
        int op = 0;

        while (op != 5) {
            System.out.println("╔═════════════════════╗");
            System.out.println("║1 - INSERIR PRODUTOS ║");
            System.out.println("║2 - ALTERAR PRODUTOS ║");
            System.out.println("║3 - EXCLUIR PRODUTOS ║");
            System.out.println("║4 - LISTAR PRODUTOS  ║");
            System.out.println("║5 - SAIR             ║");
            System.out.println("╚═════════════════════╝");
            System.out.print("Opção : ");
            op = en.nextInt();

            switch (op) {
                case 1:
                    en.nextLine(); // Limpa buffer
                    Produtos novoProd = new Produtos();

                    System.out.print("Digite o nome do Produto: ");
                    novoProd.setNome(en.nextLine());

                    System.out.print("Digite o preço do Produto: ");
                    novoProd.setPreco(en.nextDouble());

                    System.out.print("Digite a quantidade dos produtos: ");
                    novoProd.setQtd(en.nextInt());

                    ctrProd.inserirProdutos(novoProd);
                    break;

                case 2:
                    System.out.print("Digite o código do produto a alterar: ");
                    int codAlt = en.nextInt();
                    en.nextLine();

                    Produtos prodAlt = new Produtos();
                    prodAlt.setCodigo(codAlt);

                    System.out.print("Digite o novo nome: ");
                    prodAlt.setNome(en.nextLine());

                    System.out.print("Digite o novo preço: ");
                    prodAlt.setPreco(en.nextDouble());

                    System.out.print("Digite a nova quantidade: ");
                    prodAlt.setQtd(en.nextInt());

                    ctrProd.alterarProdutos(prodAlt);
                    break;

                case 3:
                    System.out.print("Digite o código do produto a excluir: ");
                    int codExc = en.nextInt();
                    ctrProd.excluirProdutos(codExc);
                    break;

                case 4:
                    System.out.println("LISTA DE PRODUTOS:");
                    for (Produtos j : ctrProd.listarProdutos()) {
                        System.out.println("----------------------------");
                        System.out.println("Código: " + j.getCodigo());
                        System.out.println("Nome  : " + j.getNome());
                        System.out.println("Preço : R$" + j.getPreco());
                        System.out.println("Qtd   : " + j.getQtd());
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        en.close();
    }
}
