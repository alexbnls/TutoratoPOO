package preappello2024.passeggero;

public class LimitePuntiFedeltaException extends Exception {
    public LimitePuntiFedeltaException() {
        super("Limite punti superato");
    }
}
