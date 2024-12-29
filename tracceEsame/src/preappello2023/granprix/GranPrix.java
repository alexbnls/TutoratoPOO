package preappello2023.granprix;

import preappello2023.autovettura.AutoSpentaException;
import preappello2023.autovettura.Autovettura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GranPrix {
    private List<Autovettura> autovetture;
    private int numGiri;
    private int kmGiro;
    private int numCurve;
    private int numRettilinei;

    public GranPrix(int numGiri, int kmGiro, int numCurve, int numRettilinei) {
        this.numGiri = numGiri;
        this.kmGiro = kmGiro;
        this.numCurve = numCurve;
        this.numRettilinei = numRettilinei;
        this.autovetture = new ArrayList<>();
    }

    public void aggiungiVettura(Autovettura a) {
        if (autovetture.contains(a))
            throw new InsertionException();

        autovetture.add(a);
        autovetture.sort(Comparator.comparingInt(Autovettura::getNumCavalli));
    }

    public void avviaMotori() {
        autovetture.forEach(Autovettura::start);
    }

    public void pitStop(int i) {
        if (autovetture.size() < i)
            return;
        Autovettura autovettura = autovetture.get(i);
        try {
            float tempoNew = (float) (autovettura.getTempoGiro(kmGiro, numCurve, numRettilinei) + 2.0);
            autovettura.setTempoGiro(tempoNew);
        } catch (AutoSpentaException e) {
            autovettura.start();
        }
    }

    public void effettuaGiro() {
        for (Autovettura autovettura : autovetture) {
            try {
                autovettura.getTempoGiro(kmGiro, numCurve, numRettilinei);
            } catch (AutoSpentaException e) {
                autovettura.start();
            }
        }
    }

    public int getNumGiri() {
        return numGiri;
    }

    public List<Autovettura> getAutovetture() {
        return autovetture;
    }
}
