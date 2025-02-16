import java.util.ArrayList;
import java.util.List;

public class Cadastros {

    List<User> usuarios = new ArrayList<>();
    List<Product> produtos = new ArrayList<>();
    List<Vendas> vendas = new ArrayList<>();
    List<FormasPagamento> formaPagamento = new ArrayList<>();
    List<AvaliaCao> avaliacao = new ArrayList<>();

    public void CadastroUser(User usuario){
        usuarios.add(usuario);
    }

    public void CadastroProduto( Product produto){
        produtos.add(produto);
    }

    public void CadastraVenda(Vendas venda){
        vendas.add(venda);
    }

    public void CadastraFormaPagamento(FormasPagamento formasPagamento){
        formaPagamento.add(formasPagamento);
    }

    public void CadastraAvaliacao(AvaliaCao avaliacaos){
        avaliacao.add(avaliacaos);
    }
}
