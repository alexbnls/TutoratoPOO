package tracciaTutoratoFinale.pacco;

public class PaccoExpress extends Pacco {
    private int tempoConsegna;

    public PaccoExpress(String id, double peso, String destinazione, String priorita, int tempoConsegna) {
        super(id, peso, destinazione, priorita);
        this.tempoConsegna = tempoConsegna;
    }

    @Override
    public double calcolaCosto() {
        double tariffaBase = getTariffaBase() * 2;

        if (tempoConsegna <= 24)
            tariffaBase += tempoConsegna;

        return tariffaBase;
    }

    public String toString()
    {
        return super.toString() + " - Tempo consegna: " + tempoConsegna + "h";
    }

    public Object clone() throws CloneNotSupportedException {
        PaccoExpress paccoExpress = (PaccoExpress) super.clone();
        paccoExpress.tempoConsegna = tempoConsegna;
        return paccoExpress;
    }
}
