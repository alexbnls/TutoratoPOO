package es17;

public class LibroNarrativa extends Libro{
    private String genere;
    private String lingua;
    private boolean premiato;
    private int numCapitoli;

    public LibroNarrativa(String titolo, String autore, int isbn, int annoPubblicazione, String genere, String lingua, boolean premiato, int numCapitoli) {
        super(titolo, autore, isbn, annoPubblicazione);
        this.genere = genere;
        this.lingua = lingua;
        this.premiato = premiato;
        this.numCapitoli = numCapitoli;
    }

    public String toString()
    {
        return super.toString() +
                "[Genere: " + genere + "] " +
                "[Lingua originale: " + lingua + "] " +
                "[Premiato: " + premiato + "] " +
                "[Numero capitoli: " + numCapitoli + "]";
    }

    public boolean equals(Object libro)
    {
        if(!(super.equals(libro)))
            return false;

        LibroNarrativa book = (LibroNarrativa) libro;

        return book.genere.equals(genere) &&
                book.lingua.equals(lingua) &&
                book.premiato == premiato &&
                book.numCapitoli == numCapitoli;
    }

    public Object clone()
    {
        return super.clone();
    }
}
