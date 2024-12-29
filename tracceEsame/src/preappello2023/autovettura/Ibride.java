package preappello2023.autovettura;

public class Ibride extends Autovettura {
    public Ibride(String nome, int numCavalli) {
        super(nome, numCavalli);
    }

    @Override
    public float getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException {
        if (!isAccensione())
            throw new AutoSpentaException();

        float tempo = km * ((float) (numeroCurve * 20 + numeroRettilinei * 40) / getNumCavalli());
        setTempoGiro(tempo);

        return tempo;
    }
}
