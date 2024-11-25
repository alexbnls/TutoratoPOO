package es16;

public class PrenotazioneDuplicataException extends RuntimeException {
    public PrenotazioneDuplicataException(String message) {
        super(message);
    }
    public PrenotazioneDuplicataException()
    {
        super();
    }
}
