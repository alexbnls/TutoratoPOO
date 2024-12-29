package esercizi.stream;

public class Libro {
    private String titolo;
    private Autore autore;

    public Libro(String titolo, Autore autore)
    {
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public Autore getAutore() {
        return autore;
    }

    public String toString()
    {
        return "[Titolo: " + titolo + "] [Autore: " + autore.getNome() + " " + autore.getCognome() + "]";
    }
}
