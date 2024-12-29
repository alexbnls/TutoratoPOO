package automezzo2022;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Moto extends Automezzo{
    public Moto(String marca, String modello, int cavalli, String targa) {
        super(marca, modello, cavalli, targa);
    }

    @Override
    public double reso(GregorianCalendar data) throws PrestitoException {
        if(!isPrestato())
            throw new PrestitoException("auto non prestata");

        GregorianCalendar temp = (GregorianCalendar) getDataPrestito().clone();
        double costoTot = 0;

        while(!temp.after(data))
        {
            if(temp.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                    temp.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY )
                costoTot += 30;
            else
                costoTot += 20;

            temp.add(Calendar.DAY_OF_MONTH, 1);
        }

        rilasciaPrestito();

        return costoTot;
    }
}
