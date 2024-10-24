package es8;

import java.util.Random;

public class Moneta implements Lanciabile {
    private static int nLanci;

    public Moneta()
    {}
    public int lancio()
    {
        Random random = new Random();
        nLanci++;

        return random.nextInt(2);
    }
    public static int getnLanci()
    {
        return nLanci;
    }
}
