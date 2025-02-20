public class Product {
    private final int id;
    private final String nome;
    private final String descricao;
    private float precoVenda;
    private int estoque;
    private final String caminhoImagem;
    private final boolean usado;

    Product(int id, String nome, String descricao, float precoVenda, int estoque, String caminhoImagem, boolean usado){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.caminhoImagem = caminhoImagem;
        this.usado = usado;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public boolean isUsado(Product product) {
        return product.usado;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }
}
