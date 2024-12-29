package preappello2023.autovettura;

public class Benzina extends Autovettura {
    public Benzina(String nome, int numCavalli) {
        super(nome, numCavalli);
    }

    @Override
    public float getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException {
        if (!isAccensione())
            throw new AutoSpentaException();

        float tempo = km * ((float) (numeroCurve * 30 + numeroRettilinei * 30) / getNumCavalli());
        setTempoGiro(tempo);

        return tempo;
    }
}
