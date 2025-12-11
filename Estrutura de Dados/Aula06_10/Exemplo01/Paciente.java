
package Aula06_10.Exemplo01;

public class Paciente extends Pessoa{
    private String nCart;
    private String convenio;

    public Paciente(String nCart, String convenio, String nome, String sobrenome, String cpf, String dn) {
        super(nome, sobrenome, cpf, dn);
        this.nCart = nCart;
        this.convenio = convenio;
    }

    public Paciente() {
    }

    public String getnCart() {
        return nCart;
    }

    public void setnCart(String nCart) {
        this.nCart = nCart;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String toString() {
        return super.toString() + "\nNÚMERO CARTÃO: " + nCart + "\nCONVENIO: " + convenio;
    }
}
