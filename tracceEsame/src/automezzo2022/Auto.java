package automezzo2022;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Auto extends Automezzo{

    public Auto(String marca, String modello, int cavalli, String targa) {
        super(marca, modello, cavalli, targa);
    }

    @Override
    public double reso(GregorianCalendar data) throws PrestitoException {
        if(!isPrestato())
            throw new PrestitoException("auto non prestata");

        GregorianCalendar temp = (GregorianCalendar) getDataPrestito().clone();
        int giorniPrestito = 0;

        while(!temp.after(data))
        {
            giorniPrestito++;
            temp.add(Calendar.DAY_OF_MONTH, 1);
        }

        rilasciaPrestito();

        return giorniPrestito * (getCavalli() * 3L);
    }
}
