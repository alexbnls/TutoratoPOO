package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount conto = new BankAccount(20000);
        conto.withdraw(8989);
        conto.deposit(100000);

        ContaPersone conta = new ContaPersone();
        conta.addOne();

        Auto car = new Auto("bmw", "x6", "a123", 10, 99);

        System.out.println(car.getKm());
        System.out.println("Il modello e'" + car.getModello());

        System.out.println(conta.getPeople());
        System.out.println(conto.getBalance());
    }
}