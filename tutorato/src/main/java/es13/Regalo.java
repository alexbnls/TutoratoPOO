package es13;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Regalo implements Cloneable {
    private final GregorianCalendar dataConsegna;
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

 //   @Override
//    public String toString()
//    {
//        return "Data: " + dataConsegna + " Peso: " + peso + " Regione destinazione: " + regioneDestinatario;
//    }

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
}
