package animali2022;

public class Pesce extends Animale {
    public Pesce(String nome, double peso) {
        super(nome, peso, 0);
    }

    public boolean vuoiMangiare() {
        contCibo++;
        return (contCibo == 3);
    }

    public String toString() {
        return super.toString();
    }
}
