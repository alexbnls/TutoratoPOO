package preappello2024.compagnia;

import preappello2024.passeggero.LimitePuntiFedeltaException;
import preappello2024.passeggero.Passeggero;
import preappello2024.volo.ClasseIndisponibileException;
import preappello2024.volo.Volo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompagniaAerea {
    private List<Passeggero> passeggeri;
    private List<Volo> voli;
    private String nome;
    private int numPasseggeri;
    private float sommaGuadagno;


    public CompagniaAerea(String nome) {
        this.nome = nome;
        passeggeri = new ArrayList<>();
        voli = new ArrayList<>();
    }

    public void aggiungiPasseggero(Passeggero p) {
        if (passeggeri.contains(p))
            throw new InserimentoPasseggeroException();

        passeggeri.add(p);
        passeggeri.sort(Comparator.comparing(Passeggero::getCognome));
    }

    public void aggiungiVolo(Volo v) throws InserimentoVoloException {
        if (voli.contains(v))
            throw new InserimentoVoloException();

        voli.add(v);
        voli.sort(Comparator.comparing(Volo::getData));
    }

    public void prenotaVolo(String codiceVolo, Passeggero p, String classe) {
        for (Volo volo : voli) {
            if (codiceVolo.equals(volo.getCodiceVolo())) {
                try {
                    aggiungiPasseggero(p);
                    sommaGuadagno += volo.calcolaPrezzoBiglietto(classe);
                    p.guadagnaPunti(volo.getMiglia());
                    numPasseggeri++;
                } catch (ClasseIndisponibileException | LimitePuntiFedeltaException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String cercaVolo(String codiceVolo)
    {
        for(Volo volo:voli)
            if(volo.getCodiceVolo().equals(codiceVolo))
                return volo.toString();

        return "Volo non trovato";
    }
    public String getNome() {
        return nome;
    }

    public float getSommaGuadagno() {
        return sommaGuadagno;
    }
}
