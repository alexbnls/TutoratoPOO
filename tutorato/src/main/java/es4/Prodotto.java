package es4;


import java.util.ArrayList;
import java.util.List;

public class Prodotto {
    private int codice;
    private String nome;
    private double prezzo;

    public Prodotto(int codice, String nome, double prezzo)
    {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome()
    {
        return nome;
    }

    public double getPrezzo()
    {
        return prezzo;
    }

    public int getCodice()
    {
        return  codice;
    }

}
