
package Aula06_06.Exercicio02Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    static Connection con = Conexao.abrirConexao();

    public void inserirProdutos(Produtos prod) {
        String SQL = "INSERT INTO produtos (nome, preco, qtd) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, prod.getNome());
            ps.setDouble(2, prod.getPreco());
            ps.setInt(3, prod.getQtd());

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

    public void alterarProdutos(Produtos prod) {
        String SQL = "UPDATE produtos SET nome = ?, preco = ?, qtd = ? WHERE codigo = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, prod.getNome());
            ps.setDouble(2, prod.getPreco());
            ps.setInt(3, prod.getQtd());
            ps.setInt(4, prod.getCodigo());

            if (ps.executeUpdate() > 0) {
                System.out.println("Alteração OK");
            } else {
                System.out.println("Produto não encontrado para alteração");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao alterar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void excluirProdutos(int codigo) {
        String SQL = "DELETE FROM produtos WHERE codigo = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, codigo);

            if (ps.executeUpdate() > 0) {
                System.out.println("Exclusão OK");
            } else {
                System.out.println("Produto não encontrado para exclusão");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public List<Produtos> listarProdutos() {
        List<Produtos> listaProd = new ArrayList<Produtos>();
        String SQL = "SELECT * FROM produtos";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQtd(rs.getInt("qtd"));
                listaProd.add(prod);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listaProd;
    }
}
