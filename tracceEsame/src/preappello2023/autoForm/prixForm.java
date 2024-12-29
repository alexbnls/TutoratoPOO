package preappello2023.autoForm;

import preappello2023.autovettura.Autovettura;
import preappello2023.autovettura.Benzina;
import preappello2023.autovettura.Elettriche;
import preappello2023.autovettura.Ibride;
import preappello2023.granprix.GranPrix;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class prixForm {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton simulaButton;
    private GranPrix granPrix;

    public prixForm() {
        simulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                granPrix = new GranPrix(30, 7, 8, 5);
                textArea1.setText("");
                int numVet = Integer.parseInt(textField1.getText());
                Random random = new Random();
                for (int i = 0; i < numVet; i++) {
                    Autovettura autovettura;
                    int r = random.nextInt(3);
                    if (r == 0)
                        autovettura = new Benzina("Fiat Multipla, " + i, 89);
                    else if (r == 1)
                        autovettura = new Elettriche("Tesla Y, " + i, 180);
                    else autovettura = new Ibride("Peugeot 3008, " + i, 160);

                    granPrix.aggiungiVettura(autovettura);
                }
                textArea1.append("Create " + numVet + " autovetture\n");
                granPrix.avviaMotori();

                for (int i = 0; i < 30; i++) {
                    granPrix.effettuaGiro();
                    Random r = new Random();
                    granPrix.pitStop(r.nextInt(numVet));
                }
                textArea1.append("Effettuati 30 giri\n*****\n");
                List<Autovettura> autovetture = granPrix.getAutovetture();
                autovetture.sort((a1,a2) -> Float.compare(a1.getTempoImpiegato(), a2.getTempoImpiegato()));
                textArea1.append("Ordine di arrivo\n1 posto\n" + autovetture.getFirst() + autovetture.getFirst().getTempoImpiegato() + "\n2 posto\n" + autovetture.get(1) + "\n3 posto\n" + autovetture.get(2)+ "\n*****");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("prixForm");
        frame.setContentPane(new prixForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
