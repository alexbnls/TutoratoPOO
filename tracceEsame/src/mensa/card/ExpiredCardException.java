package mensa.card;

public class ExpiredCardException extends Exception {
    public ExpiredCardException(String message) {
        super(message);
    }
}
