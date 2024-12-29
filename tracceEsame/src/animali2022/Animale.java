package animali2022;

public class Animale {
    private String nome;
    private double peso;
    private int nZampe;
    protected int contCibo;

    public Animale(String nome, double peso, int nZampe) {
        this.nome = nome;
        this.peso = peso;
        this.nZampe = nZampe;
    }

    public int getZampe() {
        return nZampe;
    }

    public double getPeso() {
        return peso;
    }

    public boolean vuoiMangiare() {
        return false;
    }

    public void mangia() {
        contCibo = 0;
    }

    public String toString() {
        return "[Nome animaletto: " + nome + "] " +
                "[Peso: " + peso + "] " +
                "[Zampe: " + nZampe + "]";
    }
}
