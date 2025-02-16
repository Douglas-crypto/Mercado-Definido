public class AvaliaCao {
    private Product produto;
    private User usuario;
    private int rating;
    private String texto;

    public AvaliaCao(Product produto, User usuario, int rating, String texto) {
        this.produto = produto;
        this.usuario = usuario;
        this.rating = rating;
        this.texto = texto;
    }
}
