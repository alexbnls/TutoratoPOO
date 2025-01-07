package tracciaTutoratoFinale.pacco;

public class PaccoStandard extends Pacco{

    public PaccoStandard(String id, double peso, String destinazione, String priorita) {
        super(id, peso, destinazione, priorita);
    }

    @Override
    public double calcolaCosto() {
        return getTariffaBase();
    }

}
