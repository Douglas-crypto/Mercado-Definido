public class Product {
    private String nome;
    private String descricao;
    private double precoVenda;
    private int estoque;
    private String caminhoImagem;
    private boolean usado;

    Product(String nome, String descricao, double precoVenda, int estoque, String caminhoImagem, boolean usado){
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.caminhoImagem = caminhoImagem;
        this.usado = usado;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public boolean isUsado() {
        return usado;
    }
}
