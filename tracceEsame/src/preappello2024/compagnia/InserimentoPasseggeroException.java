package preappello2024.compagnia;

public class InserimentoPasseggeroException extends RuntimeException {
    public InserimentoPasseggeroException() {
        super("Passeggero gia' presente");
    }
}
