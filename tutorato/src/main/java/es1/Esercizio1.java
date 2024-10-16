package es1;

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 9;
        int[] a = new int[n];
        int somma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Dammi un numero: ");
            int num = in.nextInt();
            a[i] = num;
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                somma = somma + a[i];
            else
                somma = somma - a[i];
        }

        System.out.println(somma);
    }

}
