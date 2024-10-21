package es7;

public class Main {
    public static void main(String[] args)
    {
        Distributore distributore = new Distributore("salerno","ale", new Pompa("diesel",500));
        distributore.aggiungi(200);
        System.out.println("Litri iniziali: " + distributore.litri());

        distributore.rifornisci(100);

        System.out.println("Litri finali: " + distributore.litri());
        System.out.println("Ricavo: " + distributore.ricavo());

    }
}
