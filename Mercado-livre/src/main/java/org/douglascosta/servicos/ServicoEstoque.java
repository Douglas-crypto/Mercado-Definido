package org.douglascosta.servicos;

import org.douglascosta.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicoEstoque {

    public void adicionarEstoque(int fk_produto, int quantidade, String modelo) {
        String sql = "INSERT INTO estoque (fk_produto, quantidade, modelo) VALUES (?, ?, ?)";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, fk_produto);
            pstm.setInt(2, quantidade);
            pstm.setString(3, modelo);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("Cadastrado com êxito");
            } else {
                System.out.println("Não cadastrado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarEstoque(int idEstoque, int novaQuantidade) {

        if (novaQuantidade <= 0){
            System.out.println("Não é permitido quantidade igual a 0 ou menor, somente maior que zero");
            return;
        }

        String sql = "UPDATE estoque SET quantidade = ? WHERE id = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, novaQuantidade);
            pstm.setInt(2, idEstoque);

            int linhaAfet = pstm.executeUpdate();

            if (linhaAfet > 0) {
                System.out.println("classes.Estoque atualizado");
            } else {
                System.out.println("classes.Estoque não foi atualizado, verifique as informações");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void baixarEstoque(int idProduto) {
        String sql = "SELECT id, fk_produto, quantidade, modelo, FROM produto WHERE id = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, idProduto);

            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Chave estrangeira do produto: " + resultSet.getString("fk_produto"));
                System.out.println("Quantidade: " + resultSet.getString("quantidade"));
                System.out.println("Modelo: " + resultSet.getFloat("modelo"));
            } else {
                System.out.println("classes.Estoque não foi encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar visualizar o estoque: " + e.getMessage());
        }
    }
}


