package Aula04_04.Exemplo01;

class Bicicleta {

    private int velocidade = 0;
    private int marcha = 1;
    private RelacaoMarcha jogo;

    //métado construtor
    public Bicicleta() {
    }

    public Bicicleta(int a, int b) {
        this.velocidade = a;
        this.marcha = b;
    }

    void mudarMarcha(int novoValor) {
        marcha = novoValor;
    }

    void aumentarVelocidade(int incremento) {
        velocidade = velocidade + incremento;
    }

    void aplicarFreios(int decremento) {
        velocidade = velocidade - decremento;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public RelacaoMarcha getJogo() {
        return jogo;
    }

    public void setJogo(RelacaoMarcha jogo) {
        this.jogo = jogo;
    }
    
    public void mostraDados(){
        System.out.println("Velocidade : " + this.velocidade);
        System.out.println("marcha: " + this.jogo.numeroMarcha);
    }

}
