package es11;

import java.util.ArrayList;

public class ScommessaTest {
    public static void main (String[] args)
    {
        ScommessaCalcistica scommessaCalcistica = new ScommessaCalcistica(1,10,1.9,"Serie A",'1',"Milan","Napoli");

        ArrayList<String> cavalli = new ArrayList<>();
        cavalli.add("Pedro");
        cavalli.add("Spirit");
        cavalli.add("Elio");
        ScommessaIppica scommessaIppica = new ScommessaIppica(2,30,4.2,"galoppo","vincente", cavalli);

        System.out.println("Vittoria calcio: " + scommessaCalcistica.calcolaVincita());
        System.out.println("Vittoria ippica: " + scommessaIppica.calcolaVincita());
    }
}
