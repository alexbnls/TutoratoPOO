package tracciaTutoratoFinale.pacco;

public abstract class Pacco implements Comparable<Pacco>, Cloneable {
    private String id;
    private double peso;
    private String destinazione;
    private String priorita;
    private final double tariffaBase;

    public Pacco(String id, double peso, String destinazione, String priorita) {
        this.id = id;
        this.peso = peso;
        this.destinazione = destinazione;
        this.priorita = priorita;
        tariffaBase = peso * 5;
    }

    public abstract double calcolaCosto();


    public double getTariffaBase() {
        return tariffaBase;
    }

    public int compareTo(Pacco altro) {

        switch (priorita) {
            case "Alta":
                if (altro.priorita.equals("Bassa") || altro.priorita.equals("Media"))
                    return -1;
                break;
            case "Media":
                if (altro.priorita.equals("Bassa"))
                    return -1;
                else if (altro.priorita.equals("Alta"))
                    return 1;
                break;
            case "Bassa":
                if (altro.priorita.equals("Alta") || altro.priorita.equals("Media"))
                    return 1;
                break;
        }

        return Double.compare(peso, altro.peso);
    }

    public String getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public String getPriorita() {
        return priorita;
    }

    public String toString() {
        return "ID: " + id + " - Peso: " + peso + " - Destinazione: " + destinazione + " - Priorita': " + priorita;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object p = super.clone();
        Pacco pacco = (Pacco) p;
        pacco.id = id;
        pacco.peso = peso;
        pacco.destinazione = destinazione;
        pacco.priorita = priorita;
        return pacco;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;

        Pacco pacco = (Pacco) o;

        return pacco.id.equals(id);
    }
}
