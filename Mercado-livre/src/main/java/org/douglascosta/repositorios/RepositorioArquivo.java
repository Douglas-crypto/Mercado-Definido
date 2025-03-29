package org.douglascosta.repositorios;
import org.douglascosta.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RepositorioArquivo {

    public Map<String, Object> getById(int id) {
        String sql = "SELECT * FROM arquivo WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> arquivoMapa = new HashMap<>();

                    arquivoMapa.put("id:", rs.getInt("id"));
                    arquivoMapa.put("fk_produto", rs.getInt("fk_produto"));
                    arquivoMapa.put("nome_arquivo", rs.getString("nome_arquivo"));
                    arquivoMapa.put("caminho_imagem", rs.getString("caminho_imagem"));

                    return arquivoMapa;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}

