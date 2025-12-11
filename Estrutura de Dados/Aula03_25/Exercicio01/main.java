
package Aula03_25.Exercicio01;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        System.out.println("Digite as ciirdenadas x e y, do p1: " + "separados por espaço");
        Ponto p1 = new Ponto(en.nextDouble(), en.nextDouble());
        
        Ponto p2 = new Ponto();
        System.out.println("Digite as coordenadas x e y, do p2: " + "separados por espaço");
        p2.setx(en.nextDouble());
        p2.sety(en.nextDouble());
        
        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);
        
        //System.out.println("Distancia p1 a p2: " + p1.getDistancia(p2));
        
        Retangulo ret = new Retangulo(p1,p2);
        System.out.println(ret);
        
        System.out.println("Área: " + ret.getArea());
        System.out.println("Diagonal: " + ret.getDiagonal());
        System.out.println("Perimetro: " + ret.getPerimetro());
        
        
       
        System.out.println("Digite as cordenadas x e y: " + "separados por espaço");
        Ponto p3 = new Ponto(en.nextDouble(),en.nextDouble());
        ret.verPontDF(p3);
        
        System.out.println("Digite as cordenadas x e y " + "separadas por espaço");
        Ponto p4 = new Ponto(en.nextDouble(),en.nextDouble());
        ret.verPontDF(p4);
        
        System.out.println("Digite as cordenadas x e y " + "separadas por espaço");
        Ponto p5 = new Ponto(en.nextDouble(),en.nextDouble());
        ret.verPontDF(p5);
        
        ret.pontoMLonge(p4, p5);
        
    }
}
