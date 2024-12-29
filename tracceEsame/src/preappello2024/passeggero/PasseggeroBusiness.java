package preappello2024.passeggero;

public class PasseggeroBusiness extends Passeggero{
    public PasseggeroBusiness(String cognome, String nome, int puntiFedelta, int annoIscrizionePianoFedelta) {
        super(cognome, nome, puntiFedelta, annoIscrizionePianoFedelta);
    }

    @Override
    public void guadagnaPunti(int miglia) throws LimitePuntiFedeltaException {
        int punti = (miglia/100) * 5;

        if(miglia > 5000)
            punti = (int) (punti + (punti * 0.25));

        if(getPuntiFedelta() + punti >= 10000)
            throw new LimitePuntiFedeltaException();

        addPuntiFedelta(punti);
    }
}
