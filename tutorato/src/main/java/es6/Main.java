package es6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {

        File a = new File("C:\\Users\\alexa\\IdeaProjects\\tutorato\\src\\main\\java\\es6\\azioni.txt");
        Scanner rf = new Scanner(a);
        List<Action> azioni = new ArrayList<>();


        while(rf.hasNextLine())
        {
            String nome = rf.next();
            double importo = rf.nextDouble();
            int quant = rf.nextInt();
            char tipo = rf.next().charAt(0);
            azioni.add(new Action(nome,importo,quant,tipo));
        }

        System.out.println(azioni.size());
    }
}
