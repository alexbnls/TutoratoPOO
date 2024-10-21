package es7;

public class Distributore {
    private String city;
    private String owner;
    private Pompa pompa;
    private final int buyPrice = 1;
    private final int sellPrice = 2;
    private int incasso;
    private int spese;

    public Distributore(String city, String owner, Pompa pompa)
    {
        this.city = city;
        this.owner = owner;
        this.pompa = pompa;
    }

    public void rifornisci(int litri)
    {
        pompa.rimuoviF(litri);
        incasso += litri * sellPrice;
    }

    public void aggiungi(int litri)
    {
        int diffLitri = pompa.aggiungiF(litri);
        if(diffLitri > 0)
            incasso += diffLitri * sellPrice;

        spese += litri * buyPrice;
    }

    public int litri()
    {
        return pompa.getFuelLevel();
    }

    public int ricavo()
    {
        return incasso - spese;
    }
}
