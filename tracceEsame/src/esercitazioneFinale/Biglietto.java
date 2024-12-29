package esercitazioneFinale;

import java.time.LocalTime;

public abstract class Biglietto {
    private String id;
    private String zona;
    private LocalTime orarioAttivazione;
    private boolean statoAttivazione;


    public Biglietto(String id, String zona, LocalTime orarioAttivazione) {
        this.id = id;
        this.zona = zona;
        this.orarioAttivazione = orarioAttivazione;
        statoAttivazione = false;
    }

    public void attivaBiglietto() throws Exception {
        if(statoAttivazione)
            throw new Exception("Biglietto gia' attivato");
        statoAttivazione = true;
    }

    public abstract double calcolaCosto();
    public abstract void aggiornaTariffa(int percent);

    public String toString()
    {
        return "ID: " + id + " ~ Zona: " + zona + " ~ Orario att: " + orarioAttivazione + " ~ Stato attiv: " + statoAttivazione;
    }

    public String getId() {
        return id;
    }

    public String getZona() {
        return zona;
    }

    public LocalTime getOrarioAttivazione() {
        return orarioAttivazione;
    }

    public boolean isStatoAttivazione() {
        return statoAttivazione;
    }
}
