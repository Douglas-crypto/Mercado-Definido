import java.util.ArrayList;
import java.util.List;

public class Cadastros {
    List<User> usuarios = new ArrayList<>();
    List<Product> produtos = new ArrayList<>();
    List<Vendas> vendas = new ArrayList<>();
    List<FormasPagamento> formaPagamento = new ArrayList<>();
    List<AvaliaCao> avaliacao = new ArrayList<>();

    public boolean existeUsuarioCampo(String cpfcnpj, String email, int id, String username, String endereco, String password) {
        for (User usuario : usuarios) {
            if (usuario.getCpfCnpj().equals(cpfcnpj) ||
                    usuario.getEmail().equals(email) ||
                    usuario.getId() == id ||
                    usuario.getUsername().equals(username) ||
                    usuario.getEndereco().equals(endereco) ||
                    usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void CadastroUser(User user) {
        if (!existeUsuarioCampo(user.getCpfCnpj(), user.getEmail(),
                user.getId(), user.getUsername(),
                user.getEndereco(), user.getPassword())) {
            usuarios.add(user);
        } else {
            System.out.println("Já existe");
        }
    }

    public boolean existeProdutoCamp(int id, String nome, String descricao, float precoVenda, int estoque, String caminhoimagem) {
        for (Product product : produtos) {
            if (product.getId() == id ||
                    product.getNome().equals(nome) ||
                    product.getDescricao().equals(descricao) ||
                    product.getPrecoVenda() == precoVenda ||
                    product.getEstoque() == estoque ||
                    product.getCaminhoImagem().equals(caminhoimagem)) {
                return true;
            }
        }
        return false;
    }

    public void CadastroProduto(Product produto) {
        if (!existeProdutoCamp(produto.getId(), produto.getNome(), produto.getDescricao(),
                produto.getPrecoVenda(), produto.getEstoque(), produto.getCaminhoImagem())) {
            produtos.add(produto);
        } else {
            System.out.println("Nenhum campo pode ser duplicado");
        }
    }

    public boolean existeCampVend(int id, User user, int quantidade, Product product, FormasPagamento formasPagamento) {
        for (Vendas venda : vendas) {
            if (venda.getId() == id ||
                    venda.getUser().equals(user) ||
                    venda.getQuantidade() == quantidade ||
                    venda.getProduct().equals(product) ||
                    venda.getFormaPagamento().equals(formasPagamento)) {
                return true;
            }
        }
        return false;
    }

    public void CadastraVenda(Vendas venda) {
        if (!existeCampVend(venda.getId(), venda.getUser(), venda.getQuantidade(), venda.getProduct(), venda.getFormaPagamento())) {
            vendas.add(venda);
            System.out.println("Venda cadastrada com sucesso!");
        } else {
            System.out.println("Venda já existe.");
        }
    }

    public boolean existeCampFormaPag(int id) {
        for (FormasPagamento formasPagamento : formaPagamento) {
            if (formasPagamento.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void CadastraFormaPagamento(FormasPagamento formasPagamento) {
        if (!existeCampFormaPag(formasPagamento.getId())) {
            this.formaPagamento.add(formasPagamento);
            System.out.println("Forma de pagamento cadastrada com sucesso!");
        } else {
            System.out.println("Forma de pagamento já existe.");
        }
    }

    public boolean existeCampAvaliacao(int id) {
        for (AvaliaCao avaliaCao : avaliacao) {
            if (avaliaCao.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void CadastraAvaliacao(AvaliaCao avaliaCao) {
        if (!existeCampAvaliacao(avaliaCao.getId())) {
            this.avaliacao.add(avaliaCao);
            System.out.println("Avaliação cadastrada com sucesso!");
        } else {
            System.out.println("Avaliação já existe.");
        }
    }
}
