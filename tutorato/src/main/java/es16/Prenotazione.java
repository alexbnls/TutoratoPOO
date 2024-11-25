package es16;

public class Prenotazione {
    private String id;
    private Utente user;
    private Attivita activity;


    public Prenotazione(String id, Utente user, Attivita activity) {
        this.id = id;
        this.user = user;
        this.activity = activity;
    }

    public String getId() {
        return id;
    }

    public Utente getUser() {
        return user;
    }

    public Attivita getActivity() {
        return activity;
    }

}
