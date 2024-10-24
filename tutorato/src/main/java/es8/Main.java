package es8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        List<Dado> dadi = new ArrayList<>();
        List<Moneta> monete = new ArrayList<>();

        Random random = new Random();
        int numDadi = random.nextInt(10);
        int numMonete = random.nextInt(10);

        for(int i = 0; i < numDadi; i++)
            dadi.add(new Dado());
        for(int i = 0; i < numMonete; i++)
            monete.add(new Moneta());

        for(Dado dado : dadi)
            System.out.println("Lancio dado: " + dado.lancio());

        for(Moneta moneta : monete)
            System.out.println("Lancio moneta: " + moneta.lancio());

        System.out.println("Totale lanci dado: " + Dado.getnLanci() + ", lanci moneta: " + Moneta.getnLanci());
    }


}
