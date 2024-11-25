package es16;

public class AttivitaNonTrovataException extends RuntimeException {
    public AttivitaNonTrovataException(String message) {
        super(message);
    }
    public AttivitaNonTrovataException()
    {
      super();
    }
}
