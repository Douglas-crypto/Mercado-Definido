package org.douglascosta.repositorios;

import org.douglascosta.database.ConnectionDB;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RepositorioProduto {
    public Map<String, Object> getById(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> produtoMapa = new HashMap<>();

                    produtoMapa.put("id", rs.getInt("id"));
                    produtoMapa.put("nome_produto", rs.getString("nome_produto"));
                    produtoMapa.put("descricao", rs.getString("descricao"));
                    produtoMapa.put("preco", rs.getDouble("preco"));
                    produtoMapa.put("usado", rs.getBoolean("usado"));

                    return produtoMapa;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
