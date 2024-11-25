package es16;

import java.net.IDN;
import java.util.ArrayList;
import java.util.Scanner;

public class CentroSportivoTest {
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int scelta;

        Attivita attivita1 = new Attivita("Calcio", 1);
        Attivita attivita2 = new Attivita("Tennis", 49);
        Attivita attivita3 = new Attivita("Basket", 119);
        ArrayList<Attivita> attivita = new ArrayList<>();
        attivita.add(attivita1);
        attivita.add(attivita2);
        attivita.add(attivita3);

        CentroSportivo centroSportivo = new CentroSportivo(attivita);

        do
        {
            System.out.println("1. Registra utente\n2. Visualizza attivita\n3. Prenota\n0. Esci");
            System.out.print("Immetti scelta: ");
            scelta = in.nextInt();

            switch (scelta)
            {
                case 1:
                    System.out.print("ID: ");
                    String id = in.next();
                    System.out.print("Nome: ");
                    String nome = in.next();
                    System.out.print("Email: ");
                    String mail = in.next();

                    centroSportivo.registerUser(new Utente(id, nome, mail));
                    break;
                case 2:
                    centroSportivo.showActivities();
                    break;
                case 3:
                    System.out.print("Attivita da prenotare: ");
                    nome = in.next();
                    System.out.print("ID utente: ");
                    id = in.next();
                    System.out.print("Nome prenotazione: ");
                    String idPr = in.next();

                    try {
                        centroSportivo.newPrenotazione(idPr , nome, id);
                    }
                    catch (PrenotazioneNonDisponibileException | UtenteNonRegistratoException e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 0:
                    break;
            }
        } while(scelta != 0);

    }
}
