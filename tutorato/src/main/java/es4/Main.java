package es4;

import java.util.List;

public class Main {
    public static void main (String args[])
    {
        Prodotto prod1 = new Prodotto(12, "cocacola", 1.5);
        Prodotto prod2 = new Prodotto(14,"fanta",1.5);
        Prodotto prod3 = new Prodotto(3, "acqua",0.5);

        RegistratoreCassa regist = new RegistratoreCassa(100);

        regist.registraProdotto(prod1);
        regist.registraProdotto(prod2);
        regist.registraProdotto(prod3);

        List<Prodotto> prodotti = regist.consultaProdotti();

        for(Prodotto prodotto : prodotti)
        {
            System.out.println("Codice: " + prodotto.getCodice() + ", Prezzo: " + prodotto.getPrezzo() );
        }

        System.out.println(regist.compraProdotto(12,10));

    }
}
