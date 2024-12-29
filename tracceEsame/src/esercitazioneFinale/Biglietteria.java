package esercitazioneFinale;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Biglietteria {
    private String luogo;
    private List<Biglietto> biglietti;

    public Biglietteria(String luogo)
    {
        this.luogo = luogo;
        biglietti = new ArrayList<>();
    }

    public void addBiglietto(Biglietto b)
    {
        biglietti.add(b);
    }

    public List<Biglietto> getBiglietti()
    {
        return biglietti;
    }
    public void attivaBiglietto(String id) throws Exception {
        for(Biglietto biglietto: biglietti)
            if(biglietto.getId().equals(id))
                biglietto.attivaBiglietto();
    }

    public void aggiornaTariffe(int percent) throws PercentualeInvalidaException {
        if(percent < 0 || percent > 100)
            throw new PercentualeInvalidaException("Inserisci percentuale valida");
        if(biglietti.isEmpty())
            throw new BigliettiAssentiException("No biglietti");
        biglietti.forEach(biglietto -> biglietto.aggiornaTariffa(percent));
    }

    public List<Biglietto> filtraBiglietti(Predicate<Biglietto> predicate)
    {
        return biglietti.stream().filter(predicate).toList();
    }
}
