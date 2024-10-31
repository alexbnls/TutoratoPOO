package es11;

import java.util.Random;

public class ScommessaCalcistica extends Scommessa{
    private final String competizione;
    private String squadraA;
    private String squadraB;
    private final char scommessa;

    public ScommessaCalcistica(int codiceEvento, double sommaPuntata, double quotazioneScommessa, String competizione, char scommessa, String squadraA, String squadraB)
    {
        super(codiceEvento, sommaPuntata, quotazioneScommessa);
        this.competizione = competizione;
        this.scommessa = scommessa;
        this.squadraA = squadraA;
        this.squadraB = squadraB;
    }

    @Override
    public double calcolaVincita()
    {
        Random random = new Random();
        int punteggioA= random.nextInt(2)+1;
        int punteggioB = random.nextInt(1);

        switch(scommessa)
        {
            case '1':
                if(punteggioA > punteggioB)
                    return getQuotazioneScommessa() * getSommaPuntata();
                break;
            case '2':
                if(punteggioB > punteggioA)
                    return getQuotazioneScommessa() * getSommaPuntata();
                break;
            case 'x':
                if(punteggioA == punteggioB)
                    return getQuotazioneScommessa() * getSommaPuntata();
                break;
            default:
                break;
        }
        return super.calcolaVincita();
    }

    public String getCompetizione() {
        return competizione;
    }

    public String getSquadraA() {
        return squadraA;
    }

    public String getSquadraB() {
        return squadraB;
    }
}
