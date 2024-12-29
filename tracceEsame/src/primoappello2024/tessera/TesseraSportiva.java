package primoappello2024.tessera;

import primoappello2024.tickets.AttivitaException;
import primoappello2024.tickets.TicketSportivo;

import java.util.ArrayList;
import java.util.List;

public class TesseraSportiva {
    private List<TicketSportivo> tickets;
    private String intestatario;
    private double costo;

    public TesseraSportiva(String intestatario) {
        this.intestatario = intestatario;
        tickets = new ArrayList<>(5);
    }

    public List<TicketSportivo> getTickets()
    {
        return tickets;
    }

    public void addTicket(TicketSportivo t) throws ListaPienaException {
        if (tickets.size() >= 5)
            throw new ListaPienaException();
        else if (tickets.contains(t))
            throw new AttivitaException();

        tickets.add(t);
        double costoTemp = tickets.stream().mapToDouble(TicketSportivo::getCosto).sum();
        costo += costoTemp * 0.2;
    }

    public void utilizza(int i) throws TicketNonUsabileException {
        if(tickets.size() <= i)
            return;
        if(tickets.get(i).isUsed())
            throw new TicketNonUsabileException();

        tickets.get(i).usaTicket();
    }

    public boolean isUsabile()
    {
        return tickets.stream().filter(TicketSportivo::isUsed).count() != tickets.size();
    }
}
