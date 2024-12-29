package automezzo2022;

import java.util.GregorianCalendar;

public abstract class Automezzo {
    private String marca;
    private String modello;
    private int cavalli;
    private String targa;
    private boolean prestato;
    private GregorianCalendar dataPrestito;

    public Automezzo(String marca, String modello, int cavalli, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.cavalli = cavalli;
        this.targa = targa;
        prestato = false;
    }

    public boolean isPrestato()
    {
        return prestato;
    }

    public void rilasciaPrestito()
    {
        prestato = false;
    }

    public void prestito(GregorianCalendar data) throws PrestitoException {
        if(isPrestato())
            throw new PrestitoException("auto gia' prestata");

        dataPrestito = data;
        prestato = true;
    }
    public abstract double reso(GregorianCalendar data) throws PrestitoException;

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getCavalli() {
        return cavalli;
    }

    public String getTarga() {
        return targa;
    }

    public GregorianCalendar getDataPrestito() {
        return dataPrestito;
    }

    @Override
    public String toString() {
        return "[Targa: '" + targa + '\'' +
                ", Cavalli: " + cavalli +
                ", Modello: '" + modello + '\'' +
                ", Marchio: '" + marca + '\'' +
                ", prestato: " + prestato +
                ']';
    }
}
