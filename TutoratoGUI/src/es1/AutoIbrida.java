package es1;

import java.time.Year;
import java.util.Calendar;

public class AutoIbrida extends Veicolo{
    private String motoreTermico;
    private double consumoMedio;

    public AutoIbrida(String modello, String marca, double prezzo, int annoImmatricolazione, String motoreTermico, double consumoMedio) {
        super(modello, marca, prezzo, annoImmatricolazione);
        this.motoreTermico = motoreTermico;
        this.consumoMedio = consumoMedio;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                "[Motore: " + motoreTermico + "] " +
                "[Consumo medio: " + consumoMedio + "L/100km]";
    }

    @Override
    public double calcolaPrezzoFinale() {
        int sconto = 0;
        int sovrapprezzo = 0;

        if(Year.now().getValue() - getAnnoImmatricolazione() <= 3)
            sconto += 3;

        if(consumoMedio < 4)
            sconto += 5;
        else if (consumoMedio > 6)
            sovrapprezzo += 7;

        double prezzoFinale = getPrezzo() - (getPrezzo() * sconto / 100);
        prezzoFinale += getPrezzo() + (getPrezzo() * sovrapprezzo / 100);

        return prezzoFinale;
    }
}
