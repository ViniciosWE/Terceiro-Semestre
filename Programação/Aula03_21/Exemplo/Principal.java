package Aula03_21.Exemplo;

public class Principal {

    public static void main(String[] args) {
        Pessoa gerente = new Pessoa(120, "badanha", "04879806030");
        Pessoa funcionario = new Pessoa();
        funcionario.setId(121);
        funcionario.setNome("josé");
        funcionario.setCPF("555.666.777-09");

        System.out.println(gerente.getCPF());
        gerente.mostracpf();
        gerente.mostracod();
        gerente.mostranome();
        funcionario.mostracpf();
    }
}
