package es11;

import java.util.ArrayList;
import java.util.List;

public class SistemaScommesse {
    private final List<Scommessa> scommesse;

    public SistemaScommesse()
    {
        scommesse = new ArrayList<>();
    }

    public void aggiungiScommessa(Scommessa s)
    {
        scommesse.add(s);
    }

    String daiTipoScommessa(int i)
    {
        assert scommesse.size() >= i:
                "scommessa non esistente";

        return scommesse.get(i).getClass().getSimpleName();
    }

    Scommessa getMinimo()
    {
        assert !scommesse.isEmpty():
                "scommesse vuote";

        Scommessa min = scommesse.getFirst();
        for(Scommessa scommessa: scommesse)
        {
            if(scommessa.calcolaVincita() < min.calcolaVincita())
                min = scommessa;
        }

        return min;
    }

    Scommessa getMassimo()
    {
        assert !scommesse.isEmpty():
                "scommesse vuote";

        Scommessa max = scommesse.getFirst();
        for(Scommessa scommessa: scommesse)
        {
            if(scommessa.calcolaVincita() > max.calcolaVincita())
                max = scommessa;
        }

        return max;
    }

    ArrayList<Scommessa> cerca(String tipo)
    {
        ArrayList<Scommessa> bets = new ArrayList<>();

        for(int i = 0; i < scommesse.size(); i++)
        {
            String t = daiTipoScommessa(i);
            if(t.equals(tipo))
                bets.add(scommesse.get(i));
        }

        return bets;
    }

    double calcolaVincita()
    {
        double tot = 0;
        for(Scommessa scommessa: scommesse)
            tot += scommessa.calcolaVincita();

        return tot;
    }
}
