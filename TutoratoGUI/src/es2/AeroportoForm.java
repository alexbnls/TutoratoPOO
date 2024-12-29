package es2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AeroportoForm {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JPanel voliPanel;
    private JPanel passPanel;
    private JPanel checkinPanel;
    private JButton aggiungiVoloButton;
    private JButton visualizzaIVoliButton;
    private JButton modificaRimuoviVoloButton;
    private JFrame frame;

    public AeroportoForm() {
        frame = new JFrame("AeroportoForm");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        aggiungiVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AggiungiVolo aggiungiVolo = new AggiungiVolo();
            }
        });
    }

    public static void main(String[] args) {
        Aeroporto aeroporto = new Aeroporto();
        Aereo aereo1 = new Aereo("1", "Boeing 747", 700, 1998);
        Aereo aereo2 = new Aereo("2", "Hoe 2", 400, 2001);
        Aereo aereo3 = new Aereo("3", "Ryanair", 200, 2014);
        aeroporto.addAereo(aereo1);
        aeroporto.addAereo(aereo2);
        aeroporto.addAereo(aereo3);
        AeroportoForm form = new AeroportoForm();

    }
}
