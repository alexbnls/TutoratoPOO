package preappello2024.passeggero;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PasseggeroEconomica extends Passeggero{
    public PasseggeroEconomica(String cognome, String nome, int puntiFedelta, int annoIscrizionePianoFedelta) {
        super(cognome, nome, puntiFedelta, annoIscrizionePianoFedelta);
    }

    @Override
    public void guadagnaPunti(int miglia) throws LimitePuntiFedeltaException {
        int punti = miglia/100;
        int annoCorrente = LocalDate.now().getYear();

        if(annoCorrente - getAnnoIscrizionePianoFedelta() > 10)
            punti *= 2;

        if(getPuntiFedelta() + punti > 10000)
            throw new LimitePuntiFedeltaException();

        addPuntiFedelta(punti);
    }
}
