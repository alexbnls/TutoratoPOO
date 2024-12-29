package es1;

public class AutoElettrica extends Veicolo{
    private double batteryCapacity;
    private int autonomia;

    public AutoElettrica(String modello, String marca, double prezzo, int annoImmatricolazione, double batteryCapacity, int autonomia) {
        super(modello, marca, prezzo, annoImmatricolazione);
        this.batteryCapacity = batteryCapacity;
        this.autonomia = autonomia;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                "[Capacita' batteria: " + batteryCapacity + "kWh] " +
                "[Autonomia: " + autonomia + "h]";
    }

    @Override
    public double calcolaPrezzoFinale() {
        return getPrezzo() + (getPrezzo() * 10 / 100);
    }
}
