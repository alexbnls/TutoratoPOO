package es13;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class RegaloAdulto extends Regalo implements Cloneable {
    private String mittente;

    public RegaloAdulto(GregorianCalendar dataConsegna, double peso, String regioneDestinatario, String mittente) {
        super(dataConsegna, peso, regioneDestinatario);
        this.mittente = mittente;
    }

    @Override
    public String toString()
    {
        return mittente;
    }

    @Override
    public boolean equals(Object anotherObject)
    {
        if(anotherObject == null || getClass() != anotherObject.getClass())
            return false;
        RegaloAdulto altroRegalo = (RegaloAdulto) anotherObject;

        return super.equals(altroRegalo) &&
                mittente.equals(altroRegalo.mittente);
    }

    @Override
    public RegaloAdulto clone() {
        RegaloAdulto clone = (RegaloAdulto) super.clone();
        clone.mittente = this.mittente;
        return clone;
    }
}
