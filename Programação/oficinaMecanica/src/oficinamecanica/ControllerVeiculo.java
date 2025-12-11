package oficinamecanica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControllerVeiculo {

    private Connection con;

    public ControllerVeiculo(Connection con) {
        this.con = con;
    }

    public ControllerVeiculo() {
    }

    public void inserirVeiculo(Veiculo veiculo) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "INSERT INTO veiculo (placa, modelo, id_cliente) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getIdCliente());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Veículo inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public List<Veiculo> listarVeiculos() {
        List<Veiculo> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT veiculo.id AS veiculo_id, veiculo.placa, veiculo.modelo, cliente.nome "
                    + "FROM veiculo "
                    + "JOIN cliente ON veiculo.id_cliente = cliente.id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getInt("veiculo_id"));
                v.setPlaca(rs.getString("placa"));
                v.setModelo(rs.getString("modelo"));
                v.setNomeCliente(rs.getString("nome"));
                lista.add(v);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public Veiculo buscarVeiculoPorPlaca(String placaBusca) {
        Veiculo veiculo = null;
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM veiculo WHERE placa = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, placaBusca);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setIdCliente(rs.getInt("id_cliente"));
                String sqlCliente = "SELECT nome FROM cliente WHERE id = ?";
                PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente);
                stmtCliente.setInt(1, veiculo.getIdCliente());
                ResultSet rsCliente = stmtCliente.executeQuery();
                if (rsCliente.next()) {
                    veiculo.setNomeCliente(rsCliente.getString("nome"));
                }
                rsCliente.close();
                stmtCliente.close();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return veiculo;
    }

    public void alterarVeiculo(Veiculo veiculo) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "UPDATE veiculo SET placa = ?, modelo = ?, idcliente = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getIdCliente());
            stmt.setInt(4, veiculo.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Veículo alterado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirVeiculo(int id) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "DELETE FROM veiculo WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Veículo excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Veiculo buscarVeiculoPorId(int id) {
        for (Veiculo v : listarVeiculos()) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}
