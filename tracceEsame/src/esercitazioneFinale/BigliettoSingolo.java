package esercitazioneFinale;

import java.time.LocalTime;

public class BigliettoSingolo extends Biglietto{
    private int km;
    private double tariffaBase = 0.01;
    private double tariffaAggiuntiva = 0.025;

    public BigliettoSingolo(String id, String zona, LocalTime orarioAttivazione, int km) {
        super(id, zona, orarioAttivazione);
        this.km = km;
    }

    @Override
    public double calcolaCosto() {
        if(km > 10)
            return (tariffaBase * 10) + (tariffaAggiuntiva * (km - 10));
        else
            return tariffaBase * km;
    }

    public void aggiornaTariffa(int percent) {
        double aumento = (double) percent / 100;
        tariffaBase = tariffaBase + (tariffaBase * aumento);
        tariffaAggiuntiva = tariffaAggiuntiva + (tariffaAggiuntiva * aumento);
    }

    public String toString()
    {
        return super.toString() + " ~ KM: " + km + " ~ Tariffa base: " + tariffaBase + " ~ Tariffa agg: " + tariffaAggiuntiva;
    }
}
