package preappello2023.autovettura;

public class Elettriche extends Autovettura {
    public Elettriche(String nome, int numCavalli) {
        super(nome, numCavalli);
    }

    @Override
    public float getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException {
        if (!isAccensione())
            throw new AutoSpentaException();

        float tempo = km * ((float) (numeroCurve * 15 + numeroRettilinei * 45) / getNumCavalli());
        setTempoGiro(tempo);

        return tempo;
    }
}
