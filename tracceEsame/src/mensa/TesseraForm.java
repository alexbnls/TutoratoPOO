package mensa;

import mensa.card.ExpiredCardException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TesseraForm {
    private JPanel panel1;
    private JTextField textField1;
    private JButton pagaButton;
    private JLabel label1;
    private MealPayment mealPayment;

    public TesseraForm(MealPayment mealPayment)
    {
        JFrame frame = new JFrame("MealForm");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.mealPayment = mealPayment;
        label1.setText("Somma incassata 0 euro");
        pagaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float incasso = 0;
                int code = Integer.parseInt(textField1.getText());
                try {
                    mealPayment.useCard(code);
                    incasso = (float) mealPayment.computeTotal();
                } catch (ExpiredCardException ex) {
                    throw new RuntimeException(ex);
                }

                label1.setText("Somma incassata " + incasso + " euro");
            }
        });
    }
}
