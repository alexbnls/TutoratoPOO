package traccia2022.registrazione;

import java.time.LocalDate;

public class NonMembro extends Registrazione {
    private String nomeAzienda;

    public NonMembro(String nome, String cognome, LocalDate dataRegistrazione, String nomeAzienda) throws BadDateException {
        super(nome, cognome, dataRegistrazione);
        this.nomeAzienda = nomeAzienda;
    }

    @Override
    public boolean isInRitardo() {
        return getDataRegistrazione().isAfter(LocalDate.of(2021, 12, 20));
    }

    @Override
    public double calcolaCosto() {
        if (getDataRegistrazione().isBefore(LocalDate.of(2021, 12, 21)))
            return 600;
        else
            return 650;
    }
}
