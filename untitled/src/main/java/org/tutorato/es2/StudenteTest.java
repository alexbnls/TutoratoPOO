package org.tutorato.es2;
import org.junit.Test;
import org.junit.Assert;

public class StudenteTest {

    @Test
    public void addQuizTest()
    {
        Studente gerry = new Studente("gerardo", 50,10);
        gerry.addQuiz(60);
        System.out.println(gerry.getAverageScore());
    }
}
