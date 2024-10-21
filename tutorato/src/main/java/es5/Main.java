package es5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File azioni = new File("azioni.txt");
        Fraudolent banca = new Fraudolent(azioni);

        banca.annotaAzione(new Action("Tesla", 10.0, 30, 'B'));
        banca.annotaAzione(new Action("Microsoft", 25.0, 10, 'S'));

        Scanner rf = new Scanner(azioni);

        double totSell = 0;
        double totBuy = 0;
        int cont = 0;

        while(rf.hasNextLine())
        {
            String nome = rf.next();
            double importo = rf.nextDouble();
            int quantita = rf.nextInt();
            char tipo = rf.next().charAt(0);
            if(tipo == 'B')
                totBuy += importo;
            else
                totSell += importo;
            cont++;
        }

        System.out.println(totBuy);

    }
}
