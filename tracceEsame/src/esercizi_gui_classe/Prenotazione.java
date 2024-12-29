package esercizi_gui_classe;

public class Prenotazione {
    private static int idPrenotazione = 0;
    private int id;
    private String tipoCamera;

    public Prenotazione (String tipoCamera)
    {
        this.tipoCamera = tipoCamera;
        idPrenotazione++;
        this.id = idPrenotazione;
    }

    public int getIdPrenotazione() {
        return id;
    }

    public String getTipoCamera() {
        return tipoCamera;
    }

    @Override
    public String toString() {
        return "[Prenotazione #" + id + "] [Tipo camera: " + tipoCamera + "]";
    }
}
