package es11;

import java.util.List;

public class ScommessaIppica extends Scommessa{
    private String tipologiaGara;
    private String tipoScommessa;
    private List<String> cavalli;

    public ScommessaIppica(int codiceEvento, double sommaPuntata, double quotazioneScommessa, String tipologiaGara, String tipoScommessa, List<String> cavalli) {
        super(codiceEvento, sommaPuntata, quotazioneScommessa);
        this.tipologiaGara = tipologiaGara;
        this.tipoScommessa = tipoScommessa;
        this.cavalli = cavalli;
    }

    public double calcolaVincita()
    {
        if(tipoScommessa.equals("vincente"))
            return getQuotazioneScommessa() * getSommaPuntata() / cavalli.size();

        if(tipoScommessa.equals("piazzato"))
            return getQuotazioneScommessa() * getSommaPuntata() / (cavalli.size()*3);

        return super.calcolaVincita();
    }

    public String getTipologiaGara() {
        return tipologiaGara;
    }
}
