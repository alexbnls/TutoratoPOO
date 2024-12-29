package es3;

public class Cliente {
    private String nome;
    private int eta;
    private String obiettivo;
    private PianoAllenamento pianoAllenamento;


    public Cliente(String nome, int eta, String obiettivo, PianoAllenamento pianoAllenamento) {
        this.nome = nome;
        this.eta = eta;
        this.obiettivo = obiettivo;
        this.pianoAllenamento = pianoAllenamento;
    }
}
