package aeromobile2023;

import java.util.GregorianCalendar;
import java.util.List;

public class Aeroplano extends Aeromobile{
    private String modello;
    private String codiceVolo;
    private List<String> rotta;
    private int durataVolo;


    public Aeroplano(int durataVolo, List<String> rotta, String modello, String codiceVolo) {
        this.durataVolo = durataVolo;
        this.rotta = rotta;
        this.modello = modello;
        this.codiceVolo = codiceVolo;
    }

    public Aeroplano(GregorianCalendar dataRevisione, GregorianCalendar dataVolo, int numPasseggeri, int durataVolo, List<String> rotta, String modello, String codiceVolo) {
        super(dataRevisione, dataVolo, numPasseggeri);
        this.durataVolo = durataVolo;
        this.rotta = rotta;
        this.modello = modello;
        this.codiceVolo = codiceVolo;
    }

    public boolean equals(Object obj)
    {
        if(!super.equals(obj))
            return false;

        Aeroplano aeroplano = (Aeroplano) obj;

        return aeroplano.getModello().equals(modello) &&
                aeroplano.getCodiceVolo().equals(codiceVolo) &&
                aeroplano.getRotta().equals(rotta) &&
                aeroplano.getDurataVolo() == durataVolo;
    }

    public String toString()
    {
        return super.toString() + "[Modello: " + modello + "] " +
                "[Codice volo: " + codiceVolo + "] " +
                "[Durata volo: " + durataVolo + "]";
    }

    public String getModello() {
        return modello;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public List<String> getRotta() {
        return rotta;
    }

    public int getDurataVolo() {
        return durataVolo;
    }
}
