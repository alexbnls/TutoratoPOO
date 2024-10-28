package org.tutorato.es3;

public class DistributoreBibite {
    private int numBibite;
    private int numGettoni;

    public DistributoreBibite(int numBibite)
    {
        this.numBibite = numBibite;
        this.numGettoni = 0;
    }

    public int getNumBibite()
    {
        return numBibite;
    }

    public int getNumGettoni()
    {
        return numGettoni;
    }

    public void aggiungiLattine(int num)
    {
        numBibite += num;
    }

    public void prendiBibita()
    {
        numGettoni++;
        numBibite--;
    }


}
