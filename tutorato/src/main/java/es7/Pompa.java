package es7;

public class Pompa {
    private String fuelType;
    private int fuelLevel;
    private final int fuelCapacity;

    public Pompa(String fuelType, int fuelCapacity)
    {
        this.fuelCapacity = fuelCapacity;
        this.fuelType = fuelType;
    }

    public int aggiungiF(int n)
    {
        fuelLevel += n;
        int diff = 0;

        if(fuelLevel > fuelCapacity) {
            diff = fuelLevel - fuelCapacity;
            fuelLevel = fuelCapacity;
        }

        return diff;
    }
    public int rimuoviF(int n)
    {
        if(n > fuelLevel)
            n = fuelLevel;

        fuelLevel -= n;
        return n;
    }

    public int getFuelCapacity()
    {
        return fuelCapacity;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
}
