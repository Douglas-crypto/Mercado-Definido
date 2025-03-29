package org.douglascosta.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionDB {
    // Carrega o .env automaticamente
   private static final Dotenv dotenv = Dotenv.load();

   // Tenta a conexao ao banco
   public Connection getConnection() {
       Connection connection = null;

       try {
           String url = dotenv.get("DB_URL");
           String user = dotenv.get("DB_USER");
           String password = dotenv.get("DB_PASSWORD");
           connection = DriverManager.getConnection(url, user, password);

           if (connection != null) {
                System.out.println("PostgreSQL conectado! Database: " + dotenv.get("DB_URL"));
           }

       } catch (SQLException e) {
           throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
       }
       return connection;
   }

    public void executarAtualiza(String query, Object... parametros) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < parametros.length; i++) {
                statement.setObject(i + 1, parametros[i]);
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fecharConexao(Connection connection) throws SQLException {
        if (getConnection() != null && !connection.isClosed()) {
            getConnection().close();
        }
    }
}