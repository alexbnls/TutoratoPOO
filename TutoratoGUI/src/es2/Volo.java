package es2;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Volo {
    private String codice;
    private Aereo aereo;
    private String destinazione;
    private GregorianCalendar oraPartenza;
    private GregorianCalendar oraArrivo;
    private List<Passeggero> passeggeri;


    public Volo(String codice, Aereo aereo, String destinazione, GregorianCalendar oraPartenza, GregorianCalendar oraArrivo) {
        this.codice = codice;
        this.aereo = aereo;
        this.destinazione = destinazione;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        passeggeri = new ArrayList<>();
    }

    public void addPasseggero(Passeggero p)
    {
        if(!isVoloCompleto())
        {
            passeggeri.add(p);
            aereo.prenotaPosto();
        }
        else
            throw new IllegalArgumentException("Aereo al completo");
    }

    public void removePasseggero(Passeggero p)
    {
        if(!passeggeri.isEmpty()) {
            passeggeri.remove(p);
            aereo.liberaPosto();
        }
    }

    public boolean isVoloCompleto()
    {
        return !aereo.isPostoDisponibile();
    }

    public String getCodice() {
        return codice;
    }

    public Aereo getAereo() {
        return aereo;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public GregorianCalendar getOraPartenza() {
        return oraPartenza;
    }

    public GregorianCalendar getOraArrivo() {
        return oraArrivo;
    }

    public void setAereo(Aereo aereo) {
        this.aereo = aereo;
    }

    @Override
    public String toString() {
        return "Volo{" +
                "codice='" + codice + '\'' +
                ", aereo=" + aereo +
                ", destinazione='" + destinazione + '\'' +
                ", oraPartenza=" + oraPartenza +
                ", oraArrivo=" + oraArrivo +
                ", passeggeri=" + passeggeri +
                '}';
    }
}
