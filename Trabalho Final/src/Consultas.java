public class Consultas {
    Cadastros cadastros;


    public Consultas(Cadastros cadastros) {
        this.cadastros = cadastros;
    }

    public User consultaUsuarioPorId(int id) {
        for (User user : cadastros.usuarios) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Product consultaProdutoID(int id) {
        for (Product product : cadastros.produtos) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void consultaGeral() {
        for (Vendas venda : cadastros.vendas) {
            System.out.println("Usuário ID: " + venda.getUsuario().getId() +
                    ", Produto ID: " + venda.getProduto().getId() +
                    ", Quantidade: " + venda.getQuantidade() +
                    ", Valor: " + venda.getProduto().getPrecoVenda());


            AvaliaCao avaliacaoEncontrada = null;
            int i = 0;
            while (i < cadastros.avaliacao.size() && avaliacaoEncontrada == null) {
                AvaliaCao avaliacao = cadastros.avaliacao.get(i);
                if (avaliacao.getUsuario().getId() == venda.getUsuario().getId() &&
                        avaliacao.getProduto().getId() == venda.getProduto().getId()) {
                    avaliacaoEncontrada = avaliacao;
                }
                i++;
            }

            if (avaliacaoEncontrada != null) {
                System.out.println("Avaliação ID: " + avaliacaoEncontrada.getId() +
                        ", Usuário ID: " + avaliacaoEncontrada.getUsuario().getId() +
                        ", Produto ID: " + avaliacaoEncontrada.getProduto().getId() +
                        ", Comentário: " + avaliacaoEncontrada.getTexto());
            }
        }
    }
}
