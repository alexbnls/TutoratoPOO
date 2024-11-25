package es16;

public class Attivita {
    private String nome;
    private int postiLiberi;

    public Attivita(String nome, int postiLiberi)
    {
        this.nome = nome;
        this.postiLiberi = postiLiberi;
    }

    public void prenotaPosto()
    {
        postiLiberi--;
    }

    public String getNome() {
        return nome;
    }

    public int getPostiLiberi() {
        return postiLiberi;
    }

    public String toString()
    {
        return "[Attivita: " + nome + " Posti: " + postiLiberi + "]";
    }
}
