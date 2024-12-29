package preappello2024.volo;

public class ClasseIndisponibileException extends Exception {
    public ClasseIndisponibileException() {
        super("No posti per la classe specificata");
    }
}
