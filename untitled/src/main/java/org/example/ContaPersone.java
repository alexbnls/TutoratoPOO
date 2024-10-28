package org.example;

public class ContaPersone {

    private int people;

    public ContaPersone() {
        people = 0;
    }

    public void addOne() {
        people++;
    }

    public int getPeople() {
        return people;
    }

    public void reset() {
        people = 0;
    }
}
