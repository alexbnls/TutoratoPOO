package org.example;

public class DataSet {
    private double sum;
    private double maximum;
    private int count;

    public DataSet()
    {
    }

    public void add (double x)
    {
        sum = sum + x;
        count++;
    }

    public double getAverage()
    {
        if(count == 0) return 0;
        return sum / count;
    }

    public double getMaximum()
    {
        return maximum;
    }
}
