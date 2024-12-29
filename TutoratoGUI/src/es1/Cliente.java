package es1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cognome;
    private String indirizzo;
    private List<Ordine> ordini;

    public Cliente(String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        ordini = new ArrayList<>();
    }

    public void addOrder(Ordine order)
    {
        ordini.add(order);
    }

    @Override
    public String toString()
    {
        return "[Nome: " + nome + "] " +
                "[Cognome " + cognome + "] " +
                "[Indirizzo: " + indirizzo + "]";
    }
}
