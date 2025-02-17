public class Main {
    public static void main(String[] args) {

        Cadastros cadastros = new Cadastros();

        User usuario1 = new User(1,"João Silva", "12345678901",
                "Rua A 123", "joao.silva@email.com", "senha123");

        cadastros.CadastroUser(usuario1);

        System.out.println();

     Product produto1 = new Product(1,"Notebook Dell","Notebook Dell Inspiron 15, 8GB RAM, 256GB SSD",
             3.500f,10,"imagens/notebook_dell.jpg", false);
        cadastros.CadastroProduto(produto1);

        FormasPagamento forma1 = new FormasPagamento(1,"PIX",3,15.0f);
        cadastros.CadastraFormaPagamento(forma1);

        System.out.println();

        Vendas venda1 = new Vendas(1,usuario1, produto1, 1,  forma1);
        cadastros.CadastraVenda(venda1);

        System.out.println();

        AvaliaCao avaliacao1 = new AvaliaCao(1, produto1, usuario1,1, "Produto de excelente qualidade");
        cadastros.CadastraAvaliacao(avaliacao1);

        Consultas consulta1 = new Consultas(cadastros);
        User usuarioConsultado = consulta1.consultaUsuarioPorId(1);
        if (usuarioConsultado != null) {
            System.out.println("Usuário: " + usuarioConsultado.getUsername() + ", ID: " + usuarioConsultado.getId());
        } else {
            System.out.println("Usuário não existente");
        }

        Product produtoConsultado = consulta1.consultaProdutoID(1);
        if (produtoConsultado != null) {
            System.out.println("Produto: " + produtoConsultado.getNome() + ", ID: " + produtoConsultado.getId());
        } else {
            System.out.println("Produto não existente");
        }

        Consultas consulta2 = new Consultas(cadastros);
        consulta2.consultaGeral();
    }
}
