package es2;

public class Aereo {
    private String id;
    private String modello;
    private final int capienza;
    private int postiDisponibili;
    private int annoProd;


    public Aereo(String id, String modello, int capienza, int annoProd) {
        this.id = id;
        this.modello = modello;
        this.capienza = capienza;
        this.annoProd = annoProd;
        postiDisponibili = capienza;
    }

    public String getId()
    {
        return id;
    }

    public boolean isPostoDisponibile()
    {
        return postiDisponibili > 0;
    }

    public void prenotaPosto()
    {
        if(isPostoDisponibile())
            postiDisponibili--;
    }

    public void liberaPosto()
    {
        if(postiDisponibili < capienza)
            postiDisponibili++;
    }
}
