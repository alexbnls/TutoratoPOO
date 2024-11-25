package es16;

import java.util.ArrayList;
import java.util.List;

public class CentroSportivo {
    private List<Attivita> activities;
    private List<Utente> utenti;
    private List<Prenotazione> prenotazioni;

    public CentroSportivo (List<Attivita> activities)
    {
        this.activities = activities;
        utenti = new ArrayList<>();
        prenotazioni = new ArrayList<>();
    }

    public void registerUser(Utente user)
    {
        utenti.add(user);
    }

    public void newPrenotazione(String id, String activity, String user) throws PrenotazioneNonDisponibileException, UtenteNonRegistratoException {
        boolean found = false;
        Attivita act = null;

        for(Attivita attivita: activities)
        {
            if(attivita.getNome().equals(activity)) {
                act = attivita;
                found = true;
                break;
            }
        }

        if(!found)
            throw new AttivitaNonTrovataException("attivita inesistente");

        Utente usr = null;
        found = false;

        for(Utente utente: utenti)
        {
            if(utente.getId().equals(user)) {
                usr = utente;
                found = true;
                break;
            }
        }

        if(!found)
            throw new UtenteNonRegistratoException("utente non registrato");

        if(act.getPostiLiberi() <= 0)
               throw new PrenotazioneNonDisponibileException("non ci sono posti liberi");
        act.prenotaPosto();

        Prenotazione prenotazione = new Prenotazione(id, usr, act);

        for(Prenotazione pr : prenotazioni)
        {
            if(pr.getId().equals(prenotazione.getId()))
                throw new PrenotazioneDuplicataException("prenotazione con ID gia' esistente");
            if(pr.getActivity().getNome().equals(prenotazione.getActivity().getNome())
                    && pr.getUser().getId().equals(prenotazione.getUser().getId()))
                throw new PrenotazioneDuplicataException("attivita gia' prenotata dall'utente");
        }

        prenotazioni.add(prenotazione);

    }

    public void showActivities()
    {
        for(Attivita attivita: activities)
        {
            System.out.println(attivita);
        }
    }
}
