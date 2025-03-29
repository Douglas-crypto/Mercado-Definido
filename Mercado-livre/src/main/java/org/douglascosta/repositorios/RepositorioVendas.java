package org.douglascosta.repositorios;

import org.douglascosta.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RepositorioVendas {
    public Map<String, Object> getById(int id)  {
        String sql = "SELECT * FROM venda WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> vendasMapa = new HashMap<>();

                    vendasMapa.put("id", rs.getInt("id"));
                    vendasMapa.put("fk_usuario", rs.getInt("fk_usuario"));
                    vendasMapa.put("fk_forma_pgto", rs.getInt("fk_forma_pgto"));
                    vendasMapa.put("dt_venda", rs.getDate("dt_venda"));
                    vendasMapa.put("valor_total", rs.getDouble("valor_total"));

                    return vendasMapa;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar venda com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}
