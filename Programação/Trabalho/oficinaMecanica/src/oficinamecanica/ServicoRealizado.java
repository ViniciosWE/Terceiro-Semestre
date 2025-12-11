package oficinamecanica;

public class ServicoRealizado {
    private int id;
    private int idOrdemServico;
    private int idServico;
    private int quantidade;
    private double precoUnitario;

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdOrdemServico() { return idOrdemServico; }
    public void setIdOrdemServico(int idOrdemServico) { this.idOrdemServico = idOrdemServico; }

    public int getIdServico() { return idServico; }
    public void setIdServico(int idServico) { this.idServico = idServico; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
}
