
package Aula04_04.Exemplo02;

public class CBS {
    String nDC;
    double saldo;
    boolean contaEsp;

    public CBS() {
    }

    public CBS(String nDC, double saldo, boolean contaEsp) {
        this.nDC = nDC;
        this.saldo = saldo;
        this.contaEsp = contaEsp;
    }

    public String getnDC() {
        return nDC;
    }

    public void setnDC(String nDC) {
        this.nDC = nDC;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isContaEsp() {
        return contaEsp;
    }

    public void setContaEsp(boolean contaEsp) {
        this.contaEsp = contaEsp;
    }
    
    public void abreCS(String nome){
        this.nDC = nome;
        this.saldo = 0.00;
        this.contaEsp = true;
    }
    
    public void deposita(double valor){
        this.saldo = this.saldo + valor;
    }
    
    public void retirar(double valor){
        if (this.contaEsp == false) {
            if (valor <= this.saldo) {
                this.saldo = this.saldo - valor;
            }
        }else
            this.saldo = this.saldo - valor;
    }
    
    public void mostraDados(){
        System.out.println("Nome: "+this.nDC);
        System.out.println("Saldo: " + this.saldo);
        if (this.contaEsp == true) {
            System.out.println("A conta é especial.");
        } else{
            System.out.println("A conta é comum.");
        }
    }
}

