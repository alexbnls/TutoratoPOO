package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String river = "Calore";

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello fiume " + river);
        river = river.replace("lore", "zzo");

        for (int i = 1; i <= 5; i++)
            System.out.println("Stronzo " + river);

    }
}