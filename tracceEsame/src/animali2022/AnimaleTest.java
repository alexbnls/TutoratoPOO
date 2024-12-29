package animali2022;

public class AnimaleTest {
    //    public static void main(String[] args)
//    {
//        ElencoAnimali animali = new ElencoAnimali();
//        for(int i = 0; i < 42; i++)
//        {
//            animali.addAnimal(new Cane("" + i, 5 ));
//            if(i < 27)
//                animali.addAnimal(new Uccello("" + i, 0.1));
//            if(i < 31)
//                animali.addAnimal(new Pesce("" + i, 0.01));
//        }
//
//        System.out.println("Numero di pesci presenti: " + animali.getCounter("Pesce"));
//        System.out.println("Numero di cani presenti: " + animali.getCounter("Cane"));
//        System.out.println("Numero di uccelli presenti: " + animali.getCounter("Uccello"));
//        System.out.println("Alimentati: " + animali.alimenta());
//
//    }
    public static void main(String[] args) {
        Cane cane = new Cane("Ginger", 10);
        Uccello bird = new Uccello("Pavarotti", 0.5);
        Pesce fish = new Pesce("Nemo", 0.1);
        Pesce pane = new Pesce("Pane", 0.3);
        ElencoAnimali animali = new ElencoAnimali();
        animali.addAnimal(cane);
        animali.addAnimal(bird);
        animali.addAnimal(fish);
        animali.addAnimal(pane);

        System.out.println("Zampe totali: " + animali.getNumeroZampe());
        System.out.println("Numero di pesci presenti: " + animali.getCounter("Pesce"));
        System.out.println("Volte in cui gli animali hanno chiesto di mangiare: " + animali.alimenta());

    }
}
