public class Main {
    public static void main(String[] args) {

        Cadastros cadastros = new Cadastros();

        User usuario1 = new User(1, "João Silva", "12345678901",
                "Rua A 123", "joao.silva@email.com", "senha123");

        cadastros.CadastroUser(usuario1);
        usuario1.exibirInformacao();

        System.out.println();

        User usuario2 = new User(2, "Maria Oliveiraa", "23456789012",
                "Rua B, 456", "maria.oliveira@email.com", "senha456");

        cadastros.CadastroUser(usuario2);
        usuario2.exibirInformacao();


        System.out.println();


        FormasPagamento forma1 = new FormasPagamento(1,TipoFormaPagamento.PIX,0,0f);
        cadastros.CadastraFormaPagamento(forma1);
        forma1.ExibirInformacao();
        System.out.println();

        FormasPagamento forma2 = new FormasPagamento(2,TipoFormaPagamento.CARTAO_CREDITO, 3,15.0f);
        cadastros.CadastraFormaPagamento(forma2);
        forma2.ExibirInformacao();
        System.out.println();

        FormasPagamento forma3 = new FormasPagamento(3,TipoFormaPagamento.CARTAO_DEBITO, 1,0f);
        cadastros.CadastraFormaPagamento(forma3);
        forma3.ExibirInformacao();
        System.out.println();

        Product product1 = new Product(1,"Notebook Dell","Notebook Dell Inspiron 15, 8GB RAM, 256GB SSD",
                3.500f,2,"imagens/notebook_dell.jpg", false);

        product1.isUsado(product1);
        cadastros.CadastroProduto(product1);


        Vendas venda1 = new Vendas(1,usuario1, product1, 1,  forma1);
        cadastros.CadastraVenda(venda1);

        venda1.CancelarVenda("Produto estragado");
        venda1.isCancelado();

        System.out.println();

        AvaliaCao avaliacao1 = new AvaliaCao(1, product1, usuario1,1, "Produto de excelente qualidade");
        cadastros.CadastraAvaliacao(avaliacao1);
        System.out.println(avaliacao1.getId() +
                avaliacao1.getRating()+
                avaliacao1.getTexto()+
                product1.getNome()+
                usuario1.getUser());

        System.out.println();

      Consultas consulta1 = new Consultas(cadastros);

        consulta1.consultaUsuarioPorId(2);

        consulta1.consultaProdutoID(1);

        consulta1.consultaFormasPagamentoID(3);

        consulta1.consultaAvaliaCaoID(1);

        System.out.println();

        consulta1.consultaGeral(1,1,2,1,product1);

    }
}
