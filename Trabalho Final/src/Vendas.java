public class Vendas {
    private User usuario;
    private Product produto;
    private int quantidade;
    private FormasPagamento formaPagamento;
    private boolean cancelado;
    private String motivoCancelamento;

    public Vendas(User usuario, Product produto, int quantidade, FormasPagamento formaPagamento,
                  boolean cancelado, String motivoCancelamento) {

        this.usuario = usuario;
        this.produto = produto;
        this.quantidade = quantidade;
        this.formaPagamento = formaPagamento;
        this.cancelado = cancelado;
        this.motivoCancelamento = motivoCancelamento;
    }

    public User getUsuario() {
        return usuario;
    }

    public Product getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }
}
