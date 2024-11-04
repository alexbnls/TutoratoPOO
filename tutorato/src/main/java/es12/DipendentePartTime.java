package es12;

public class DipendentePartTime extends Dipendente {

    private int malattia;

    public DipendentePartTime(String matricola, double stipendio, double straordinario) {
        super(matricola, stipendio, straordinario);
    }

    public void prendiMalattia(int giorni)
    {
        malattia += giorni;
    }

    public double paga(int ore)
    {
        double p = super.paga(ore);

        if(malattia > 0)
            return p - (malattia * 15);

        return p;
    }

}
