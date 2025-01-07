package tracciaTutoratoFinale.pacco;

public class PaccoAssicurato extends Pacco {
    private double valoreAssicurato;

    public PaccoAssicurato(String id, double peso, String destinazione, String priorita, double valoreAssicurato) {
        super(id, peso, destinazione, priorita);
        this.valoreAssicurato = valoreAssicurato;
    }

    @Override
    public double calcolaCosto() {
        return getTariffaBase() + (valoreAssicurato * 0.02);
    }

    public String toString() {
        return super.toString() + " - Valore assicurato: " + valoreAssicurato;
    }

    public Object clone() throws CloneNotSupportedException {
        PaccoAssicurato paccoAssicurato = (PaccoAssicurato) super.clone();
        paccoAssicurato.valoreAssicurato = valoreAssicurato;
        return paccoAssicurato;
    }
}
