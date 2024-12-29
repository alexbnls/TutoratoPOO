package aeromobile2023;

import java.io.Serializable;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Aeromobile implements Serializable {
    private GregorianCalendar dataRevisione;
    private GregorianCalendar dataVolo;
    private int numPasseggeri;

    public Aeromobile()
    {
        dataRevisione = new GregorianCalendar();
        dataVolo = null;
        numPasseggeri = 0;
    }

    public Aeromobile(GregorianCalendar dataRevisione, GregorianCalendar dataVolo, int numPasseggeri) {
        GregorianCalendar dataOdierna = new GregorianCalendar();
        if(dataRevisione.after(dataOdierna))
            throw new IllegalArgumentException("Revisione impossibile");
        if(dataVolo.before(dataOdierna))
            throw new IllegalArgumentException("inserire una data volo successiva a oggi");

        this.dataRevisione = dataRevisione;
        this.dataVolo = dataVolo;
        this.numPasseggeri = numPasseggeri;
    }

    public GregorianCalendar getDataRevisione() {
        return dataRevisione;
    }

    public void setDataRevisione(GregorianCalendar dataRevisione) {
        this.dataRevisione = dataRevisione;
    }

    public GregorianCalendar getDataVolo() {
        return dataVolo;
    }

    public void setDataVolo(GregorianCalendar dataVolo) {
        this.dataVolo = dataVolo;
    }

    public int getNumPasseggeri() {
        return numPasseggeri;
    }

    public void setNumPasseggeri(int numPasseggeri) {
        this.numPasseggeri = numPasseggeri;
    }

    public boolean isExpiredRevision()
    {
        int annoRevisione = dataRevisione.getWeekYear();
        int annoCorrente = Year.now().getValue();

        return annoCorrente - annoRevisione >= 3;
    }

    public boolean equals(Object obj)
    {
        if(obj == null || obj.getClass() != getClass())
            return false;

        Aeromobile aeromobile = (Aeromobile) obj;

        return aeromobile.getDataVolo().equals(dataVolo) &&
                aeromobile.getDataRevisione().equals(dataRevisione) &&
                aeromobile.getNumPasseggeri() == numPasseggeri;
    }

    public String toString()
    {
        return getClass().getSimpleName() +" = [Data revisione: " + dataRevisione.getTime() + "] " +
                "[Data volo: " + dataVolo.getTime() + "] " +
                "[Num. passeggeri: " + numPasseggeri + "] ";
    }
}
