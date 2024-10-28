package es10;

public class ContoCorrente {
    private final String titolare;
    private int nMovimenti;
    private static final int maxMovimenti = 50;
    private double saldo;

    public ContoCorrente(String titolare, double saldo)
    {
        this.titolare = titolare;
        this.saldo = saldo;
    }

    public void preleva(double x) {
        if (nMovimenti < maxMovimenti)
                saldo -= x;
        else
            saldo -= x - 0.5;

        assert saldo >= 0:
                "Il conto e' in rosso";

        nMovimenti++;
    }

    public String restituisciSaldo()
    {
        return titolare + " " + saldo;
    }

}
