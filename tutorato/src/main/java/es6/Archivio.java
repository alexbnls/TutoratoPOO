package es6;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    private List<Action> azioni;

    public Archivio(List<Action> azioni)
    {
        this.azioni = azioni;
    }

    public double getTotaleAzioni()
    {
        double tot = 0;

        for(Action azione : azioni)
        {
            tot += azione.getImporto();
        }

        return tot;
    }


    public double getInformazioneAzione(Action azione)
    {
        for(Action a : azioni)
        {
            if(a.equals(azione))
                return a.getImporto();
        }
        return 0;
    }

    public List getAzioniTipologia(char tipo)
    {
        List<Action> actionList = new ArrayList<>();

        for(Action action: azioni)
        {
            if(action.getTipologia() == tipo)
                actionList.add(action);
        }

        return actionList;
    }

    public Action cercaAzionePiuAlta()
    {
        Action max = azioni.getFirst();
        for(Action action : azioni)
        {
            if(action.getImporto() > max.getImporto())
                max = action;
        }
        return max;
    }

    public List cercaRangeAzion(int max)
    {
        List<Action> actionList = new ArrayList<>();

        for(Action action : azioni)
        {
            if(action.getImporto() < max)
                actionList.add(action);

        }

        return actionList;
    }
}
