package animali2022;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AnimaliForm {
    private JPanel panel1;
    private JTextField textField1;
    private JButton generaButton;
    private JLabel label;
    private JTextArea textArea1;
    private JButton alimentaButton;
    private ElencoAnimali animali;

    public AnimaliForm() {
        generaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                animali = new ElencoAnimali();
                Random random = new Random();
                int contCani = 0, contUccelli = 0, contPesci = 0;

                int numAnimali = Integer.parseInt(textField1.getText());
                for(int i = 0; i < numAnimali; i++)
                {
                    int r = random.nextInt(3);
                    switch(r)
                    {
                        case 0:
                            animali.addAnimal(new Cane("boh", (random.nextInt(46) + 5)));
                            contCani++;
                            break;
                        case 1:
                            animali.addAnimal(new Pesce("boh", 0.2));
                            contPesci++;
                            break;
                        case 2:
                            animali.addAnimal(new Uccello("boh", 0.4));
                            contUccelli++;
                            break;
                    }
                }
                textArea1.append("Generati " + numAnimali + " animali.\n");
                textArea1.append(contCani + " cani\n");
                textArea1.append(contUccelli + " uccelli\n");
                textArea1.append(contPesci + " pesci\n");
            }
        });
        alimentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int invocazioni = animali.alimenta();

                textArea1.append("Animali alimentati - " + invocazioni + " invocazioni vuoiMangiare()\n");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AnimaliForm");
        frame.setContentPane(new AnimaliForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
