package org.douglascosta;

import org.douglascosta.repositorios.*;

import java.util.Map;

public class TestesRepo {
    public static void main(String[] args) {
        RepositorioProduto repositorioProduto = new RepositorioProduto();
        Map<String, Object> produto = repositorioProduto.getById(4);
        System.out.println("Produto encontrado: " + (produto != null ? produto.get("nome_produto") : "Nenhum produto encontrado"));

        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        Map<String, Object> usuario = repositorioUsuario.getById(4);
        System.out.println("Usuario encontrado: " + (usuario != null ? usuario.get("nome_completo") : "Nenhum usuario encontrado"));

        RepositorioVendas repositorioVendas =new RepositorioVendas();
        Map<String, Object> vendas = repositorioVendas.getById(4);
        System.out.println("Chave estrangeira usuario : " + (vendas != null ? vendas.get("fk_usuario") : "Nenhuma chave estrangeira encontrada"));

        RepositorioItensVenda repositorioItensVenda = new RepositorioItensVenda();
        Map<String, Object> itensvenda = repositorioItensVenda.getById(4);
        System.out.println("Repositorio itens venda: " + (itensvenda != null ? itensvenda.get("fk_venda") : "Nenhum chave estrangeira de venda encontrada"));

        RepositorioEstoque repositorioEstoque = new RepositorioEstoque();
        Map<String, Object> estoque =repositorioEstoque.getById(4);
        System.out.println("Quantidade no estoque: " +
                (estoque != null ? estoque.get("quantidade") : "Nenhuma quantidade de produto no estoque"));

        RepositorioAvaliacao repositorioAvalicao = new RepositorioAvaliacao();
        Map<String, Object> avaliaCao = repositorioAvalicao.getById(4);
        System.out.println("Nota do produto ID 1: " +
                (avaliaCao != null ? avaliaCao.get("texto") : "Nenhuma nota encontrada"));

        RepositorioFormasPagamento repositorioFormasPagamento = new RepositorioFormasPagamento();
        Map<String, Object> formasPagamento= repositorioFormasPagamento.getById(4);
        System.out.println("Forma de pagamento encontrada: " +
                (formasPagamento != null ? formasPagamento.get("nome_forma") : "Nenhuma forma de pagamento encontrada"));

        RepositorioFrete repositorioFrete = new RepositorioFrete();
        Map<String, Object> frete = repositorioFrete.getById(4);
        System.out.println("Transportadora encontrda: " +
                (frete != null ? frete.get("transportadora") : "Nenhuma transportadora encontrada"));









    }
}