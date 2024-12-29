package aeromobile2023;

import java.awt.*;
import java.io.IOException;
import java.lang.invoke.StringConcatException;
import java.util.*;
import java.util.List;

public class AeromobileTest {
    public static void main(String[] args) throws IOException {
        GregorianCalendar calendar1 = new GregorianCalendar(2020, Calendar.NOVEMBER,11);
        GregorianCalendar calendar2 = new GregorianCalendar(2025, Calendar.MARCH,24);
        ListaAeromobili aeromobili = new ListaAeromobili();

        List<String> rotta = new ArrayList<>();
        rotta.add("Milano");
        rotta.add("Napoli");
        rotta.add("Catania");
        int tipo;
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 3; i++)
        {
            System.out.print("Aeroplano(0) o Elicottero(1)?: ");
            tipo = in.nextInt();
            switch (tipo)
            {
                case 0:
                    System.out.print("inserisci durata volo: ");
                    int durata = in.nextInt();
                    System.out.print("inserisci modello: ");
                    String mod = in.next();
                    System.out.print("inserisci codice: ");
                    String codice = in.next();
                    try{
                        aeromobili.addAeromobile(new Aeroplano(calendar1,calendar2,200,durata,rotta,mod,codice));
                    } catch (AeromobileException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 1:
                    System.out.print("inserisci destinazione: ");
                    String dest = in.next();
                    System.out.print("inserisci id proprietario (CF o codice generico): ");
                    String id = in.next();

                    try{
                        aeromobili.addAeromobile(new Elicottero(calendar1,calendar2, 20, dest, id));
                    } catch (AeromobileException e) {
                        System.out.println(e.getMessage() + ", riprova");
                        i--;
                    }
                    break;
                default:
                    System.out.println("uscita in corso...");
                    i = 5;
            }
        }

        System.out.print("Vuoi salvare su file? (y/n): ");
        char scelta = in.next().charAt(0);
        if(scelta == 'y')
           try{
               aeromobili.salvaFile();
           } catch (IOException e) {
               System.out.println("Errore scrittura");
           }
    }
}
