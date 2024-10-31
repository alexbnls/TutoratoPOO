package es11;

public class Scommessa {
    private final int codiceEvento;
    private final double sommaPuntata;
    private final double quotazioneScommessa;

    public Scommessa(int codiceEvento, double sommaPuntata, double quotazioneScommessa)
    {
        this.codiceEvento = codiceEvento;
        this.sommaPuntata = sommaPuntata;
        this.quotazioneScommessa = quotazioneScommessa;
    }

    public double calcolaVincita()
    {
        return 0.0;
    }

    public double getSommaPuntata() {
        return sommaPuntata;
    }

    public double getQuotazioneScommessa() {
        return quotazioneScommessa;
    }

    public int getCodiceEvento()
    {
        return codiceEvento;
    }
}
