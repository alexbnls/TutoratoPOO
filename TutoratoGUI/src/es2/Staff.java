package es2;

import java.util.GregorianCalendar;
import java.util.List;

public class Staff extends Persona{
    private String ruolo;
    private List<?> turni;

    public Staff(String nome, String cognome, GregorianCalendar dataNascita, String id, String ruolo) {
        super(nome, cognome, dataNascita, id);
        this.ruolo = ruolo;
    }
}
