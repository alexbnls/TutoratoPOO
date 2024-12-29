package esercizi_gui_classe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StampaForm {
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton stampaClientiButton;
    private JButton stampaPrenotazioniButton;
    private final Albergo albergo;

    public StampaForm(Albergo albergo) {
        this.albergo = albergo;
        ButtonListener buttonListener = new ButtonListener();
        stampaClientiButton.addActionListener(buttonListener);
        stampaPrenotazioniButton.addActionListener(buttonListener);
    }


    private void stampaTesto(List<?> list)
    {
        textArea1.setText("");
        textArea1.append("Lista di " + list.getFirst().getClass().getSimpleName() + "\n");
        for (Object object : list) {
            textArea1.append(object.toString() + "\n");
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == stampaClientiButton) {
                stampaTesto(albergo.getClienti());
            } else if (e.getSource() == stampaPrenotazioniButton) {
                stampaTesto(albergo.getPrenotazioni());
            }
        }
    }

    public static void main(String[] args) {
        List<Cliente> clienti = new ArrayList<>();
        List<Prenotazione> prenotazioni = new ArrayList<>();
        clienti.add(new Cliente("Gaetano", "Aprile"));
        clienti.add(new Cliente("Vincenzo", "Golia"));
        prenotazioni.add(new Prenotazione("deluxe"));
        prenotazioni.add(new Prenotazione("junior"));
        Albergo albergo = new Albergo(clienti, prenotazioni);

        JFrame frame = new JFrame("StampaForm");
        StampaForm form = new StampaForm(albergo);
        frame.setContentPane(form.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
