package tracciaTutoratoFinale.pacco;

public class PaccoFragile extends Pacco{
    private boolean imballaggioSpeciale;

    public PaccoFragile(String id, double peso, String destinazione, String priorita, boolean imballaggioSpeciale) {
        super(id, peso, destinazione, priorita);
        this.imballaggioSpeciale = imballaggioSpeciale;
    }

    @Override
    public double calcolaCosto() {
        double tariffaBase = getTariffaBase();

        if(imballaggioSpeciale)
            return tariffaBase + tariffaBase * 0.15;
        else
            return tariffaBase;
    }

    public String toString()
    {
        return super.toString() + " - Imb. speciale: " + imballaggioSpeciale;
    }

    public Object clone() throws CloneNotSupportedException {
        PaccoFragile paccoFragile = (PaccoFragile) super.clone();
        paccoFragile.imballaggioSpeciale = imballaggioSpeciale;
        return paccoFragile;
    }
}
