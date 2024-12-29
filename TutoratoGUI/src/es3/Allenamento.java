package es3;

import java.util.ArrayList;
import java.util.List;

public class Allenamento {
    List<Esercizio> esercizi;

    public Allenamento()
    {
        esercizi = new ArrayList<>();
    }

    public void addEsercizio(Esercizio esercizio)
    {
        esercizi.add(esercizio);
    }

    public void removeEsercizio(Esercizio esercizio)
    {
        if(!esercizi.contains(esercizio))
            throw new IllegalArgumentException("Esercizio non presente");

        esercizi.remove(esercizio);
    }

    public void visualizzaEsercizi()
    {
        for(Esercizio esercizio: esercizi)
            System.out.println(esercizio.eseguiEsercizio());
    }

    public int calcolaDurataAllenamento()
    {
        int tot = 0;

        for(Esercizio esercizio: esercizi)
            tot += esercizio.getDurata();

        return tot;
    }
}
