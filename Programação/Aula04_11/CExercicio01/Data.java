
package Aula04_11.CExercicio01;


public class Data {
    private int dia,mes,ano;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
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
   /**
    * 
    * @param dia
    * @param mes
    * @param ano 
    */
    
    public void inicializaData(int dia,int mes, int ano){
        if (dataValida(dia,mes,ano)) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        }else{
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }
    
    private boolean dataValida(int dia, int mes, int ano){
        if (((dia>=1) && (dia<=31)) && ((mes>=1) && (mes<=12)))
            return true;
        else
            return false;
    }
    public void mostraData(){
        System.out.println(this.dia + "/" + this.mes + "/"+ this.ano);
    }
    
}
