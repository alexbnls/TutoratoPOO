package es9;

public class Persona implements Comparable {
    private final String nome;

    public Persona(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    @Override
    public int compareTo(Object obj)
    {
        Persona persona = (Persona) obj;

        return this.nome.compareTo(persona.nome);
    }

}
