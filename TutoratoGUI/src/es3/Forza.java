package es3;

public class Forza extends Esercizio implements Pianificabile{
    private int peso;

    public Forza(String nome, int durata, int ripetizioni, String difficulty, int peso) {
        super(nome, durata, ripetizioni, difficulty);
        this.peso = peso;
    }

    @Override
    public String eseguiEsercizio() {
        return super.toString() + ", Peso: " + peso + " kg";
    }

    @Override
    public void pianificaAllenamento() {

    }
}
