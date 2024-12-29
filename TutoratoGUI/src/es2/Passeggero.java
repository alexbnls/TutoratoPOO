package es2;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Passeggero extends Persona{
    private int numPassaporto;
    private List<Biglietto> biglietti;


    public Passeggero(String nome, String cognome, GregorianCalendar dataNascita, String id, int numPassaporto) {
        super(nome, cognome, dataNascita, id);
        this.numPassaporto = numPassaporto;
        biglietti = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString() +
                "numPassaporto=" + numPassaporto;
    }
}
