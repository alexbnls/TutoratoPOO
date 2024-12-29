package primoappello2024.tickets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketTorneo extends TicketSportivo{
    private List<LocalDate> dates;
    private int index;

    public TicketTorneo(String tipo, String luogo, double costo) {
        super(tipo, luogo, costo);
        dates = new ArrayList<>();
    }

    public void usaTicket()
    {
        if(dates.size() >= 7)
            super.usaTicket();

        dates.add(LocalDate.now());
    }
}
