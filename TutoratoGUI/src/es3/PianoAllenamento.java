package es3;

import java.util.ArrayList;
import java.util.List;

public class PianoAllenamento {
    private List<Allenamento> allenamenti;

    public PianoAllenamento()
    {
        allenamenti = new ArrayList<>();
    }

    public void addAllenamento(Allenamento allenamento)
    {
        allenamenti.add(allenamento);
    }

    public int getDurata()
    {
        int tot = 0;

        for(Allenamento allenamento: allenamenti)
            tot += allenamento.calcolaDurataAllenamento();

        return tot;
    }


}
