package esercizi_gui_classe;

import java.util.List;

public class Albergo {
    private List<Cliente> clienti;
    private List<Prenotazione> prenotazioni;

    public Albergo(List<Cliente> clienti, List<Prenotazione> prenotazioni) {
        this.clienti = clienti;
        this.prenotazioni = prenotazioni;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}
