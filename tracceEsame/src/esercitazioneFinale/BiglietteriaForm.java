package esercitazioneFinale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class BiglietteriaForm {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JLabel bigliettiLabel;
    private JButton elencaSingoliButton;
    private JButton elencaOrariButton;
    private JButton elencaAbbonamButton;
    private JButton attivaBigliettoConIDButton;
    private JTextField textField1;
    private Biglietteria biglietteria;
    private static double guadagno;
    private static int bigliettiDisp = 50;

    public BiglietteriaForm()
    {
        Random random = new Random();
        biglietteria = new Biglietteria("fisciano");
        for(int i = 0; i < bigliettiDisp; i++)
        {
            int r = random.nextInt(3);
            if(r == 0)
                biglietteria.addBiglietto(new BigliettoSingolo("" + i, "boh", LocalTime.now(), 20));
            if(r == 1)
                biglietteria.addBiglietto(new BigliettoOrario("" + i, "qua", LocalTime.now(), LocalTime.of(23, 23)));
            if(r == 2)
                biglietteria.addBiglietto(new AbbonamentoMensile("" + i, "casa", LocalTime.now(), random.nextInt(4) + 1));
        }

        List<Biglietto> biglietti = biglietteria.getBiglietti();
        aggiornaText(biglietti);
        ButtonListener buttonListener = new ButtonListener();
        elencaOrariButton.addActionListener(buttonListener);
        elencaSingoliButton.addActionListener(buttonListener);
        elencaAbbonamButton.addActionListener(buttonListener);
        attivaBigliettoConIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                try {
                    biglietteria.attivaBiglietto(id);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                aggiornaText(biglietti);
            }
        });
    }

    public void aggiornaText(List<Biglietto> biglietti)
    {
        textArea1.setText("");
        for(Biglietto biglietto: biglietti) {
            if(biglietto.isStatoAttivazione()) {
                guadagno += biglietto.calcolaCosto();
                bigliettiDisp--;
            }
            else
                textArea1.append(biglietto.toString() + "\n");
        }
        bigliettiLabel.setText("N. Biglietti: " + bigliettiDisp + " Guadagno totale: " + (float) guadagno);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Biglietto> biglietti = null;
            if(e.getSource() == elencaSingoliButton)
                biglietti = biglietteria.filtraBiglietti(biglietto -> biglietto.getClass().getSimpleName().equals("BigliettoSingolo"));
            if(e.getSource() == elencaOrariButton)
                biglietti = biglietteria.filtraBiglietti(biglietto -> biglietto.getClass().getSimpleName().equals("BigliettoOrario"));
            if(e.getSource() == elencaAbbonamButton)
                biglietti = biglietteria.filtraBiglietti(biglietto -> biglietto.getClass().getSimpleName().equals("AbbonamentoMensile"));

            aggiornaText(biglietti);
        }
    }

    public static void main(String[] args) {
        BiglietteriaForm biglietteriaForm = new BiglietteriaForm();
        JFrame frame = new JFrame("BiglietteriaForm");
        frame.setContentPane(biglietteriaForm.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setVisible(true);
    }
}
