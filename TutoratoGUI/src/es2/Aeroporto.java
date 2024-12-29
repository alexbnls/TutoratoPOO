package es2;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Aeroporto {
    private List<Volo> voli;
    private List<Aereo> aerei;
    private List<Persona> persone;
    private static int indexAereo = 0;

    public Aeroporto()
    {
        voli = new ArrayList<>();
        aerei = new ArrayList<>();
        persone = new ArrayList<>();
    }

    public void addAereo(Aereo aereo)
    {
        if(!aerei.contains(aereo))
            aerei.add(aereo);
        else
            throw new IllegalArgumentException("Aereo gia' presente");
    }
    public void pianificaVolo(String codiceVolo, String destinazione, GregorianCalendar oraPartenza, GregorianCalendar oraArrivo)
    {
        voli.add(new Volo(codiceVolo, aerei.get(indexAereo), destinazione, oraPartenza, oraArrivo));
        indexAereo++;
    }

    public void assegnaAereo(String codiceVolo, String idAereo)
    {
        for(Volo volo: voli)
        {
            if(volo.getCodice().equals(codiceVolo)) {
                for(Aereo aereo: aerei)
                {
                    if(aereo.getId().equals(idAereo)) {
                        volo.setAereo(aereo);
                        return;
                    }
                }
            }
        }

    }

    public void registraPasseggero(String codiceVolo, Passeggero p)
    {
        for(Volo volo: voli)
        {
            if(volo.getCodice().equals(codiceVolo)) {
                volo.addPasseggero(p);
                persone.add(p);
                return;
            }
        }

    }

    public void visualizzaVoli()
    {
        for(Volo volo: voli)
        {
            System.out.println(volo);
        }
    }

}
