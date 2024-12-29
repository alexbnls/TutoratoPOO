package preappello2023.granprix;

public class InsertionException extends RuntimeException {
    public InsertionException() {
        super("Vettura gia' presente");
    }
}
