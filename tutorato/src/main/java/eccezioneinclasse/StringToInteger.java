package eccezioneinclasse;

public class StringToInteger {
    private int valore;

    public StringToInteger(String val) throws IllegalArgumentException
    {
        int temp = Integer.parseInt(val);
        if(temp > 10 || temp < -10)
            throw new IllegalArgumentException();
        valore = temp;
    }

    public int getValore()
    {
        return valore;
    }
}
