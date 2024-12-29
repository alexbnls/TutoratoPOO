package esercitazioneFinale;

import java.time.Duration;
import java.time.LocalTime;

public class BigliettoOrario extends Biglietto{
    private LocalTime orarioFine;
    private double tariffaBase = 0.02;

    public BigliettoOrario(String id, String zona, LocalTime orarioAttivazione, LocalTime orarioFine) {
        super(id, zona, orarioAttivazione);
        if(orarioFine.equals(orarioAttivazione) || orarioFine.isBefore(orarioAttivazione))
            throw new IllegalArgumentException("orario di fine viene prima dell'inizio");
        this.orarioFine = orarioFine;
    }

    @Override
    public double calcolaCosto() {
        Duration duration = Duration.between(getOrarioAttivazione(), orarioFine);
        long minutes = duration.toMinutes();
        return tariffaBase*minutes;
    }

    @Override
    public void aggiornaTariffa(int percent) {
        double aumento = (double) percent / 100;
        tariffaBase = tariffaBase + (tariffaBase * aumento);
    }

    public String toString()
    {
        return super.toString() + " ~ Orario fine: " + orarioFine + " ~ Tariffa: " + tariffaBase;
    }
}
