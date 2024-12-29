package es3;

public abstract class Esercizio {
    private String nome;
    private int durata;
    private int ripetizioni;
    private String difficulty;


    public Esercizio(String nome, int durata, int ripetizioni, String difficulty) {
        this.nome = nome;
        this.durata = durata;
        this.ripetizioni = ripetizioni;
        this.difficulty = difficulty;
    }

    public abstract String eseguiEsercizio();

    public String toString()
    {
        return "Nome esercizio: " + nome +
                ", Durata: " + durata +
                " minuti, Ripetizioni: " + ripetizioni +
                ", Difficolta': " + difficulty;
    }

    public String getNome() {
        return nome;
    }

    public int getDurata() {
        return durata;
    }

    public int getRipetizioni() {
        return ripetizioni;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
