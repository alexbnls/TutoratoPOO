package es17;

public class Fumetto extends Libro {
    private String disegnatore;
    private String casaEditrice;
    private int numPagine;
    private boolean saga;
    private String target;

    public Fumetto(String titolo, String autore, int isbn, int annoPubblicazione, String disegnatore, String casaEditrice, int numPagine, boolean saga, String target) {
        super(titolo, autore, isbn, annoPubblicazione);
        this.disegnatore = disegnatore;
        this.casaEditrice = casaEditrice;
        this.numPagine = numPagine;
        this.saga = saga;
        this.target = target;
    }

    public String toString()
    {
        return super.toString() +
                "[Disegnatore: " + disegnatore + "] " +
                "[Casa editrice: " + casaEditrice + "] " +
                "[Num. pagine: " + numPagine + "] " +
                "[Saga: " + saga + "] " +
                "[Target udienza: " + target + "]";
    }

    public boolean equals(Object fumetto)
    {
        if(!super.equals(fumetto))
            return false;

        Fumetto comic = (Fumetto) fumetto;

        return comic.disegnatore.equals(disegnatore) &&
                comic.casaEditrice.equals(casaEditrice) &&
                comic.numPagine == numPagine &&
                comic.saga == saga &&
                comic.target.equals(target);
    }

    public Object clone()
    {
        return super.clone();
    }
}
