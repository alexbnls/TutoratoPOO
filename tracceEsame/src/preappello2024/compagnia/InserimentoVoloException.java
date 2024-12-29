package preappello2024.compagnia;

public class InserimentoVoloException extends Exception {
    public InserimentoVoloException() {
        super("Volo gia' inserito");
    }
}
