package es3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DistributoreBibiteTest {
    @Test
    public void prendiBibitaTest()
    {
        DistributoreBibite distr = new DistributoreBibite(10);
        distr.prendiBibita();
        Assert.assertEquals(1,distr.getNumGettoni(),0);
        Assert.assertEquals(9,distr.getNumBibite(),0);
    }
  
}