package oficinamecanica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControllerServico {

    private Connection con;

    public ControllerServico(Connection con) {
        this.con = con;
    }

    public ControllerServico() {
    }

    public void inserirServico(Servico servico) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "INSERT INTO servico (nome, descricao, preco) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getPreco());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Serviço inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public List<Servico> listarServicos() {
        List<Servico> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM servico";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Servico s = new Servico();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setDescricao(rs.getString("descricao"));
                s.setPreco(rs.getDouble("preco"));
                lista.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public Servico buscarServicoPorNome(String nomeBusca) {
        Servico servico = null;
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM servico WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeBusca);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return servico;
    }

    public void alterarServico(Servico servico) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "UPDATE servico SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getPreco());
            stmt.setInt(4, servico.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Serviço alterado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirServico(int id) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "DELETE FROM servico WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Serviço excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Servico buscarServicoPorId(int id) {
        for (Servico s : listarServicos()) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

}
