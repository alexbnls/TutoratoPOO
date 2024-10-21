package es5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Fraudolent {
    private File azioni;
    private PrintStream wf;

    public Fraudolent(File file) throws FileNotFoundException {
        azioni = file;
        wf = new PrintStream(azioni);
    }

    public void annotaAzione(Action action) throws FileNotFoundException {

        wf.println(action.getAzione());
    }
}
