public class FormasPagamento {
    private int id;
    private String forma;
    private int quantParcelas;
    private float percJuros;


    public FormasPagamento(int id, String forma, int quantParcelas, float percJuros) {
        this.id = id;
        this.forma = forma;
        this.quantParcelas = quantParcelas;
        this.percJuros = percJuros;
    }

    public String getForma() {
        return forma;
    }

    public int getQuantParcelas() {
        return quantParcelas;
    }

    public double getPercJuros() {
        return percJuros;
    }
}
