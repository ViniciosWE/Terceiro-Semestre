package oficinamecanica;

public class Veiculo {

    private int id;
    private String placa;
    private String modelo;
    private int idCliente;
    private String nomeCliente;

    public Veiculo() {
    }

    public Veiculo(String placa, String modelo, int idCliente, String nomeCliente) {
        this.placa = placa;
        this.modelo = modelo;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
