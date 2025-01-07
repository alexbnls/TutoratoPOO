package es15;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String titolo;
    private String autore;
    private int anno;

    public Book(String titolo, String autore, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
    }

    @Override
    public int compareTo(Book book) {
        return Integer.compare(this.anno, book.anno);
    }

    public static Comparator<Book> bookComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.compareTo(o2);
        }
    };

    public String toString()
    {
        return "[Titolo: " + titolo + "] [Autore: " + autore + "] [Anno pubblicazione: " + anno + "]";
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnno() {
        return anno;
    }
}
