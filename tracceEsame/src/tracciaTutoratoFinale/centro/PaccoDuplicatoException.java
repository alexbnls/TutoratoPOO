package tracciaTutoratoFinale.centro;

public class PaccoDuplicatoException extends RuntimeException {
    public PaccoDuplicatoException() {
        super("Pacco gia' presente");
    }

    public PaccoDuplicatoException(String message) {
        super(message);
    }
}
