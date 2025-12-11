package oficinamecanica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerOrdemServico {

     private Connection con;
    
    public ControllerOrdemServico(Connection con) {
        this.con = con;
    }
    public ControllerOrdemServico(){}
    
    public void inserirOrdemServico(OrdemServico ordem) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "INSERT INTO OrdemServico (id_veiculo, id_mecanico, data, descricao, valor_total) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ordem.getIdVeiculo());
            stmt.setInt(2, ordem.getIdMecanico());
            stmt.setString(3, ordem.getData());
            stmt.setString(4, ordem.getDescricao());
            stmt.setDouble(5, ordem.getValorTotal());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir ordem: " + e.getMessage());
        }
    }

    public List<OrdemServico> listarOrdensServico() {
        List<OrdemServico> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM OrdemServico ORDER BY id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                OrdemServico o = new OrdemServico();
                o.setId(rs.getInt("id"));
                o.setIdVeiculo(rs.getInt("id_veiculo"));
                o.setIdMecanico(rs.getInt("id_mecanico"));
                o.setData(rs.getString("data"));
                o.setDescricao(rs.getString("descricao"));
                o.setValorTotal(rs.getDouble("valor_total"));
                lista.add(o);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar ordens: " + e.getMessage());
        }
        return lista;
    }

    public OrdemServico buscarOrdemPorId(int id) {
        OrdemServico o = null;
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM OrdemServico WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                o = new OrdemServico();
                o.setId(rs.getInt("id"));
                o.setIdVeiculo(rs.getInt("id_veiculo"));
                o.setIdMecanico(rs.getInt("id_mecanico"));
                o.setData(rs.getString("data"));
                o.setDescricao(rs.getString("descricao"));
                o.setValorTotal(rs.getDouble("valor_total"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar ordem: " + e.getMessage());
        }
        return o;
    }

    public OrdemServico buscarUltimaOrdemPorVeiculo(int idVeiculo) {
        OrdemServico o = null;
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM OrdemServico WHERE id_veiculo = ? ORDER BY id DESC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                o = new OrdemServico();
                o.setId(rs.getInt("id"));
                o.setIdVeiculo(rs.getInt("id_veiculo"));
                o.setIdMecanico(rs.getInt("id_mecanico"));
                o.setData(rs.getString("data"));
                o.setDescricao(rs.getString("descricao"));
                o.setValorTotal(rs.getDouble("valor_total"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar última ordem por veículo: " + e.getMessage());
        }
        return o;
    }

    public void alterarOrdemServico(OrdemServico ordem) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "UPDATE OrdemServico SET id_veiculo = ?, id_mecanico = ?, data = ?, descricao = ?, valor_total = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ordem.getIdVeiculo());
            stmt.setInt(2, ordem.getIdMecanico());
            stmt.setString(3, ordem.getData());
            stmt.setString(4, ordem.getDescricao());
            stmt.setDouble(5, ordem.getValorTotal());
            stmt.setInt(6, ordem.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao alterar ordem: " + e.getMessage());
        }
    }

    public void excluirOrdemServico(int id) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "DELETE FROM OrdemServico WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao excluir ordem: " + e.getMessage());
        }
    }

    public OrdemServico buscarOrdemServicoPorId(int id) {
        for (OrdemServico o : listarOrdensServico()) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }
}
