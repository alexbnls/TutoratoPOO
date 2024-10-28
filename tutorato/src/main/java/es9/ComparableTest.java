package es9;

import java.util.ArrayList;
import java.util.Scanner;

public class ComparableTest {
    public static void main(String[] args)
    {
        int n = 5;
        ArrayList<Persona> persone = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < n; i++)
        {
            System.out.print("Inserisci persona "+ (i+1) + ": ");
            String nome = in.next();
            persone.add(new Persona(nome));
        }

        Persona min = persone.getFirst();
        Persona max = persone.getFirst();

        for(Persona p: persone)
        {
            if(p.compareTo(min) < 0)
                min = p;
            if(p.compareTo(max) > 0)
                max = p;
        }

        System.out.println("Prima persona in ordine: " + min.getNome());
        System.out.println("Ultima persona in ordine: " + max.getNome());

    }
}
