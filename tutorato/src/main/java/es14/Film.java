package es14;

public class Film implements Cloneable {
    private String codice;
    private String titolo;

    public Film (String codice, String titolo)
    {
        this.codice = codice;
        this.titolo = titolo;
    }

    public String dammiCodice()
    {
        return codice;
    }

    public String dammiTitolo()
    {
        return titolo;
    }

    public double calcolaPenaleRitardo(int giorniRitardo)
    {
        return 2 * giorniRitardo;
    }

    @Override
    public String toString()
    {
        return "[Codice: " + codice + "] [Titolo: " + titolo + "]";
    }

    @Override
    public boolean equals(Object object)
    {
        if(object == null || object.getClass() != this.getClass())
            return false;
        Film film = (Film) object;

        return codice == film.dammiCodice() &&
                titolo.equals(film.dammiTitolo());
    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
}
