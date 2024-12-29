package animali2022;

public class Uccello extends Animale {
    public Uccello(String nome, double peso) {
        super(nome, peso, 2);
        contCibo = 0;
    }

    public boolean vuoiMangiare() {
        contCibo++;
        return contCibo == 4;
    }

    public String toString() {
        return super.toString();
    }
}
