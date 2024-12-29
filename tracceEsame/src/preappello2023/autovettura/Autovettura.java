package preappello2023.autovettura;

public abstract class Autovettura {
    private String nome;
    private int numCavalli;
    private float tempoImpiegato;
    private boolean accensione;

    public Autovettura(String nome, int numCavalli) {
        this.nome = nome;
        this.numCavalli = numCavalli;
        accensione = false;
    }

    public void start()
    {
        accensione = true;
    }

    public void stop()
    {
        tempoImpiegato = 0;
        accensione = false;
    }

    public abstract float getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException;

    public void setTempoGiro(float tempoGiro) {
        this.tempoImpiegato = tempoGiro;
    }

    public String getNome() {
        return nome;
    }

    public int getNumCavalli() {
        return numCavalli;
    }

    public float getTempoImpiegato() {
        return tempoImpiegato;
    }

    public boolean isAccensione() {
        return accensione;
    }

    public boolean equals(Object a)
    {
        if(a == null || a.getClass() != getClass())
            return false;

        Autovettura autovettura = (Autovettura) a;

        return autovettura.nome.equals(nome);
    }

    public String toString()
    {
        return nome;
    }
}
