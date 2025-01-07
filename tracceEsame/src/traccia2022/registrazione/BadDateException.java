package traccia2022.registrazione;

public class BadDateException extends Exception {
    public BadDateException() {
        super("Data susseguente al 01 marzo 2022");
    }
}
