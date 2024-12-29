package es2;

public class Biglietto {
    private String id;
    private Passeggero passeggero;
    private Volo volo;
    private int prezzo;


    public Biglietto(String id, Passeggero passeggero, Volo volo, int prezzo) {
        this.id = id;
        this.passeggero = passeggero;
        this.volo = volo;
        this.prezzo = prezzo;
    }
}
