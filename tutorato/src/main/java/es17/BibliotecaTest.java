package es17;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BibliotecaTest {
    public static void main (String[] args)
    {
        Biblioteca biblioteca = new Biblioteca();

        Scanner in = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("1. Inserisci libro\n2. Visualizza libri\n3. Salva su file i libri\n4. Recupera libri da file\n5. Cerca libro\n0. ESCI");
            System.out.print("Scegli: ");
            scelta = in.nextInt();
            in.nextLine();

            switch (scelta)
            {
                case 1:
                    System.out.print("Ins. titolo: ");
                    String titolo = in.nextLine();
                    System.out.print("Ins. autore: ");
                    String autore = in.nextLine();
                    System.out.print("Ins. ISBN: ");
                    int isbn = in.nextInt();
                    System.out.print("Ins. anno: ");
                    int anno = in.nextInt();

                    biblioteca.addLibro(new Libro(titolo, autore, isbn, anno));
                    break;
                case 2:
                    biblioteca.printBooks();
                    break;
                case 3:
                    System.out.print("Ins. nome file su cui scrivere: ");
                    String filename = in.next();
                    try
                    {
                        biblioteca.writeOnFile(new File(filename));
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                case 4:
                    System.out.print("Ins. nome file da cui recuperare dati: ");
                    String fileN = in.next();
                    try
                    {
                        biblioteca.readFile(new File(fileN));
                        break;
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                case 5:
                    System.out.print("Cerca tramite titolo ('T') o ISBN ('I'): ");
                    String c = in.next();
                    if(c.equals("T"))
                    {
                        System.out.print("Ins. titolo");
                        String t = in.nextLine();
                        if(biblioteca.findLibro(t))
                            System.out.println("Trovato");
                        else
                            System.out.println("Non trovato");
                    }
                    else if(c.equals("I"))
                    {
                        System.out.print("Ins. ISBN");
                        int i = in.nextInt();
                        if(biblioteca.findLibro(i))
                            System.out.println("Trovato");
                        else
                            System.out.println("Non trovato");
                    }
                case 0:
                    break;
            }

        } while (scelta != 0);


    }
}
