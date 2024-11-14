package es14;

import java.util.ArrayList;

public class NoleggioTest {
    public static void main (String[] args)
    {
        ElencoNoleggi elencoNoleggi = new ElencoNoleggi();
        Film film1 = new Film("abc", "Natale");
        Film film2 = new Azione("aab", "Pasqua");
        Film film3 = new Commedia("aaa", "Boh");
        Film film4 = new Film("abc", "Natale");

        elencoNoleggi.aggiungiNoleggio(new Noleggio(film3, 2));
        elencoNoleggi.aggiungiNoleggio(new Noleggio(film2, 2));
        elencoNoleggi.aggiungiNoleggio(new Noleggio(film1, 2));

      //  System.out.println(film1.equals(film4));
        Film film5 = (Film) film2.clone();
        System.out.println("Clone + equals test: " + film2.equals(film5));

        System.out.println("Film ordinati per codice: " + elencoNoleggi);

        ArrayList<Noleggio> cercaProva = elencoNoleggi.cerca("Natale");
        System.out.println("Film trovato: " + cercaProva.getFirst().dammiFilm());

        System.out.println("Penale ritardo totale elenco: " + elencoNoleggi.calcolaPenaliRitardo());
    }
}
