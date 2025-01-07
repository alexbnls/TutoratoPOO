package traccia2022.registrazione;

import java.time.LocalDate;

public abstract class Registrazione {
    private String nome;
    private String cognome;
    private LocalDate dataRegistrazione;

    public Registrazione(String nome, String cognome, LocalDate dataRegistrazione) throws BadDateException {
        if (dataRegistrazione.isAfter(LocalDate.of(2022, 3, 1)))
            throw new BadDateException();

        this.nome = nome;
        this.cognome = cognome;
        this.dataRegistrazione = dataRegistrazione;
    }

    public abstract boolean isInRitardo();

    public abstract double calcolaCosto();

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public boolean equals(Object r) {
        if (r == null || r.getClass() != this.getClass())
            return false;

        Registrazione registrazione = (Registrazione) r;

        return registrazione.cognome.equals(cognome) && registrazione.nome.equals(nome);
    }
}
