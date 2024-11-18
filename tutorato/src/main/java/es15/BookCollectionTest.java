package es15;

public class BookCollectionTest {
    public static void main (String[] args)
    {
        CustomCollection<Book> libri = new CustomCollection<Book>();
        CustomCollection<Book> libri1 = new CustomCollection<Book>();
        Book b1 = new Book("Boh", "non so", 2001);
        Book b2 = new Book("Ehi", "ciao", 1999);
        Book b3 = new Book("Prova", "libro", 2000);

        libri.add(b1);
        libri.add(b2);
        libri.add(b3);
        libri1.add(b1);
        libri1.add(b2);
        libri1.add(b3);

        CustomCollection<Book> libriUniti = CustomCollection.merge(libri, libri1);

        CollectionUtils.printCollection(libriUniti);

        System.out.println("Massimo della lista: " + libri.getMax());
        System.out.println();

        libri.sort(Book.bookComparator);
       // libri.sort((o1,o2) -> Integer.compare(o2.getAnno(), o1.getAnno()));  ESPRESSIONE BOOLEANA
        System.out.println("Lista ordinata per anno:");
        CollectionUtils.printCollection(libri);
    }
}
