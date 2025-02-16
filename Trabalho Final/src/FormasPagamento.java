public class FormasPagamento {
    private String forma;
    private int quantParcelas;
    private double percJuros;


    public FormasPagamento(String forma, int quantParcelas, double percJuros) {
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
