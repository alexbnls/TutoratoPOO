package es13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class RegaloTest {
    public static void main (String[] args) throws FileNotFoundException {
        SlittaDiBabboNatale slitta = new SlittaDiBabboNatale(1000);
        RegaloAdulto r1 = new RegaloAdulto(new GregorianCalendar(), 20, "Sud","Ale");
        RegaloBambino r2 = new RegaloBambino(new GregorianCalendar(), 10, "Nord", "Antonio", 7, "ciao antonio");
        RegaloAdulto r3 = new RegaloAdulto(new GregorianCalendar(), 30, "Centro", "Dio");
        Regalo r4 = new RegaloBambino(new GregorianCalendar(), 20, "Nord", "Mattia", 5, "bimbo cattivo, carbone per te");
        slitta.aggiungiRegalo(r1);
        slitta.aggiungiRegalo(r2);
        slitta.aggiungiRegalo(r3);
        slitta.aggiungiRegalo(r4);

        System.out.println("Costo totale dei regali: " + slitta.calcolaCosto());
        System.out.println(slitta.spedisci());

        File bambini = new File("bimbi.txt");
        PrintStream bimbiWrite = new PrintStream(bambini);
        bimbiWrite.println(r2.getNomeBimbo());
        bimbiWrite.println(((RegaloBambino) r4).getNomeBimbo());
        Scanner bimbiScan = new Scanner(bambini);

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci bimbo da trovare: ");
        String bimbo = in.next();

        while(bimbiScan.hasNext())
        {
            if(bimbiScan.next().equals(bimbo))
                System.out.println("Bimbo \"" + bimbo + "\" trovato");
        }
    }
}
