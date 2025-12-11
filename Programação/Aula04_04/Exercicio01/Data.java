package Aula04_04.Exercicio01;

public class Data {

    private int mes;
    private int ano;
    private int dia;

    public Data() {
    }

    public Data(int mes, int ano, int dia) {
        if (verificarDataValida(dia, mes)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 0;
            this.mes = 0;
            this.ano = ano;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String toString() {
        if (dia == 0 || mes == 0) {
            return "Data invalida";
        } else {
            return this.dia + "/" + this.mes + "/" + this.ano;
        }
    }

    private boolean verificarDataValida(int dia, int mes) {
        if (mes < 1 || mes > 12 || dia < 1) {
            return false;
        }

        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int limiteDia = diasPorMes[mes - 1];

        if (dia > limiteDia) {
            return false;
        }

        return true;
    }
}
