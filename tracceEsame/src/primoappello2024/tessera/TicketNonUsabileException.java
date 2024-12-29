package primoappello2024.tessera;

public class TicketNonUsabileException extends Exception {
    public TicketNonUsabileException() {
        super("Ticket gia' usato");
    }
}
