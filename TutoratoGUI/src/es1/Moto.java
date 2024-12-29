package es1;

public class Moto extends Veicolo{
    private int cilindrata;
    private String tipo;

    public Moto(String modello, String marca, double prezzo, int annoImmatricolazione, int cilindrata, String tipo) {
        super(modello, marca, prezzo, annoImmatricolazione);
        this.cilindrata = cilindrata;
        this.tipo = tipo;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                "[Cilindrata: " + cilindrata + "cc] " +
                "[Tipo: " + tipo + "]";
    }

    @Override
    public double calcolaPrezzoFinale() {
        if(cilindrata > 500 && cilindrata <= 1000)
            return getPrezzo() + (getPrezzo()*5 / 100);
        if(cilindrata > 1000)
            return getPrezzo() + (getPrezzo()*10 / 100);

        return getPrezzo();
    }
}
