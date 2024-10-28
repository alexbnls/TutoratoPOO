package org.tutorato.es2;

public class Studente {
    private String nome;
    private int score;
    private int nQuiz;

    public Studente(String nome) {
        this.nome = nome;
    }

    public Studente(String nome, int score, int n) {
        this.nome = nome;
        this.score = score;
        nQuiz = n;
    }

    public void addQuiz(int score) {
        this.score += score;
        nQuiz++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return nome;
    }

    public int getAverageScore() {
        return score / nQuiz;
    }
}
