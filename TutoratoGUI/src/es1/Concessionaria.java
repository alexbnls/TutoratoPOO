package es1;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class Concessionaria {
    private List<Veicolo> veicoli;
    private List<Cliente> clienti;
    private List<Ordine> ordini;
    private static int id = 1;

    public Concessionaria()
    {
        veicoli = new ArrayList<>();
        clienti = new ArrayList<>();
        ordini = new ArrayList<>();
    }

    public void addVeicolo(Veicolo veicolo)
    {
        veicoli.add(veicolo);
    }

    public void registerCustomer(Cliente cliente)
    {
        clienti.add(cliente);
    }

    public void creaOrdine(Cliente cliente, Veicolo veicolo)
    {
        if(!clienti.contains(cliente))
            throw new IllegalArgumentException("cliente non esistente");
        if(!veicoli.contains(veicolo))
            throw new IllegalArgumentException("veicolo non esistente");

        Ordine ordine = new Ordine(id++, new GregorianCalendar(), cliente, veicolo);
        ordini.add(ordine);
    }

}
