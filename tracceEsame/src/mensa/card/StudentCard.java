package mensa.card;

import java.time.LocalDate;

public class StudentCard extends Card{
    private String matricola;
    private LocalDate scadenza;
    private double saldo;
    private char fascia;
    private boolean bonus;

    public StudentCard(int codice, String nome, String cognome, String matricola, LocalDate scadenza, double saldo, char fascia, boolean bonus) {
        super(codice, nome, cognome);
        if(fascia != 'A' && fascia != 'B')
            throw new RuntimeException("Fascia errata");

        this.matricola = matricola;
        this.scadenza = scadenza;
        this.saldo = saldo;
        this.fascia = fascia;
        this.bonus = bonus;
    }

    public double calcolaPrezzo()
    {
        double prezzo;

        if(fascia == 'A')
            prezzo = 2.50;
        else
            prezzo = 1.50;

        if(isBonus())
            prezzo -= 1;

        return prezzo;
    }

    public double simulatePayment() throws ExpiredCardException {
        if(scadenza.isBefore(LocalDate.now()))
            throw new ExpiredCardException("Tessera scaduta");

        if(saldo < calcolaPrezzo())
            throw new InsufficientBalanceException("Saldo insufficiente");

        saldo -= calcolaPrezzo();
        return calcolaPrezzo();
    }

    public void pay(double x)
    {
        if(x < 0)
            throw new RuntimeException("Negativo?");

        saldo += x;
    }

    public boolean isBonus()
    {
        return bonus;
    }
}
