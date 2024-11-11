package es13;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Regalo implements Cloneable {
    private GregorianCalendar dataConsegna;
    private final double peso;
    private final String regioneDestinatario;

    public Regalo (GregorianCalendar dataConsegna, double peso, String regioneDestinatario)
    {
        this.dataConsegna = dataConsegna;
        this.peso = peso;
        this.regioneDestinatario = regioneDestinatario;
    }

    public int calcolaCosto()
    {
        return switch (regioneDestinatario) {
            case "Nord" -> 10;
            case "Centro" -> 15;
            case "Sud" -> 20;
            default -> 0;
        };
    }

    private final String getFormattedCalendar() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataConsegna.getTime());
    }

    @Override
    public String toString()
    {
        return "[Data: " + getFormattedCalendar() + "] [Peso: " + peso + "] [Regione destinazione: " + regioneDestinatario + "]";
    }

    @Override
    public boolean equals(Object anotherObject)
    {
        if(anotherObject == null || getClass() != anotherObject.getClass())
            return false;

        Regalo altroRegalo = (Regalo) anotherObject;

        return dataConsegna.equals(altroRegalo.dataConsegna) &&
                peso == altroRegalo.peso &&
                regioneDestinatario.equals(altroRegalo.regioneDestinatario);
    }

    @Override
    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getRegioneDestinatario() {
        return regioneDestinatario;
    }

    public void setDataConsegna(GregorianCalendar data) {
        dataConsegna = data;
    }

    public GregorianCalendar getDataConsegna() {
        return dataConsegna;
    }

    public double getPeso() {
        return peso;
    }
}
