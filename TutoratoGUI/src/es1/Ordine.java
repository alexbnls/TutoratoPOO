package es1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ordine {
    private int id;
    private GregorianCalendar data;
    private Cliente cliente;
    private Veicolo veicolo;


    public Ordine(int id, GregorianCalendar data, Cliente cliente, Veicolo veicolo) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.veicolo = veicolo;
    }

    private String dataFormatter(GregorianCalendar data)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        format.setCalendar(data);

        return format.format(data.getTime());
    }

    @Override
    public String toString()
    {
        return "[ID ordine: " + id + "] " +
                "[Data: " + dataFormatter(data) + "] " +
                "[Cliente: " + cliente + "] " +
                "[Veicolo: " + veicolo + "]";
    }
}
