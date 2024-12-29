package esercizi.stream;

public class Autore {
    private String nome;
    private String cognome;
    private int eta;
    private String sesso;

    public Autore(String nome, String cognome, int eta, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.sesso = sesso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getSesso() {
        return sesso;
    }
}
