package es5;

public class Action {
    private String nome;
    private double importo;
    private int quantita;
    private char tipologia;

    public Action(String nome, double importo, int quantita, char tipologia)
    {
        this.nome = nome;
        this.importo = importo;
        this.quantita = quantita;
        this.tipologia = tipologia;
    }

    public String getAzione()
    {
        String a = nome + " " + importo + " " + quantita + " " + tipologia;
        return a;
    }
    public String getNome()
    {
        return nome;
    }

    public double getImporto()
    {
        return importo;
    }

    public int getQuantita()
    {
        return quantita;
    }

    public char getTipologia()
    {
        return tipologia;
    }
}
