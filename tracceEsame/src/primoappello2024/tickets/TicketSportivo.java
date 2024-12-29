package primoappello2024.tickets;

import java.io.Serializable;

public abstract class TicketSportivo implements Usabile, Serializable {
    private String tipo;
    private String luogo;
    private double costo;
    private boolean used;

    public TicketSportivo(String tipo, String luogo, double costo) {
        this.tipo = tipo;
        this.luogo = luogo;
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLuogo() {
        return luogo;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public boolean equals(Object t) {
        if(t == null || t.getClass() != getClass())
            return false;
        TicketSportivo ticketSportivo = (TicketSportivo) t;

        return ticketSportivo.getTipo().equals(tipo);
    }

    @Override
    public void usaTicket() {
        used = true;
    }

    public boolean isUsed() {
        return used;
    }

    public String toString()
    {
        return  "Tipo: " + getClass().getSimpleName().substring(6) + " - Attivita: " + tipo + " - Luogo: " + luogo + " - Costo: " + costo + " - Usato: " + used;
    }
}
