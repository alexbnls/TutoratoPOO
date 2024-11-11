package es13;

import java.util.*;

public class SlittaDiBabboNatale {
    private final List<Regalo> regali;
    private final int pesoMax;

    public SlittaDiBabboNatale(int pesoMax)
    {
        regali = new ArrayList<>();
        this.pesoMax = pesoMax;
    }

    public void aggiungiRegalo(Regalo gift)
    {
        double pesoAttuale = 0;

        for(Regalo regalo: regali)
        {
            pesoAttuale += regalo.getPeso();
        }

        assert pesoAttuale < pesoMax:
                "Peso eccessivo slitta";

        regali.add(gift);
    }

    public double calcolaCosto()
    {
        double costo = 0;

        for(Regalo gift: regali)
            costo += gift.calcolaCosto();

        return costo;
    }

    public final static Comparator<Regalo> dateComparator = new Comparator<Regalo>() {
        @Override
        public int compare(Regalo o1, Regalo o2) {
            return o1.getDataConsegna().compareTo(o2.getDataConsegna());
        }
    };

    public String spedisci()
    {
        String spedizione = "";

        for(Regalo gift: regali)
        {
            String reg = gift.getRegioneDestinatario();
            GregorianCalendar dataConsegna = new GregorianCalendar();

            if(reg.equals("Nord")) {
                gift.setDataConsegna(dataConsegna);
            }
            if(reg.equals("Centro")) {
                dataConsegna.add(Calendar.DAY_OF_MONTH,1);
                gift.setDataConsegna(dataConsegna);
            }

            if(reg.equals("Sud")) {
                dataConsegna.add(Calendar.DAY_OF_MONTH,2);
                gift.setDataConsegna(dataConsegna);
            }
        }

        regali.sort(dateComparator);

        for(Regalo gift: regali)
        {
            spedizione = spedizione + gift.toString() + "\n";
        }

        return spedizione;
    }

}
