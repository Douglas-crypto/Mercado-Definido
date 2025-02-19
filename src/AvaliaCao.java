
public class AvaliaCao {
    private final int id;
    private final Product produto;
    private final User usuario;
    private int rating;
    private final String texto;

    public AvaliaCao(int id, Product produto, User usuario, int rating, String texto) {
        this.id = id;
        this.produto = produto;
        this.usuario = usuario;
        this.rating = rating;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public Product getProduto() {
        return produto;
    }

    public User getUsuario() {
        return usuario;
    }

    public int getRating() {
        return rating;
    }

    public String getTexto() {
        return texto;
    }
}
