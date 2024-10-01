package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String x = "ab", y = "cd", z = "ef";
        String s = x.concat(y.concat(z));

        System.out.println(s);
    }
}