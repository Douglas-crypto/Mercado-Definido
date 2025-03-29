package org.douglascosta.repositorios;

import org.douglascosta.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RepositorioFrete {
    public Map<String, Object> getById(int id) {
            String sql = "SELECT * FROM frete WHERE id = ?";

            try (Connection conn = new ConnectionDB().getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setLong(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Map<String, Object> freteMapa = new HashMap<>();

                        freteMapa.put("id", rs.getInt("id"));
                        freteMapa.put("fk_venda", rs.getInt("fk_venda"));
                        freteMapa.put("valor", rs.getInt("valor"));
                        freteMapa.put("prazo_entrega", rs.getInt("prazo_entrega"));
                        freteMapa.put("transportadora", rs.getString("transportadora"));
                        freteMapa.put("status", rs.getString("status"));

                        return freteMapa;
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao buscar usuário com ID: " + id);
                e.printStackTrace();
            }
            return null;
        }
    }
