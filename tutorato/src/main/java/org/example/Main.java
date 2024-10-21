package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> comb = new ArrayList<>();
        for(int i = 0; i < 3; i++)
        {
            String p = "";
            for(int j = 0; j < 3; j++)
            {
                p = p + "x";
            }
            comb.add(p);
        }

        System.out.println(comb.getFirst());
    }
}