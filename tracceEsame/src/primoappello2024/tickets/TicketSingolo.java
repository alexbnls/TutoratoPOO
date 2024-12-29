package primoappello2024.tickets;

import java.time.LocalDate;

public class TicketSingolo extends TicketSportivo{
    private LocalDate data;

    public TicketSingolo(String tipo, String luogo, double costo) {
        super(tipo, luogo, costo);
    }

    public void usaTicket()
    {
        super.usaTicket();
        data = LocalDate.now();
    }
}
