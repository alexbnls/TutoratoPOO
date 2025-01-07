package traccia2022.registrazioni;

import traccia2022.registrazione.Registrazione;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Registrazioni {
    private List<Registrazione> registrazioniList;

    public Registrazioni() {
        registrazioniList = new ArrayList<>();
    }

    public void aggiungiRegistrazione(Registrazione r) {
        if (registrazioniList.contains(r))
            throw new RegistrationException("Reg. gia' presente");

        registrazioniList.add(r);
        registrazioniList.sort(Comparator.comparing(Registrazione::getCognome));
    }

    public double dammiTotale() {
        double sum = 0;

        for (Registrazione registrazione : registrazioniList)
            sum += registrazione.calcolaCosto();

        return sum;
    }

    public double dammiTotalePerTipoPartecipante(String tipo) throws InvalidParameterException {
        if (!tipo.equals("Studente") && !tipo.equals("Membro") && !tipo.equals("Non Membro"))
            throw new InvalidParameterException("Tipo invalido");
        if(tipo.equals("Non Membro"))
            tipo = "NonMembro";
        double sum = 0;

        for (Registrazione registrazione : registrazioniList) {
            if (registrazione.getClass().getSimpleName().equals(tipo))
                sum += registrazione.calcolaCosto();
        }

        return sum;
    }

    public double dammiTotalePerTipoRegistrazione(int x) {
        if (x != 0 && x != 1)
            throw new InvalidParameterException("Tipo invalido");

        double sum = 0;

        for (Registrazione registrazione : registrazioniList) {
            if (x == 0 && !registrazione.isInRitardo())
                sum += registrazione.calcolaCosto();
            else if (x == 1 && registrazione.isInRitardo())
                sum += registrazione.calcolaCosto();
        }

        return sum;
    }

    public Registrazione cerca(String cognome)
    {
        List<Registrazione> registrazioni = registrazioniList.stream().filter(registrazione -> registrazione.getCognome().equals(cognome)).toList();

        if(!registrazioni.isEmpty())
            return registrazioni.getFirst();
        else
            return null;
    }
}
