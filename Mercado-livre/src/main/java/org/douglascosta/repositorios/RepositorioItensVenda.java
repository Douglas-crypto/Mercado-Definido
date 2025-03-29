package org.douglascosta.repositorios;

import org.douglascosta.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RepositorioItensVenda {
    public Map<String, Object> getById(int id) {
        String sql = "SELECT * FROM itens_venda WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> itensvendaMapa = new HashMap<>();

                    itensvendaMapa.put("id", rs.getInt("id"));
                    itensvendaMapa.put("fk_venda", rs.getInt("fk_venda"));
                    itensvendaMapa.put("fk_produto", rs.getInt("fk_produto"));
                    itensvendaMapa.put("fk_estoque", rs.getInt("fk_estoque"));
                    itensvendaMapa.put("preco_unit", rs.getInt("preso_unit"));
                    itensvendaMapa.put("quantidade", rs.getInt("quantidade"));
                    itensvendaMapa.put("subtotal", rs.getInt("subtotal"));

                    return itensvenda;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}



