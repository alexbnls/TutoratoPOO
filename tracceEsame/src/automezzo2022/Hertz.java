package automezzo2022;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Hertz {
    private final List<Automezzo> automezzi;

    public Hertz()
    {
        automezzi = new ArrayList<>();
    }

    public void addMezzo(Automezzo automezzo)
    {
        automezzi.add(automezzo);
    }

    public Automezzo dammiAutomezzoPerTarga(String targa)
    {
        for (Automezzo automezzo: automezzi)
        {
            if(automezzo.getTarga().equals(targa))
                return automezzo;
        }

        return null;
    }

    public Automezzo dammiAutomezzoPerModello(String modello)
    {
        for (Automezzo automezzo: automezzi)
        {
            if(automezzo.getTarga().equals(modello))
                return automezzo;
        }

        return null;
    }

    public List<Automezzo> dammiAutomezziInPrestito()
    {
        List<Automezzo> mezziPrestito = new ArrayList<>();

        for(Automezzo automezzo: automezzi)
        {
            if(automezzo.isPrestato())
                mezziPrestito.add(automezzo);
        }

        return mezziPrestito;
    }

    public void effettuaPrestito(String targa) throws PrestitoException {
        Automezzo automezzo = dammiAutomezzoPerTarga(targa);
        if(automezzo == null)
            throw new TargaException("mezzo inesistente");

        automezzo.prestito(new GregorianCalendar());
    }

    public double effettuaReso(String targa) throws PrestitoException {
        Automezzo automezzo = dammiAutomezzoPerTarga(targa);
        if(automezzo == null)
            throw new TargaException("mezzo inesistente");

        if(!automezzo.isPrestato())
            throw new PrestitoException("mezzo non in prestito");

        GregorianCalendar data = new GregorianCalendar();
        data.add(Calendar.DAY_OF_MONTH, 10);

        return automezzo.reso(data);
    }
}
