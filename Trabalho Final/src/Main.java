public class Main {
    public static void main(String[] args) {

        Cadastros cadastros = new Cadastros();

        User usuario1 = new User("João Silva", "12345678901",
                "Rua A 123", "joao.silva@email.com", "senha123");

        cadastros.CadastroUser(usuario1);

        System.out.println(usuario1.getUsername());
        System.out.println(usuario1.getCpf_cnpj());
        System.out.println(usuario1.getEndereco());
        System.out.println(usuario1.getEmail());
        System.out.println(usuario1.getSenha());

        System.out.println();

     Product produto1 = new Product("Notebook Dell","Notebook Dell Inspiron 15, 8GB RAM, 256GB SSD",
             3.500f,10,"imagens/notebook_dell.jpg", false);

        System.out.println(produto1.getNome());
        System.out.println(produto1.getDescricao());
        System.out.println(String.format("%.3f", produto1.getPrecoVenda()));
        System.out.println(produto1.getEstoque());
        System.out.println(produto1.getCaminhoImagem());
        System.out.println(produto1.isUsado());

        cadastros.CadastroProduto(produto1);

        FormasPagamento forma1 = new FormasPagamento(1,"PIX", 3, 15.0f);

        cadastros.CadastraFormaPagamento(forma1);

        System.out.println();

        System.out.println(forma1.getForma());
        System.out.println(forma1.getPercJuros());
        System.out.println(forma1.getQuantParcelas());

        Vendas venda1 = new Vendas(usuario1, produto1, 1,  forma1);

        System.out.println();

        cadastros.CadastraVenda(venda1);

        System.out.println(usuario1.getUsername());
        System.out.println(produto1.getNome());
        System.out.println(forma1.getQuantParcelas());
        System.out.println(forma1.getPercJuros());
    }
}
