package oficinamecanica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControllerMecanico {

    private Connection con;

    public ControllerMecanico(Connection con) {
        this.con = con;
    }

    public ControllerMecanico() {
    }

    public void inserirMecanico(Mecanico mecanico) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "INSERT INTO mecanico (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mecanico.getNome());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Mecânico inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir mecânico: " + e.getMessage());
        }
    }

    public List<Mecanico> listarMecanicos() {
        List<Mecanico> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM mecanico ORDER BY nome";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Mecanico m = new Mecanico();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                lista.add(m);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar mecânicos: " + e.getMessage());
        }
        return lista;
    }

    public Mecanico buscarMecanicoPorNome(String nomeBusca) {
        Mecanico mecanico = null;
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM mecanico WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeBusca);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mecanico = new Mecanico();
                mecanico.setId(rs.getInt("id"));
                mecanico.setNome(rs.getString("nome"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar mecânico: " + e.getMessage());
        }
        return mecanico;
    }

    public void alterarMecanico(Mecanico mecanico) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "UPDATE mecanico SET nome = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mecanico.getNome());
            stmt.setInt(2, mecanico.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Mecânico alterado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao alterar mecânico: " + e.getMessage());
        }
    }

    public void excluirMecanico(int id) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "DELETE FROM mecanico WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Mecânico excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir mecânico: " + e.getMessage());
        }
    }

    public Mecanico buscarMecanicoPorId(int id) {
        for (Mecanico m : listarMecanicos()) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}
