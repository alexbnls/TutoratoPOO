package preappello2024.passeggero;

public abstract class Passeggero {
    private String cognome;
    private String nome;
    private int puntiFedelta;
    private int annoIscrizionePianoFedelta;


    public Passeggero(String cognome, String nome, int puntiFedelta, int annoIscrizionePianoFedelta) {
        this.cognome = cognome;
        this.nome = nome;
        this.puntiFedelta = puntiFedelta;
        this.annoIscrizionePianoFedelta = annoIscrizionePianoFedelta;
    }

    public abstract void guadagnaPunti(int miglia) throws LimitePuntiFedeltaException;

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public int getPuntiFedelta() {
        return puntiFedelta;
    }

    public int getAnnoIscrizionePianoFedelta() {
        return annoIscrizionePianoFedelta;
    }

    public void addPuntiFedelta(int puntiFedelta) {
        this.puntiFedelta += puntiFedelta;
    }

    public boolean equals(Object p)
    {
        if(p == null || p.getClass() != this.getClass())
            return false;

        Passeggero passeggero = (Passeggero) p;

        return passeggero.nome.equals(nome) &&
                passeggero.cognome.equals(cognome);
    }
}
