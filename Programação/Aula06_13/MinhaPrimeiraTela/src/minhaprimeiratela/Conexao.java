
package minhaprimeiratela;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection abrirConexao() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/semanaacademica";
            String usuario = "postgres";
            String senha = "ciet";
            conn = DriverManager.getConnection(URL, usuario, senha);
            System.out.println("Conexão Executada");
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }

        return conn;
    }
}
