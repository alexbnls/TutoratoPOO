package es13;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class RegaloBambino extends Regalo implements Cloneable{
    private String nomeBimbo;
    private int ageBimbo;
    private String messaggio;

    public RegaloBambino(GregorianCalendar dataConsegna, double peso, String regioneDestinatario, String nomeBimbo, int ageBimbo, String messaggio) {
        super(dataConsegna, peso, regioneDestinatario);
        this.nomeBimbo = nomeBimbo;
        this.ageBimbo = ageBimbo;
        this.messaggio = messaggio;
    }

    @Override
    public String toString()
    {
        return super.toString() + " [Messaggio: HoHoHo " + messaggio + "]";
    }

    public boolean equals(Object anotherObject)
    {
        if(anotherObject == null || getClass() != anotherObject.getClass())
            return false;
        RegaloBambino altroRegaloBambino = (RegaloBambino) anotherObject;

        return super.equals(altroRegaloBambino) &&
                nomeBimbo.equals(altroRegaloBambino.nomeBimbo) &&
                ageBimbo == altroRegaloBambino.ageBimbo &&
                messaggio.equals(altroRegaloBambino.messaggio);
    }

    @Override
    public RegaloBambino clone() {
        RegaloBambino clone = (RegaloBambino) super.clone();
        clone.messaggio = this.messaggio;
        clone.nomeBimbo = this.nomeBimbo;
        clone.ageBimbo = this.ageBimbo;
        return clone;
    }

    public String getNomeBimbo() {
        return nomeBimbo;
    }

    public int getAgeBimbo() {
        return ageBimbo;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
