package org.douglascosta.servicos;

import org.douglascosta.database.ConnectionDB;

import java.sql.*;

public class ServicoVendas {
    public void listarVendas() {
        String sql = "SELECT id, fk_usuario, fk_forma_pgto, dt_venda, valor_total FROM venda WHERE id IN (3, 7)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet resultSet = pstm.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("ID Usuário: " + resultSet.getInt("fk_usuario"));
                System.out.println("ID Forma Pagto: " + resultSet.getInt("fk_forma_pgto"));
                System.out.println("Data Venda: " + resultSet.getTimestamp("dt_venda"));
                System.out.println("Valor Total: R$ " + resultSet.getBigDecimal("valor_total"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar vendas: " + e.getMessage());
        }
    }
    public void cadastrarVenda(int fk_usuario, int fk_forma_pgto, Date dt_venda, int valor_total) {
        String sql = "INSERT INTO venda (fk_usuario, fk_forma_pgto, dt_venda, valor_total) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, fk_usuario);
            pstm.setInt(2, fk_forma_pgto);
            pstm.setDate(3, dt_venda);
            pstm.setDouble(4, valor_total);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("Usuario foi cadastrado com exito");
            } else {
                System.out.println("Usuario não foi cadastrado com exito");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarVenda(int id_venda, String coluna, Object valor) {
        String sql = "UPDATE venda SET " + coluna + " = ?  WHERE id = ?";
        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            if (valor instanceof Integer) {
                pstm.setInt(1, (Integer) valor);
            } else if (valor instanceof Date) {
                pstm.setTimestamp(1, new Timestamp(((Date) valor).getTime()));
            } else {
                throw new IllegalArgumentException(" Tipo do dado não suportado " +valor.getClass().getName());
            }

            pstm.setInt(2, id_venda);

            int linhasAfetadas = pstm.executeUpdate();

            if (linhasAfetadas > 0){
                System.out.println(" Venda de ID " + id_venda + "atualizada com sucesso");
            } else {
                System.out.println("Nenhuma venda encontrada com o id:  " + id_venda);
            }
        }  catch (SQLException e) {
            System.err.println("Erro ao atualizar a venda com ID " + id_venda + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
