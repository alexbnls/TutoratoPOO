package primoappello2024.tickets;

public class AttivitaException extends RuntimeException {
    public AttivitaException() {
        super("Attivita' gia' presente");
    }
}
