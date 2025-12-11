
package Aula02_23;

public class Principal {

    public static void main(String[] args) {
        Cliente clienteUm = new Cliente();
        clienteUm.nome = "Ana";
        clienteUm.cpf = "05678595640";
        clienteUm.endereco = "Rua Casacavel";
        clienteUm.salario = 1350;
        
        System.out.println("Nivel Cliente: " + clienteUm.nome + ": " + clienteUm.grauDoCliente());
        
        Cliente clienteDois = new Cliente();
        clienteDois.nome = "João";
        clienteDois.cpf = "13474795689";
        clienteDois.endereco = "Rua Medeiros";
        
        clienteUm.retornaDados();
        System.out.println(clienteUm.retornaDados());
  
    }
}
