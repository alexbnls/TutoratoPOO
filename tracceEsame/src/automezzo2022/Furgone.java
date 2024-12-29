package automezzo2022;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Furgone extends Automezzo{
    public Furgone(String marca, String modello, int cavalli, String targa) {
        super(marca, modello, cavalli, targa);
    }

    @Override
    public double reso(GregorianCalendar data) throws PrestitoException {
        if(!isPrestato())
            throw new PrestitoException("auto non prestata");

        int prezzo;
        int giorniPrestito = 0;

        prezzo = switch (getMarca()) {
            case "Fiat" -> 30;
            case "Citroen" -> 35;
            case "Ford" -> 40;
            default -> throw new IllegalArgumentException("marca non valida");
        };

        GregorianCalendar temp = (GregorianCalendar) getDataPrestito().clone();

        while(!temp.after(data))
        {
            giorniPrestito++;
            temp.add(Calendar.DAY_OF_MONTH, 1);
        }


        rilasciaPrestito();

        return giorniPrestito * prezzo;
    }
}
