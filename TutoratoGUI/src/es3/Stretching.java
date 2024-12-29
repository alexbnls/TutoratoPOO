package es3;

public class Stretching extends Esercizio implements Pianificabile{
    private int tempoRecupero;

    public Stretching(String nome, int durata, int ripetizioni, String difficulty, int tempoRecupero) {
        super(nome, durata, ripetizioni, difficulty);
        this.tempoRecupero = tempoRecupero;
    }

    @Override
    public String eseguiEsercizio() {
        return super.toString() + ", Tempo di recupero: " + tempoRecupero + " minuti";
    }

    @Override
    public void pianificaAllenamento() {

    }
}
