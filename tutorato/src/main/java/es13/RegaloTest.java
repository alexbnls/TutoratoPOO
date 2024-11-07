package es13;

import java.util.GregorianCalendar;

public class RegaloTest {
    public static void main (String[] args)
    {
        Regalo regalo = new Regalo(new GregorianCalendar(2002, 7,11), 20, "Nord");
        Regalo regalo1 = new Regalo(new GregorianCalendar(2002, 7,11), 20, "Nord");
        System.out.println(regalo.toString());
        //System.out.println(regalo.equals(regalo1));
        Regalo regalo2 = (Regalo) regalo.clone();
        System.out.println(regalo == regalo2);
        System.out.println(regalo.equals(regalo2));
        RegaloBambino regaloBambino = new RegaloBambino(new GregorianCalendar(2002, 7,11), 20, "Nord", "Alessandro", 19, "buon natale");
        System.out.println(regaloBambino.toString());
    }
}
