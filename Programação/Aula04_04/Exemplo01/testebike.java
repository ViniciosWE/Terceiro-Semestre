
package Aula04_04.Exemplo01;

public class testebike {

    
    public static void main(String[] args) throws InterruptedException {
        Bicicleta barraCircular = new Bicicleta();
        Bicicleta monareta = new Bicicleta();
        RelacaoMarcha jogoSram = new RelacaoMarcha();
        jogoSram.nome = "jsjf";
        jogoSram.numeroMarcha = 26;
        monareta.setJogo(jogoSram);
        monareta.mostraDados();
        for (int i = 0; i < 100; i++) {
            System.out.println("teste ");
            //delay                         
            Thread.sleep(2000);
            
        }
    }
}
