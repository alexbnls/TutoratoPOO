package es16;

public class UtenteNonRegistratoException extends Exception {
    public UtenteNonRegistratoException(String message) {
        super(message);
    }
    public UtenteNonRegistratoException()
    {
        super();
    }
}
