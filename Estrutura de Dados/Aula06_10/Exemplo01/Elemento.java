
package Aula06_10.Exemplo01;

public class Elemento {
    private Elemento proximo;
    private Paciente paciente;

    public Elemento(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }

    public String toString() {
        return paciente.toString();
    }
}
