public class Vendas {
    private final int id;
    User user;
    Product product;
    private int quantidade;
    FormasPagamento formaPagamento;
    private boolean cancelado;
    private String motivoCancelamento;

    public Vendas(int id, User usuario, Product produto, int quantidade, FormasPagamento formaPagamento) {
        this.id = id;
        this.user = usuario;
        this.product = produto;
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
        if (cancelado) {
            System.out.println("Venda cancelada");
            return true;
        } else {
            System.out.println("Venda não cancelada");
            return false;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public Product getProduct() {
        return product;
    }
}
