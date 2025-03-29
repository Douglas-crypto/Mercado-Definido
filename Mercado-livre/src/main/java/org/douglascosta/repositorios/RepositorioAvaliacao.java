package org.douglascosta.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import org.douglascosta.database.ConnectionDB;

public class RepositorioAvaliacao {

        public Map<String, Object> getById(int id){
        String sql = "SELECT * FROM avaliacao WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> avaliacaoMapa = new HashMap<>();

                    avaliacaoMapa.put("id", rs.getInt("id"));
                    avaliacaoMapa.put("fk_usuario", rs.getInt("fk_usuario"));
                    avaliacaoMapa.put("fk_produto", rs.getInt("fk_produto"));
                    avaliacaoMapa.put("nota_produto", rs.getInt("nota_produto"));
                    avaliacaoMapa.put("texto", rs.getString("texto"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
