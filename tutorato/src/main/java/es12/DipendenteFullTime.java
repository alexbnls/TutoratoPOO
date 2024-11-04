package es12;

public class DipendenteFullTime extends Dipendente {
    private int ferieConcesse;
    private int ferieUtilizzate;
    private int buoniPasto;

    public DipendenteFullTime(String matricola, double stipendio, double straordinario, int buoniPasto) {
        super(matricola, stipendio, straordinario);
        this.buoniPasto = buoniPasto;
    }

    public double paga(int ore)
    {
        double p = super.paga(ore);

        if(buoniPasto == 0)
            return p - (ferieUtilizzate * 90);

        return (p + (buoniPasto * 5)) - (ferieConcesse * 100);
    }
}
