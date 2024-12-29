package esercizi.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main (String[] args)
    {

        List<String> strings = Arrays.asList("Ciao", "sono", "Alessandro", "punto");
//        Integer stringsConsonant = strings.stream()
//                .map(p -> p.replaceAll("[aeiouAEIOU]",""))
//                .map(String::length)
//                .reduce(Integer::sum).get();

        List<String> modifiedStrings = strings.stream()
                .filter(word -> word.length() % 2 != 0)
                .map(String::toLowerCase)
                .map(a -> a + a.length())
                .filter(a -> ("aeiou".indexOf(a.charAt(0)) == -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        modifiedStrings.forEach(System.out::println);


        List<Prodotto> prodotti = Arrays.asList(
                new Prodotto("Laptop", 100),
                new Prodotto("Smartphone", 1000),
                new Prodotto("Vibratore", 650),
                new Prodotto("Letto", 30),
                new Prodotto("The al limone", 1)
        );

        List<String> prodottiNew = prodotti.stream()
                .filter(prodotto -> prodotto.getPrezzo() > 50)
                .sorted((p1,p2) -> Double.compare(p2.getPrezzo(), p1.getPrezzo()))
                .map(prodotto -> "Nome: " + prodotto.getNome() + " Prezzo: " + prodotto.getPrezzo())
                .toList();
        prodottiNew.forEach(System.out::println);

        Random random = new Random();
        List<Libro> libri = new ArrayList<>();
        List<String> nomiAutore = Arrays.asList("Mario", "Luca", "Giulia", "Anna", "Francesca", "Giovanni", "Sofia", "Marco");
        List<String> cognomiAutore = Arrays.asList("Rossi", "Bianchi", "Verdi", "Neri", "Gialli", "Grandi", "Piccoli", "Tosti");
        List<String> titoli = Arrays.asList("Il mistero", "La luce perduta", "Ombre nel buio", "Il segreto", "L'avventura", "Il viaggio", "Un nuovo mondo", "La scoperta");

        for(int i = 0; i < 40; i++)
        {
            String sesso;
            if(random.nextInt(2) == 0)
                sesso = "Donna";
            else
                sesso = "Uomo";
            Autore autore = new Autore(nomiAutore.get(random.nextInt(nomiAutore.size())),
                    cognomiAutore.get(random.nextInt(cognomiAutore.size())),
                    random.nextInt(60) + 20, sesso);
            libri.add(new Libro(titoli.get(random.nextInt(titoli.size())), autore));
        }
        List<String> nomiUnici = libri.stream()
                .filter(libro -> libro.getAutore().getEta() > 40)
                .map(libro -> libro.getAutore().getNome().toUpperCase())
                .distinct()
                .limit(20)
                .toList();
        int sommaEtaDonne = libri.stream()
                .map(Libro::getAutore)
                .filter(autore -> autore.getSesso().equals("Donna"))
                .map(Autore::getEta)
                        .filter(eta -> eta < 25)
                                .reduce(0, Integer::sum);

        System.out.println("somma eta donne: " + sommaEtaDonne);
        nomiUnici.forEach(System.out::println);
    }
}
