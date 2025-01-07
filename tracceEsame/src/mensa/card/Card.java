package mensa.card;

import java.io.Serializable;

public class Card implements Serializable {
    private int codice;
    private String nome;
    private String cognome;
    private boolean propriety;


    public Card(int codice, String nome, String cognome) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
    }

    public void activate()
    {
        if(propriety)
            throw new RuntimeException("Gia' attivato!");

        propriety = true;
    }

    public void deactivate()
    {
        if(!propriety)
            throw new RuntimeException("Gia' disattivato!");

        propriety = false;
    }


    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean isPropriety() {
        return propriety;
    }
}
