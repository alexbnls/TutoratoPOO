package traccia2022.registrazione;

import java.time.LocalDate;

public class Studente extends Registrazione{
    private String nomeUni;
    private String tipo;

    public Studente(String nome, String cognome, LocalDate dataRegistrazione, String nomeUni, String tipo) throws BadDateException {
        super(nome, cognome, dataRegistrazione);
        this.nomeUni = nomeUni;
        this.tipo = tipo;
    }

    @Override
    public boolean isInRitardo() {
        return getDataRegistrazione().isAfter(LocalDate.of(2021, 12, 13));
    }

    @Override
    public double calcolaCosto() {
        if(getDataRegistrazione().isBefore(LocalDate.of(2021, 12, 14)))
            return 250;
        else
            return 300;
    }
}
