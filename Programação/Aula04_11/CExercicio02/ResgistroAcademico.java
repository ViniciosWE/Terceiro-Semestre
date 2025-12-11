package Aula04_11.CExercicio02;

public class ResgistroAcademico {

    String nomeDoAluno;
    String numeroDaMatricula;
    String dataDeNascimento;
    boolean eBolsista;
    int anoMatricula;

    public ResgistroAcademico() {
    }

    public ResgistroAcademico(String nomeDoAluno, String numeroDaMatricula, String dataDeNascimento, boolean eBolsista, int anoMatricula) {
        this.nomeDoAluno = nomeDoAluno;
        this.numeroDaMatricula = numeroDaMatricula;
        this.dataDeNascimento = dataDeNascimento;
        this.eBolsista = eBolsista;
        this.anoMatricula = anoMatricula;
    }

    public String getNomeDoAluno() {
        return nomeDoAluno;
    }

    public void setNomeDoAluno(String nomeDoAluno) {
        this.nomeDoAluno = nomeDoAluno;
    }

    public String getNumeroDaMatricula() {
        return numeroDaMatricula;
    }

    public void setNumeroDaMatricula(String numeroDaMatricula) {
        this.numeroDaMatricula = numeroDaMatricula;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public boolean iseBolsista() {
        return eBolsista;
    }

    public void seteBolsista(boolean eBolsista) {
        this.eBolsista = eBolsista;
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(int anoMatricula) {
        this.anoMatricula = anoMatricula;
    }
    
    /**
     * @return retorna o valor da mensalidade caso o aluno seja bolsista o valor muda.
    */
    public double calcularMensalidade(){
        if (this.eBolsista) {
            return 300.00;
        }else
            return 700.00;
    }

    public void mostraRegistro() {
        System.out.println("O/A Aluno/a" + this.nomeDoAluno + " Nasceu em " + this.dataDeNascimento);
        System.out.println("Matricula " + this.numeroDaMatricula + " ano da matricula " + this.anoMatricula);
        if (this.eBolsista) {
            System.out.println("É bolsista");
            System.out.println("Mensalidade de: "+ calcularMensalidade());
        } else {
            System.out.println("Não é bolsista");
            System.out.println("Mensalidade de: " + calcularMensalidade());
        }
    }
}
