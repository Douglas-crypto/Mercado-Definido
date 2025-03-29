package org.douglascosta.servicos;

import org.douglascosta.Interfaces.ArmazenamentoArquivos;
import org.douglascosta.database.ConnectionDB;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicoArquivo  implements ArmazenamentoArquivos {
    private final Path diretorioDestino;
    private final ConnectionDB connectionDB;

    ServicoArquivo(String diretorioDestino, ConnectionDB connectionDB) {
        this.diretorioDestino = Path.of(diretorioDestino);
        this.connectionDB = connectionDB;

        if (!Files.exists(this.diretorioDestino) || !Files.isDirectory(this.diretorioDestino)) {
            throw new IllegalArgumentException("Diretório não é válido: " + this.diretorioDestino);
        }
    }

    @Override
    public String Armazena(File file) {
        Path destino = diretorioDestino.resolve(file.getName());

        try {
            Files.copy(file.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

            String sql = "INSERT INTO arquivo (fk_produto, nome_arquivo, caminho_arquivo) VALUES (?, ?, ?)";
            connectionDB.executarAtualiza(sql, file.getName(), destino.toAbsolutePath().toString());

            System.out.println("Arquivo copiado em: " + destino.toAbsolutePath());
            return destino.toAbsolutePath().toString();

        } catch (IOException exception) {
            throw new RuntimeException("Erro na cópia do arquivo ou salvamento", exception);
        }
    }

    @Override
    public String getByCaminho(String caminho) {
        String sql = "SELECT * FROM arquivo WHERE caminho_arquivo = ?";

        try (Connection conn = connectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, caminho);

            try (ResultSet rst = stmt.executeQuery()) {
                if (rst.next()) {
                    return "Arquivo encontrado: " + rst.getString("nome_arquivo") + " no caminho: " + rst.getString("caminho_arquivo");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar arquivo pelo caminho.", e);
        }

        return "Arquivo não encontrado.";
    }

    @Override
    public String getUrl(String id) {
        String sql = "SELECT caminho_arquivo FROM arquivo WHERE id = ?";

        try (Connection conn = connectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rest = pstmt.executeQuery()) {
                if (rest.next()) {
                    return "file://" + rest.getString("caminho_arquivo");
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o caminho do arquivo", e);
        }

        return "URL não foi encontrada";
    }
}

