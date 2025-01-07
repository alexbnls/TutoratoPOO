package mensa;

import mensa.card.Card;
import mensa.card.ExpiredCardException;
import mensa.card.StaffCard;
import mensa.card.StudentCard;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class MealPayment {
    private List<Card> cards;
    private double incasso;

    public MealPayment() {
        cards = new ArrayList<>();
    }

    public void addCard(Card t) {
        cards.add(t);
    }

    public boolean useCard(int code) throws ExpiredCardException {
        StudentCard studentCard;
        StaffCard staffCard;
        double soldi;

        for (Card card : cards) {
            if (card.getCodice() == code) {
                if (card.getClass().getSimpleName().equals("StudentCard")) {
                    studentCard = (StudentCard) card;
                    soldi = studentCard.simulatePayment();
                } else {
                    staffCard = (StaffCard) card;
                    soldi = staffCard.pay();
                }
                incasso += soldi;
                return true;
            }
        }

        return false;
    }

    public double computeTotal() {
        return incasso;
    }

    public MealPayment getCardByType(int x) {
        if (x != 0 && x != 1)
            throw new InvalidParameterException("Ins. tipo valido");

        MealPayment mealPayment = new MealPayment();

        for (Card card : cards) {
            if (x == 0)
                if (card.getClass().getSimpleName().equals("StudentCard"))
                    mealPayment.addCard(card);
                else if (card.getClass().getSimpleName().equals("StaffCard"))
                    mealPayment.addCard(card);
        }

        return mealPayment;
    }
}
