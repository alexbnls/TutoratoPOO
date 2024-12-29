package primoappello2024.tessera;

public class ListaPienaException extends Exception {
    public ListaPienaException() {
        super("Max biglietti raggiunti");
    }
}
