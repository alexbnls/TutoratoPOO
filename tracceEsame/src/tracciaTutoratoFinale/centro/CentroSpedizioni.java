package tracciaTutoratoFinale.centro;

import tracciaTutoratoFinale.pacco.Pacco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CentroSpedizioni {
    private final List<Pacco> paccoList;

    public CentroSpedizioni() {
        paccoList = new ArrayList<>();
    }

    public void aggiungiPacco(Pacco p) {
        if (paccoList.contains(p))
            throw new PaccoDuplicatoException();

        paccoList.add(p);
    }

    public List<Pacco> getPaccoList() {
        return paccoList;
    }

    public List<Pacco> trovaPacchiPerPriorita(String priorita) {
        return paccoList.stream().filter(pacco -> pacco.getPriorita().equals(priorita)).toList();
    }

    public double calcolaTotaleSpedizioni() {
        return paccoList.stream().map(Pacco::calcolaCosto).reduce(0.0, Double::sum);
    }

    public void ordinaPacchi(Comparator<Pacco> criterio) {
        paccoList.sort(criterio);
    }

    public void eliminaPacco(String id) {
        paccoList.removeIf(pacco -> pacco.getId().equals(id));
    }

}
