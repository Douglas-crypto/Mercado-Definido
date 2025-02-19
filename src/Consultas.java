public class Consultas {
    Cadastros cadastros;

    public Consultas(Cadastros cadastros) {
        this.cadastros = cadastros;
    }

    public void consultaUsuarioPorId(int id) {
        for (User user : cadastros.usuarios) {
            if (user.getId() == id) {
                System.out.println("Usuário: " + user.getId());
            }
        }
    }

    public void consultaProdutoID(int id) {
        for (Product product : cadastros.produtos) {
            if (product.getId() == id) {
                System.out.println("Produto: " + product.getId());
            }
        }
    }

    public void consultaFormasPagamentoID(int id) {
        for (FormasPagamento formasPagamento : cadastros.formaPagamento) {
            if (formasPagamento.getId() == id) {
                System.out.println("Forma de Pagamento: " + formasPagamento.getId());
            }
        }
    }

    public void consultaAvaliaCaoID(int id) {
        for (AvaliaCao avaliaCao : cadastros.avaliacao) {
            if (avaliaCao.getId() == id) {
                System.out.println("Avaliação: " + avaliaCao.getRating());
            }
        }
    }

    public void consultaGeral(int IDusuario, int IDproduto, int IDformaspagamento, int IDavaliacao, Product product) {
        consultaUsuarioPorId(IDusuario);
        consultaProdutoID(IDproduto);
        consultaFormasPagamentoID(IDformaspagamento);
        consultaAvaliaCaoID(IDavaliacao);
        System.out.println("Produto Valor: " + String.format("%.3f", product.getPrecoVenda()));

    }
}
