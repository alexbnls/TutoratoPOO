package es14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElencoNoleggi {
    private final List<Noleggio> noleggi;

    public ElencoNoleggi()
    {
        this.noleggi = new ArrayList<>();
    }

    private final Comparator<Noleggio> codeComparator = new Comparator<Noleggio>() {
        @Override
        public int compare(Noleggio o1, Noleggio o2) {
            return o1.dammiFilm().dammiCodice().compareTo(o2.dammiFilm().dammiCodice());
        }
    };

    public void aggiungiNoleggio(Noleggio n)
    {
        noleggi.add(n);
        noleggi.sort(codeComparator);
    }

    public double calcolaPenaliRitardo()
    {
        double tot = 0;

        for(Noleggio noleggio: noleggi)
        {
            tot += noleggio.calcolaPenaleNoleggio();
        }

        return tot;
    }

    public ArrayList<Noleggio> cerca(String t)
    {
        ArrayList<Noleggio> noleggiCercati = new ArrayList<>();

        for(Noleggio noleggio: noleggi)
        {
            if(noleggio.dammiFilm().dammiTitolo().equals(t))
                noleggiCercati.add(noleggio);
        }

        return noleggiCercati;
    }

    public String toString()
    {
        String string = "";

        for(Noleggio noleggio: noleggi)
        {
            string += "\n" + noleggio.dammiFilm();
        }

        return string;
    }
}
