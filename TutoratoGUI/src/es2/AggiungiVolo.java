package es2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiVolo {
    private JButton vaiIndietroButton;
    private JTextField idField;
    private JTextField destField;
    private JTextField partField;
    private JTextField arrField;
    private JButton aggiungiButton;
    private JPanel mainPanel;
    private JFrame frame;

    public AggiungiVolo(){
        frame = new JFrame("AggiungiVolo");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        vaiIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AeroportoForm form = new AeroportoForm();
            }
        });
    }

}
