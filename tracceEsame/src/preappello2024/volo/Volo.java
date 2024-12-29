package preappello2024.volo;

import java.time.LocalDate;

public abstract class Volo {
    private String codiceVolo;
    private int durata; //in ore
    private LocalDate data;
    private int postiDisponibiliEconomy;
    private int postiDisponibiliBusiness;
    private int miglia;


    public Volo(String codiceVolo, int durata, LocalDate data, int postiDisponibiliEconomy, int postiDisponibiliBusiness, int miglia) {
        this.codiceVolo = codiceVolo;
        this.durata = durata;
        this.data = data;
        this.postiDisponibiliEconomy = postiDisponibiliEconomy;
        this.postiDisponibiliBusiness = postiDisponibiliBusiness;
        this.miglia = miglia;
    }

    public abstract float calcolaPrezzoBiglietto(String classe) throws ClasseIndisponibileException;

    public void occupaPostoEconomy()
    {
        postiDisponibiliEconomy--;
    }

    public void occupaPostoBusiness()
    {
        postiDisponibiliBusiness--;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public int getDurata() {
        return durata;
    }

    public LocalDate getData() {
        return data;
    }

    public int getPostiDisponibiliEconomy() {
        return postiDisponibiliEconomy;
    }

    public int getPostiDisponibiliBusiness() {
        return postiDisponibiliBusiness;
    }

    public int getMiglia() {
        return miglia;
    }

    @Override
    public boolean equals(Object v) {
        if(v == null || v.getClass() != this.getClass())
            return false;

        Volo volo = (Volo) v;

        return volo.codiceVolo.equals(codiceVolo);
    }

    public String toString()
    {
        return "Durata: " + durata + " ore\nData: " + data.toString() + "\nPosti disp. economy: " + postiDisponibiliEconomy +"\nPosti disp. business: " + postiDisponibiliBusiness;
    }
}
