package Aula04_04.Exercicio02;

public class Exercicio02 {

    private String nomeDoAluno;
    private int numeroDeMatricula;
    private String dataDeNascimento;
    private boolean eBolsista;
    private int anoDeMatricula;

    // Método para inicializar o registro
    public void inicializaRegistro(String nome, int matricula, String data, boolean bolsa, int ano) {
        this.nomeDoAluno = nome;
        this.numeroDeMatricula = matricula;
        this.dataDeNascimento = data;
        this.eBolsista = bolsa;
        this.anoDeMatricula = ano;
    }

    // Método para calcular a mensalidade
    public double calculaMensalidade() {
        if (eBolsista) {
            return 300.00; // valor reduzido para bolsistas
        } else {
            return 700.00; // valor padrão
        }
    }

    // Método para mostrar os dados do registro
    public void mostraRegistro() {
        System.out.println("Nome do aluno: " + nomeDoAluno);
        System.out.println("Número de matrícula: " + numeroDeMatricula);
        System.out.println("Data de nascimento: " + dataDeNascimento);

        if (eBolsista) {
            System.out.println("Bolsista: Sim");
        } else {
            System.out.println("Bolsista: Não");
        }

        System.out.println("Ano de matrícula: " + anoDeMatricula);
        System.out.println("Mensalidade: R$ " + calculaMensalidade());
    }

}
