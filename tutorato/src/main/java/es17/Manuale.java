package es17;

import javax.naming.event.ObjectChangeListener;

public class Manuale extends Libro {
    private String ambito;
    private String difficulty;
    private int edizione;
    private boolean esercizi;

    public Manuale(String titolo, String autore, int isbn, int annoPubblicazione, String ambito, String difficulty, int edizione, boolean esercizi) {
        super(titolo, autore, isbn, annoPubblicazione);
        this.ambito = ambito;
        this.difficulty = difficulty;
        this.edizione = edizione;
        this.esercizi = esercizi;
    }

    public String toString()
    {
        return super.toString() +
                "[Ambito: " + ambito + "] " +
                "[Difficolta': " + difficulty + "] " +
                "[N. Edizione: " + edizione + "] " +
                "[Esercizi presenti: " + esercizi + "]";
    }

    public boolean equals(Object manuale)
    {
        if(!super.equals(manuale))
            return false;

        Manuale man = (Manuale) manuale;

        return man.ambito.equals(ambito) &&
                man.difficulty.equals(difficulty) &&
                man.edizione == edizione &&
                man.esercizi == esercizi;
    }

    public Object clone()
    {
        return super.clone();
    }
}
