package Aula06_10.Exemplo01;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();

        Paciente p1 = new Paciente("28498294", "523542", "joao", "carlos", "98434983", "12/05/2023");
        fila.filaPrioritaria(p1);

        Paciente p2 = new Paciente("28498294", "523542", "joao", "carlos", "65545656", "12/05/2020");
        fila.filaPrioritaria(p2);

        Paciente p3 = new Paciente("28498294", "523542", "joao", "carlos", "556465", "12/05/1950");
        fila.filaPrioritaria(p3);   
        
        Paciente p4 = new Paciente("28498294", "523542", "joao", "carlos", "556465", "11/04/1949");
        fila.filaPrioritaria(p4); 

        fila.listar();
    }
}
