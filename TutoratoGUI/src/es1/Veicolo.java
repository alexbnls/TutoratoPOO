package es1;

public abstract class Veicolo {
    private String modello;
    private String marca;
    private double prezzo;
    private int annoImmatricolazione;

    public Veicolo(String modello, String marca, double prezzo, int annoImmatricolazione) {
        this.modello = modello;
        this.marca = marca;
        this.prezzo = prezzo;
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public abstract double calcolaPrezzoFinale();

    public String toString()
    {
        return "[Modello: " + modello + "] " +
                "[Marca: " + marca + "] " +
                "[Prezzo: " + prezzo + "] " +
                "[Anno: " + annoImmatricolazione + "]";
    }

    public String getModello() {
        return modello;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }
}
