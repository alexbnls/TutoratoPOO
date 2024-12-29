package skischool;

import java.util.GregorianCalendar;

public class SnowboardCourse implements Course{
    private String id;
    private int numPartecipanti;
    private GregorianCalendar dataInizio;
    private int durataCorso;
    private final static int minPartecipanti = 6;
    private final static int maxPartecipanti = 10;

    public SnowboardCourse(String id, int numPartecipanti, GregorianCalendar dataInizio, int durataCorso) {
        if(durataCorso < 0)
            throw new IllegalArgumentException("durata negativa");
        if(numPartecipanti > maxPartecipanti)
            throw new IllegalArgumentException("troppi partecipanti");

        this.id = id;
        this.numPartecipanti = numPartecipanti;
        this.dataInizio = dataInizio;
        this.durataCorso = durataCorso;
    }
    @Override
    public String getCourseName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getMinimumNumberOfParticipants() {
        return minPartecipanti;
    }

    @Override
    public int getMaximumNumberOfParticipants() {
        return maxPartecipanti;
    }

    @Override
    public int getNumberOfParticipants() {
        return numPartecipanti;
    }

    @Override
    public boolean addParticipant() {
        int tempPartecipante = numPartecipanti;
        if(++tempPartecipante > maxPartecipanti)
            return false;
        else
        {
            numPartecipanti++;
            return true;
        }
    }

    @Override
    public boolean isCourseActivated() {
        return numPartecipanti >= minPartecipanti;
    }

    public GregorianCalendar getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(GregorianCalendar dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String toString()
    {
        return "[" + id + " - " +
                numPartecipanti + " partecipanti - " +
                "inizio " + dataInizio.getTime() + " " +
                "- durata " + durataCorso + " gg";
    }


}
