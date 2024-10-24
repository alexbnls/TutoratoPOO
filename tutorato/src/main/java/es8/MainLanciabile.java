package es8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainLanciabile {
    public static void main(String[] args)
    {
        List<Lanciabile> lanciabili = new ArrayList<>();

        Random random = new Random();
        int numLanciabili = random.nextInt(10);

        for(int i = 0; i < numLanciabili; i++) {
            lanciabili.add(new Dado());
            lanciabili.add(new Moneta());
        }

        for(Lanciabile lanciabile : lanciabili)
            System.out.println("Lancio: " + lanciabile.lancio());

        System.out.println("Totale lanci dado: " + Dado.getnLanci() + ", lanci moneta: " + Moneta.getnLanci());
    }


}
