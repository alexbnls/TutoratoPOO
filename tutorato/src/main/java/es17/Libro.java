package es17;

import java.io.Serializable;
import java.util.Comparator;

public class Libro implements Cloneable, Serializable {
    private String titolo;
    private String autore;
    private int isbn;
    private int annoPubblicazione;


    public Libro(String titolo, String autore, int isbn, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public String toString()
    {
        return "[Titolo: " + titolo + "] " +
                "[Autore: " + autore + "] " +
                "[ISBN: " + isbn + "] " +
                "[Anno uscita: " + annoPubblicazione + "]";
    }

    public boolean equals(Object libro)
    {
        if(libro == null || libro.getClass() != getClass())
            return false;

        Libro book = (Libro) libro;

        return book.titolo.equals(titolo) &&
                book.autore.equals(autore) &&
                book.isbn == isbn &&
                book.annoPubblicazione == annoPubblicazione;
    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }

    public static final Comparator<Libro> titleSorter = new Comparator<Libro>() {
        @Override
        public int compare(Libro o1, Libro o2) {
            return o1.getTitolo().compareTo(o2.getTitolo());
        }
    };

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }
}
