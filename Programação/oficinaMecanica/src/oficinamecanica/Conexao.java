package oficinamecanica;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection abrirConexao() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String URL = "jdbc:postgresql://localhost:5432/oficina";
            String usuario = "postgres";
            String senha = "ciet";
            conn = DriverManager.getConnection(URL, usuario, senha);
            System.out.println("Conexão executada com sucesso!");
        } catch (Exception ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
        }
        return conn;
    }
}
