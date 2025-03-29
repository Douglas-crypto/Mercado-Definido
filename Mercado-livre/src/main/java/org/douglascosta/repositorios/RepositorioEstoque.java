package org.douglascosta.repositorios;


import org.douglascosta.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RepositorioEstoque {

    public Map<String, Object> getById(int id) {
        String sql = "SELECT * FROM estoque WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> estoqueMapa = new HashMap<>();

                    estoqueMapa.put("id", rs.getInt("id"));
                    estoqueMapa.put("fk_produto", rs.getInt("fk_produto"));
                    estoqueMapa.put("quantidade", rs.getInt("quantidade"));
                    estoqueMapa.put("modelo", rs.getString("modelo"));

                    return estoqueMapa;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar estoque com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
