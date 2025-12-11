package oficinamecanica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControllerCliente {

    private Connection con;

    public ControllerCliente(Connection con) {
        this.con = con;
    }

    public ControllerCliente() {
    }

    public void inserirCliente(Cliente cliente) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Cliente inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM cliente";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public Cliente buscarClientePorNome(String nomeBusca) {
        Cliente cliente = null;
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM cliente WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeBusca);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return cliente;
    }

    public void alterarCliente(Cliente cliente) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "UPDATE cliente SET nome = ?, telefone = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Cliente alterado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirCliente(int id) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Cliente excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
