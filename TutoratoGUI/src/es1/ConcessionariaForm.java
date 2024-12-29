package es1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConcessionariaForm {
    private JPanel mainPanel;
    private JLabel labelModello;
    private JLabel labelMarca;
    private JLabel labelPrezzo;
    private JLabel labelAnno;
    private JTextField textModello;
    private JTextField textMarca;
    private JTextField textPrezzo;
    private JTextField textAnno;
    private JButton buttonVeicolo;

    public ConcessionariaForm() {
        buttonVeicolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // Moto moto = new Moto(textModello.getText(), textMarca.getText(), Double.parseDouble(textPrezzo.getText()), Integer.parseInt(textAnno.getText()), 500, "Naked");
                //System.out.println(moto);
                frame.setVisible(false);
                frame1.setVisible(true);
            }
        });
    }

    public static void main(String[] args)
    {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new MotoForm().getMainPanel();
        JPanel panel = new ConcessionariaForm().mainPanel;
       // JPanel panel1 = new ConcessionariaForm().nuovoPanel;
        frame1.setContentPane(panel1);
        frame.setContentPane(panel);
        //frame.setContentPane(new ConcessionariaForm().nuovoPanel);
        frame.setSize(400, 400);
        frame1.setSize(400, 400);
        frame.setVisible(true);
    }
    private static JFrame frame = new JFrame();
    private static JFrame frame1 = new JFrame();
}
