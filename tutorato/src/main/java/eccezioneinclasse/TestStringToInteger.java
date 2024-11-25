package eccezioneinclasse;

public class TestStringToInteger {
    public static void main(String[] args)
    {
        try
        {
            StringToInteger convertitore = new StringToInteger("ciao");
            System.out.println("Numero: " + convertitore.getValore());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Non e' un numero");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Numero non rientra nell'intervallo");
        }


    }
}
