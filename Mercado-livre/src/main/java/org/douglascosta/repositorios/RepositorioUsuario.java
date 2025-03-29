package org.douglascosta.repositorios;


import org.douglascosta.database.ConnectionDB;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RepositorioUsuario {

    public Map<String, Object> getById(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> usuarioMapa = new HashMap<>();

                    usuarioMapa.put("id", rs.getInt("id"));
                    usuarioMapa.put("nome_completo", rs.getString("nome_completo"));
                    usuarioMapa.put("cpf_cnpj", rs.getString("cpf_cnpj"));
                    usuarioMapa.put("email", rs.getString("email"));
                    usuarioMapa.put("senha", rs.getString("senha"));
                    usuarioMapa.put("endereco", rs.getString("endereco"));

                    return usuarioMapa;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
