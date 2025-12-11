package Aula03_25.Exercicio01;

public class Retangulo {

    private Ponto supesq;
    private Ponto infdir;

    public Retangulo() {
    }

    public Retangulo(Ponto supesq, Ponto infdir) {
        this.supesq = supesq;
        this.infdir = infdir;
    }

    public Ponto getInfesq() {
        return new Ponto(this.supesq.getx(), this.infdir.gety());

    }

    public double getArea() {
        Ponto infesq = this.getInfesq();
        double base = infesq.getDistancia(this.infdir);
        double altura = infesq.getDistancia(this.supesq);
        return base * altura;
    }

    public double getDiagonal() {
        return this.infdir.getDistancia(this.supesq);
    }

    public double getPerimetro() {
        Ponto infesq = this.getInfesq();
        double base = infesq.getDistancia(this.infdir);
        double altura = infesq.getDistancia(this.supesq);
        return (2 * base + 2 * altura);
    }

    public void verPontDF(Ponto var) {
        if (var.getx() >= this.supesq.getx() && var.getx() <= this.infdir.getx()
                && var.gety() <= this.supesq.gety() && var.gety() >= this.infdir.gety()) {
            System.out.println("Está dentro do retângulo");
        } else {
            System.out.println("Está fora do retângulo");
        }
    }

    public void pontoMLonge(Ponto v1, Ponto v2) {
        double distancia1 = calcularDistanciaRetangulo(v1);
        double distancia2 = calcularDistanciaRetangulo(v2);

        if (distancia1 > distancia2) {
            System.out.println("O ponto mais distante do retângulo é: " + v1 + " com distância: " + distancia1);
        } else {
            System.out.println("O ponto mais distante do retângulo é: " + v2 + " com distância: " + distancia2);
        }
    }

    public double calcularDistanciaRetangulo(Ponto p) {
        double dx = Math.max(this.supesq.getx() - p.getx(), 0); 
        dx = Math.max(dx, p.getx() - this.infdir.getx()); 

        double dy = Math.max(this.infdir.gety() - p.gety(), 0); 
        dy = Math.max(dy, p.gety() - this.supesq.gety()); 

        return Math.sqrt(dx * dx + dy * dy);
    }

    public Ponto getSupesq() {
        return supesq;
    }

    public void setSupesq(Ponto supesq) {
        this.supesq = supesq;
    }

    public Ponto getInfdir() {
        return infdir;
    }

    public void setInfdir(Ponto infdir) {
        this.infdir = infdir;
    }

    public String toString() {
        return "Ponto Superior Esquerdo: " + this.supesq + "Ponto Inferior Direito: " + this.infdir;
    }

}
