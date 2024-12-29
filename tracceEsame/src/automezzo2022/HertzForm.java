package automezzo2022;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HertzForm {
    private JTextField textField1;
    private JButton generaButton;
    private JButton simulaButton;
    private JTextArea textArea1;
    private JPanel panel;
    private Hertz hertz;

    public HertzForm() {
        generaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numMezzi = Integer.parseInt(textField1.getText());
                textArea1.setText("");
                hertz = new Hertz();
                Random random = new Random();
                int contAuto = 0, contFurgoni = 0, contMoto = 0;

                for(int i = 0; i < numMezzi; i++)
                {
                    int r = random.nextInt(3);
                    switch (r)
                    {
                        case 0:
                            hertz.addMezzo(new Auto("fiat", "figa", 90, "BL611ED"));
                            contAuto++;
                            break;
                        case 1:
                            String brand;
                            int marca = random.nextInt(3);
                            if(marca == 0)
                                brand = "Citroen";
                            else if(marca == 1)
                                brand = "Ford";
                            else
                                brand = "Fiat";
                            hertz.addMezzo(new Furgone(brand, "boh", 300, "TARGA"));
                            contFurgoni++;
                            break;
                        case 2:
                            hertz.addMezzo(new Moto("honda","hornet",70,"lol"));
                            contMoto++;
                            break;
                    }
                }
                textArea1.append("Generati " + numMezzi + " automezzi\n");
                textArea1.append(contAuto + " Auto\n");
                textArea1.append(contFurgoni + " Furgoni\n");
                textArea1.append(contMoto + " Moto\n");
            }
        });
        simulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HertzForm");
        frame.setContentPane(new HertzForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
