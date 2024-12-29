package es2;

import java.util.GregorianCalendar;

public class Persona {
    private String nome;
    private String cognome;
    private GregorianCalendar dataNascita;
    private String id;


    public Persona(String nome, String cognome, GregorianCalendar dataNascita, String id) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.id = id;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", id='" + id + '\'';
    }
}
