public class Vendas {
    private final int id;
    private User usuario;
    private Product produto;
    private int quantidade;
    private FormasPagamento formaPagamento;
    private boolean cancelado;
    private String motivoCancelamento;

    public Vendas(int id, User usuario, Product produto, int quantidade, FormasPagamento formaPagamento) {

        this.id = id;
        this.usuario = usuario;
        this.produto = produto;
        this.quantidade = quantidade;
        this.formaPagamento = formaPagamento;
        this.cancelado = false;
        this.motivoCancelamento = null;
    }

    public void CancelarVenda(String motivo){
        if (!this.cancelado){
            this.cancelado = true;
            this.motivoCancelamento = motivo;
        } else {
            System.out.println("Venda não foi cancelada");
        }

    }
    public boolean isCancelado() {
        return cancelado;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public int getId() {
        return id;
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
}
