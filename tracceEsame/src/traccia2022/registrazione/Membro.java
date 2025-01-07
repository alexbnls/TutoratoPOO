package traccia2022.registrazione;

import java.time.LocalDate;

public class Membro extends Registrazione {
    private String nomeAzienda;
    private String numeroTessera;

    public Membro(String nome, String cognome, LocalDate dataRegistrazione, String nomeAzienda, String numeroTessera) throws BadDateException {
        super(nome, cognome, dataRegistrazione);
        this.nomeAzienda = nomeAzienda;
        this.numeroTessera = numeroTessera;
    }

    @Override
    public boolean isInRitardo() {
        return getDataRegistrazione().isAfter(LocalDate.of(2021, 12, 18));
    }

    @Override
    public double calcolaCosto() {
        if (getDataRegistrazione().isBefore(LocalDate.of(2021, 12, 19)))
            return 500;
        else
            return 550;
    }
}
