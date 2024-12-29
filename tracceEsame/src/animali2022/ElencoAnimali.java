package animali2022;

import java.util.ArrayList;
import java.util.List;

public class ElencoAnimali {
    private final List<Animale> animals;

    public ElencoAnimali() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animale animale) {
        animals.add(animale);
    }

    public int getNumeroZampe() {
        int tot = 0;

        for (Animale animale : animals)
            tot += animale.getZampe();

        return tot;
    }

    public int getCounter(String tipoAnimale) {
        int cont = 0;

        if (tipoAnimale.equals("Cane") || tipoAnimale.equals("Pesce") || tipoAnimale.equals("Uccello")) {
            for (Animale animale : animals)
                if (animale.getClass().getSimpleName().equals(tipoAnimale))
                    cont++;
        } else
            throw new BadAnimalException("Animale non esistente");

        return cont;
    }

    public int alimenta() {
        int tot = 0;

        for (Animale animale : animals) {
            int cont = 0;

            while (cont < 3) {
                if (animale.vuoiMangiare()) {
                    cont++;
                    animale.mangia();
                }

                tot++;
            }
        }

        return tot;
    }
}
