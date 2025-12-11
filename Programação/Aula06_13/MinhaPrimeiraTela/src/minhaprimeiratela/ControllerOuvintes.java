package minhaprimeiratela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ControllerOuvintes {

    static Connection con = Conexao.abrirConexao();

    public void inserirOuvinte(Ouvintes ouv) {
        String SQL = "INSERT INTO ouvinte (nome, email) VALUES (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, ouv.getNome());
            ps.setString(2, ouv.getEmail());

            if (ps.executeUpdate() > 0) {
                System.out.println("Inclusão OK");
            } else {
                System.out.println("Problemas na Inserção");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void alterarOuvinte(Ouvintes ouv) {
        String SQL = "UPDATE ouvinte SET nome = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, ouv.getNome());
            ps.setString(2, ouv.getEmail());
            ps.setInt(3, ouv.getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("Alteração OK");
            } else {
                System.out.println("Ouvinte não encontrado para alteração");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao alterar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void excluirOuvinte(int id) {
        String SQL = "DELETE FROM ouvinte WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("Exclusão OK");
            } else {
                System.out.println("Ouvinte não encontrado para exclusão");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public List<Ouvintes> listarOuvintes() {
        List<Ouvintes> lista = new ArrayList<>();
        String SQL = "SELECT * FROM ouvinte";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ouvintes ouv = new Ouvintes();
                ouv.setId(rs.getInt("id"));
                ouv.setNome(rs.getString("nome"));
                ouv.setEmail(rs.getString("email"));
                lista.add(ouv);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean existeId(int id) {
        String SQL = "SELECT 1 FROM ouvinte WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // retorna true se encontrou, false se não
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
