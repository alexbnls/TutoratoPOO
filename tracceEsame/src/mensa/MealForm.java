package mensa;

import mensa.card.Card;
import mensa.card.StaffCard;
import mensa.card.StudentCard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;

public class MealForm {
    private JPanel mainPanel;
    private JButton caricaButton;
    private JTextField textField1;
    private File file;

    public MealForm() throws IOException {
        StudentCard card1 = new StudentCard(10, "Ale", "DB", "05121", LocalDate.of(2025, 10, 2), 100, 'A', true);
        StudentCard card2 = new StudentCard(12, "Gae", "AP", "05121", LocalDate.of(2025, 10, 2), 100, 'A', true);
        StaffCard card3 = new StaffCard(15, "Dario", "DN", "Informatica", 0, "professor");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mensa.dat"));
        out.writeObject(card1);
        out.writeObject(card2);
        out.writeObject(card3);

        caricaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file = new File(textField1.getText());
                MealPayment mealPayment = new MealPayment();
                ObjectInputStream in;
                try {
                    in = new ObjectInputStream(new FileInputStream(file));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                while (true)
                {
                    try{
                        Card card = (Card) in.readObject();
                        mealPayment.addCard(card);
                    } catch (IOException | ClassNotFoundException e1)
                    {
                        break;
                    }

                }
                try {
                    in.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                TesseraForm tesseraForm = new TesseraForm(mealPayment);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        MealForm mealForm = new MealForm();
        JFrame frame = new JFrame("MealForm");
        frame.setContentPane(mealForm.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
