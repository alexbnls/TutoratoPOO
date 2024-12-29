package es17;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private final List<Libro> libri;

    public Biblioteca() {
        libri = new ArrayList<>();
    }

    public void addLibro(Libro libro) {
        libri.add(libro);
    }

    public void deleteLibro(Libro libro) {
        libri.remove(libro);
    }

    public void sortLibri(Comparator<? super Libro> sortMethod) {
        libri.sort(sortMethod);
    }

    public boolean findLibro(int isbn) {
        for (Libro libro : libri) {
            if (libro.getIsbn() == isbn)
                return true;
        }

        return false;
    }

    public boolean findLibro(String titolo)
    {
        for (Libro libro : libri) {
            if (libro.getTitolo().equals(titolo))
                return true;
        }

        return false;
    }

    public void printBooks()
    {
        for(Libro libro: libri)
            System.out.println(libro);
    }

    public void writeOnFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

        for(Libro libro: libri)
            out.writeObject(libro);

        out.close();
    }
    public void readFile(File file) throws IOException, ClassNotFoundException {
        Libro libro;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        while(true) {
            try {
                libro = (Libro) in.readObject();
                addLibro(libro);
            }
            catch (EOFException e)
            {
                break;
            }
        }

        in.close();
    }

}
