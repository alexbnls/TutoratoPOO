package es14;

public class Noleggio {
    private Film film;
    private static int idCliente = 0;
    private int giorniRitardoConsegna;

    public Noleggio(Film film, int giorniRitardoConsegna)
    {
        this.film = film;
        this.giorniRitardoConsegna = giorniRitardoConsegna;
        idCliente++;
    }

    public Film dammiFilm()
    {
        return film;
    }

    public double calcolaPenaleNoleggio()
    {
        return film.calcolaPenaleRitardo(giorniRitardoConsegna);
    }
}
