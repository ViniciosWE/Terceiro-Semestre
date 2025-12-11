
package Aula04_11.Exemplo01;


public class Heranca {
    public static void main(String[] args) {
        Gerente gerenteDeVenda = new Gerente("Antonio", "12/02/2019", "17/01/2005", 10000);
        gerenteDeVenda.setCargo("gerente de vendas Europa");
        gerenteDeVenda.setDepartamento("Tecnologia");
        gerenteDeVenda.setNivel(1);
        
        System.out.println(gerenteDeVenda.calculaSalario());
        Vendedor a = new Vendedor("joao", "12/04/2021", "19/05/2008", 1519, 10000);
        System.out.println(a.calculaSalario());
        
        Vendedor b = new Vendedor("patrick", "12/04/2021", "19/05/2008", 2500, 8000);
        
        Vendedor vetVendedor[] = new Vendedor[2];
        vetVendedor[0] = a;
        vetVendedor[1] = b;
        gerenteDeVenda.setSubordinados(vetVendedor);
        
        System.out.println(gerenteDeVenda.subordinados[0].getNome());
        System.out.println(gerenteDeVenda.getSubordinados()[1].getNome());
        
        System.out.println(a.calculaSalario());

    }
    
}
