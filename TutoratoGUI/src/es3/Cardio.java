package es3;

public class Cardio extends Esercizio implements Pianificabile {
    private int speed;

    public Cardio(String nome, int durata, int ripetizioni, String difficulty, int speed) {
        super(nome, durata, ripetizioni, difficulty);
        this.speed = speed;
    }

    @Override
    public String eseguiEsercizio() {
        return super.toString() + ", Velocita': " + speed + " km/h";
    }

    @Override
    public void pianificaAllenamento() {

    }
}
