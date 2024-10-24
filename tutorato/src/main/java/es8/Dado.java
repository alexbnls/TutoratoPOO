package es8;

import java.util.Random;

public class Dado implements Lanciabile {
    private static int nLanci;

    public Dado()
    {}

    public int lancio()
    {
        Random random = new Random();
        nLanci++;

        return random.nextInt(6) + 1;
    }

    public static int getnLanci()
    {
        return nLanci;
    }
}
