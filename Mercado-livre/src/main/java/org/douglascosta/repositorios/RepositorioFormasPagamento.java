package org.douglascosta.repositorios;
import org.douglascosta.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RepositorioFormasPagamento {
    public Map<String, Object> getById(int id) {
        String sql = "SELECT * FROM forma_pgto WHERE id = ?";

        try (Connection conn = new ConnectionDB().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> formaPagamentoMapa = new HashMap<>();

                    formaPagamentoMapa.put("id", rs.getInt("id"));
                    formaPagamentoMapa.put("nome_forma", rs.getString("nome_forma"));
                    formaPagamentoMapa.put("quant_parcelas", rs.getInt("quant_parcelas"));
                    formaPagamentoMapa.put("perc_juros", rs.getInt("perc_juros"));
                    formaPagamentoMapa.put("inativo", rs.getBoolean("inativo"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar forma de pagamento com ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
}