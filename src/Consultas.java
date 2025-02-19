public class Consultas {
    Cadastros cadastros;

    public Consultas(Cadastros cadastros) {
        this.cadastros = cadastros;
    }

    public void consultaUsuarioPorId(int id) {
        for (User user : cadastros.usuarios) {
            if (user.getId() == id) {
                return;
            }
        }
    }

    public void consultaProdutoID(int id) {
        for (Product product : cadastros.produtos) {
            if (product.getId() == id) {
                return;
            }
        }
    }

    public void consultaGeral() {

        for (Vendas venda : cadastros.vendas) {
            System.out.println("Usuário ID: " + venda.getUsuario().getId() +
                    ", Produto ID: " + venda.getProduto().getId() +
                    ", Quantidade: " + venda.getQuantidade() +
                    ", Valor: " + venda.getProduto().getPrecoVenda());
        }

        // Exibe informações sobre as avaliações
        for (AvaliaCao avaliacao : cadastros.avaliacao) {
            System.out.println("Avaliação ID: " + avaliacao.getId() +
                    ", Usuário ID: " + avaliacao.getUsuario().getId() +
                    ", Produto ID: " + avaliacao.getProduto().getId() +
                    ", Comentário: " + avaliacao.getTexto());
        }
    }
}
