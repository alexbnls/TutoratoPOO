package es14;

public class Azione extends Film implements Cloneable{

    public Azione(String codice, String titolo) {
        super(codice, titolo);

    }

    @Override
    public double calcolaPenaleRitardo(int giorniRitardo)
    {
        return 3 * giorniRitardo;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    public boolean equals(Object object)
    {
        return super.equals(object);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}
