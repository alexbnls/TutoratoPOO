package org.example;

/**
 * ugabuga
 */
public class BankAccount {

    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public BankAccount(double b) {
        balance = b;
    }

    public void withdraw(double b) {
        balance -= b;
    }

    public void deposit(double b) {
        balance += b;
    }

    public double getBalance() {
        double b = balance;
        return b;
    }
}
