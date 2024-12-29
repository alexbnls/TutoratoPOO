package preappello2024.volo;

import java.time.LocalDate;

public class VoloNazionale extends Volo{
    public VoloNazionale(String codiceVolo, int durata, LocalDate data, int postiDisponibiliEconomy, int postiDisponibiliBusiness, int miglia) {
        super(codiceVolo, durata, data, postiDisponibiliEconomy, postiDisponibiliBusiness, miglia);
    }

    @Override
    public float calcolaPrezzoBiglietto(String classe) throws ClasseIndisponibileException {
        float costo = 0;
        if(classe.equals("Economy"))
        {
            if(getPostiDisponibiliEconomy() == 0 || getPostiDisponibiliEconomy() < 0)
                throw new ClasseIndisponibileException();
            if(getPostiDisponibiliEconomy() > 30)
                costo = (40 * 30) + (60 *(getPostiDisponibiliEconomy() - 30));
            else
                costo = 40 * getPostiDisponibiliEconomy();

            occupaPostoEconomy();
        }
        else if(classe.equals("Business"))
        {
            if(getPostiDisponibiliBusiness() == 0 || getPostiDisponibiliBusiness() < 0)
                throw new ClasseIndisponibileException();

            costo = 100;
            occupaPostoBusiness();
        }

        return costo;
    }
}
