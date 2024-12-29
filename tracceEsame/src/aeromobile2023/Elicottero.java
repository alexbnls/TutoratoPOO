package aeromobile2023;

import java.util.GregorianCalendar;

public class Elicottero extends Aeromobile{
    public String destinazione;
    public String idProprietario;


    public Elicottero(String destinazione, String idProprietario) {
        this.destinazione = destinazione;
        this.idProprietario = idProprietario;
    }

    public Elicottero(GregorianCalendar dataRevisione, GregorianCalendar dataVolo, int numPasseggeri, String destinazione, String idProprietario) {
        super(dataRevisione, dataVolo, numPasseggeri);
        this.destinazione = destinazione;
        this.idProprietario = idProprietario;
    }

    public boolean equals (Object obj)
    {
        if(!super.equals(obj))
            return false;
        Elicottero elicottero = (Elicottero) obj;

        return elicottero.getDestinazione().equals(destinazione) &&
                elicottero.getIdProprietario().equals(idProprietario);
    }

    public String toString()
    {
        return super.toString() + "[Destinazione: " + destinazione + "] " +
                "[ID proprietario: " + idProprietario + "]";
    }

    public String getDestinazione() {
        return destinazione;
    }

    public String getIdProprietario() {
        return idProprietario;
    }
}
