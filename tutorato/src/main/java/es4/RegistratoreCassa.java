package es4;

import java.util.ArrayList;
import java.util.List;

public class RegistratoreCassa {
    private double denaro;
    private List<Prodotto> prodotti;

    public RegistratoreCassa(int denaro)
    {
        this.denaro = denaro;
        prodotti = new ArrayList<>();
    }


    public void registraProdotto(Prodotto prod)
    {
        prodotti.add(prod);
    }

    public List consultaProdotti()
    {
       /* for(Prodotto prod : prodotti)
        {
            System.out.println("Codice: " + prod.getCodice() + ", Prezzo: " + prod.getPrezzo());
        } */
        return prodotti;
    }

    public double compraProdotto(int codice, int denaro)
    {
        double resto = 0;

        for(Prodotto prod : prodotti)
        {
            if(prod.getCodice() == codice)
                resto = denaro - prod.getPrezzo();
        }

        return resto;
    }
}
