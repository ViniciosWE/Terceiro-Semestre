package oficinamecanica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerServicoRealizado {

    private Connection con;

    public ControllerServicoRealizado(Connection con) {
        this.con = con;
    }

    public ControllerServicoRealizado() {
    }

    public void inserirServicoRealizado(ServicoRealizado sr) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "INSERT INTO ServicoRealizado (id_ordemServico, id_servico, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sr.getIdOrdemServico());
            stmt.setInt(2, sr.getIdServico());
            stmt.setInt(3, sr.getQuantidade());
            stmt.setDouble(4, sr.getPrecoUnitario());
            stmt.executeUpdate();
            stmt.close();

            String sqlUpdate = "UPDATE OrdemServico SET valor_total = valor_total + ? WHERE id = ?";
            PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
            double valorAdicionar = sr.getQuantidade() * sr.getPrecoUnitario();
            stmtUpdate.setDouble(1, valorAdicionar);
            stmtUpdate.setInt(2, sr.getIdOrdemServico());
            stmtUpdate.executeUpdate();
            stmtUpdate.close();

            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public List<ServicoRealizado> listarServicosRealizados() {
        List<ServicoRealizado> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM ServicoRealizado";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ServicoRealizado sr = new ServicoRealizado();
                sr.setId(rs.getInt("id"));
                sr.setIdOrdemServico(rs.getInt("id_ordemServico"));
                sr.setIdServico(rs.getInt("id_servico"));
                sr.setQuantidade(rs.getInt("quantidade"));
                sr.setPrecoUnitario(rs.getDouble("preco_unitario"));
                lista.add(sr);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public void alterarServicoRealizado(ServicoRealizado sr) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "UPDATE ServicoRealizado SET id_ordemServico = ?, id_servico = ?, quantidade = ?, preco_unitario = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sr.getIdOrdemServico());
            stmt.setInt(2, sr.getIdServico());
            stmt.setInt(3, sr.getQuantidade());
            stmt.setDouble(4, sr.getPrecoUnitario());
            stmt.setInt(5, sr.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirServicoRealizado(int id) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "DELETE FROM ServicoRealizado WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public ServicoRealizado buscarServicoRealizadoPorId(int id) {
        for (ServicoRealizado sr : listarServicosRealizados()) {
            if (sr.getId() == id) {
                return sr;
            }
        }
        return null;
    }

    public double buscarPrecoUnitarioPorIdServico(int idServico) {
        double preco = 0.0;
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT preco FROM Servico WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idServico);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                preco = rs.getDouble("preco");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return preco;
    }
    
    public List<ServicoRealizado> listarServicosRealizadosPorOrdem(int idOrdemServico) {
    List<ServicoRealizado> lista = new ArrayList<>();
    try {
        Connection conn = Conexao.abrirConexao();
        String sql = "SELECT sr.id, sr.id_ordemServico, sr.id_servico, sr.quantidade, sr.preco_unitario, s.nome " +
                     "FROM ServicoRealizado sr " +
                     "JOIN Servico s ON sr.id_servico = s.id " +
                     "WHERE sr.id_ordemServico = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idOrdemServico);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ServicoRealizado sr = new ServicoRealizado();
            sr.setId(rs.getInt("id"));
            sr.setIdOrdemServico(rs.getInt("id_ordemServico"));
            sr.setIdServico(rs.getInt("id_servico"));
            sr.setQuantidade(rs.getInt("quantidade"));
            sr.setPrecoUnitario(rs.getDouble("preco_unitario"));
            String nomeServico = rs.getString("nome");
            sr.setNomeServico(nomeServico); 

            lista.add(sr);
        }
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
    return lista;
}


}
