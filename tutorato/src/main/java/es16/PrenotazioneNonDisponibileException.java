package es16;

public class PrenotazioneNonDisponibileException extends Exception {
    public PrenotazioneNonDisponibileException(String message) {
        super(message);
    }

    public PrenotazioneNonDisponibileException()
    {
        super();
    }
}
