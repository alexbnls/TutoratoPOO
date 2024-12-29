package esercitazioneFinale;

import java.time.LocalTime;

public class AbbonamentoMensile extends Biglietto{
    private int fascia;
    private double tariffa1 = 30;
    private double tariffa2 = 38;
    private double tariffa3 = 45;
    private double tariffa4 = 60;

    public AbbonamentoMensile(String id, String zona, LocalTime orarioAttivazione, int fascia) {
        super(id, zona, orarioAttivazione);
        this.fascia = fascia;
    }

    @Override
    public double calcolaCosto() {
        return switch (fascia) {
            case 1 -> tariffa1;
            case 2 -> tariffa2;
            case 3 -> tariffa3;
            case 4 -> tariffa4;
            default -> 0;
        };
    }

    @Override
    public void aggiornaTariffa(int percent) {
        double aumento = (double) percent / 100;
        tariffa1 = tariffa1 + (tariffa1 * aumento);
        tariffa2 = tariffa2 + (tariffa2 * aumento);
        tariffa3 = tariffa3 + (tariffa3 * aumento);
        tariffa4 = tariffa4 + (tariffa4 * aumento);
    }

    public String toString()
    {
        return super.toString() + " ~ Fascia: " + fascia;
    }
}
