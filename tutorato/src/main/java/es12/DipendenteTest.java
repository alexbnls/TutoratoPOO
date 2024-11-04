package es12;

public class DipendenteTest {
    public static void main (String[] args)
    {
        Dipendente dipendente = new DipendentePartTime("9292", 1100, 10);

        System.out.println(dipendente.paga(8));
        ((DipendentePartTime) dipendente).prendiMalattia(10);
        System.out.println(dipendente.paga(8));

        Dipendente dipendente1 = new DipendenteFullTime("1212", 1700, 13, 100);

        System.out.println(dipendente1.paga(8));

    }
}
