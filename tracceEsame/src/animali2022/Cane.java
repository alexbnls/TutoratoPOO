package animali2022;

public class Cane extends Animale {

    public Cane(String nome, double peso) {
        super(nome, peso, 4);
        contCibo = 0;
    }

    public boolean vuoiMangiare() {
        contCibo++;
        return contCibo == getPeso();
    }

    public String toString() {
        return super.toString();
    }
}
