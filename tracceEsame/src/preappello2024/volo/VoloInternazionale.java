package preappello2024.volo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VoloInternazionale extends Volo{
    public VoloInternazionale(String codiceVolo, int durata, LocalDate data, int postiDisponibiliEconomy, int postiDisponibiliBusiness, int miglia) {
        super(codiceVolo, durata, data, postiDisponibiliEconomy, postiDisponibiliBusiness, miglia);
    }

    @Override
    public float calcolaPrezzoBiglietto(String classe) throws ClasseIndisponibileException {
        float costo = 0;

        if(classe.equals("Economy"))
        {
            if(getPostiDisponibiliEconomy() == 0 || getPostiDisponibiliEconomy() < 0)
                throw new ClasseIndisponibileException();
            costo = 100 * getDurata();
            occupaPostoEconomy();
        }
        else if(classe.equals("Business"))
        {
            if(getPostiDisponibiliBusiness() == 0 || getPostiDisponibiliBusiness() < 0)
                throw new ClasseIndisponibileException();
            costo = 150 * getDurata();
            occupaPostoBusiness();
        }

        if(ChronoUnit.DAYS.between(LocalDate.now(), getData()) >= 90)
            costo = (float) (costo - (costo *0.2));

        return costo;
    }
}
