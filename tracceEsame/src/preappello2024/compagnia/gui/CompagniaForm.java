package preappello2024.compagnia.gui;

import preappello2024.compagnia.CompagniaAerea;
import preappello2024.compagnia.InserimentoVoloException;
import preappello2024.passeggero.Passeggero;
import preappello2024.passeggero.PasseggeroBusiness;
import preappello2024.passeggero.PasseggeroEconomica;
import preappello2024.volo.Volo;
import preappello2024.volo.VoloInternazionale;
import preappello2024.volo.VoloNazionale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class CompagniaForm {
    private JPanel mainPanel;
    private JLabel nomeLabel;
    private JTextArea textArea1;
    private JLabel soldiLabel;
    private JLabel bigliettiLabel;
    private JComboBox comboBox1;

    public CompagniaForm()
    {
        int codice = 0;

        Volo voloA = new VoloNazionale("" + codice++, 3, LocalDate.of(2020, 10, 4),35,50, 400);
        Volo voloB = new VoloNazionale("" + codice++, 5, LocalDate.now(),35,50, 400);
        Volo voloC = new VoloInternazionale("" + codice++, 2, LocalDate.now(),35,100, 700);
        Volo voloD = new VoloInternazionale("" + codice++, 6, LocalDate.now(),35,100, 700);

        CompagniaAerea compagniaAerea = new CompagniaAerea("FiscianAIR");
        try{
            compagniaAerea.aggiungiVolo(voloA);
            compagniaAerea.aggiungiVolo(voloB);
            compagniaAerea.aggiungiVolo(voloC);
            compagniaAerea.aggiungiVolo(voloD);
        } catch (InserimentoVoloException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < codice; i++)
            comboBox1.addItem(("" + i));

        Random random = new Random();
        for(int i = 0; i < 35; i++)
        {
            Passeggero passeggero = new PasseggeroBusiness("Golia" + i, "Vincenzo", 10, 2023);
            Passeggero passeggero1 = new PasseggeroEconomica("De Bonis" + i, "Alex", 30, 2020);
            compagniaAerea.prenotaVolo("" + random.nextInt(4), passeggero, "Business");
            compagniaAerea.prenotaVolo("" + random.nextInt(4), passeggero1, "Economy");
        }
        nomeLabel.setText(compagniaAerea.getNome());
        soldiLabel.setText("Soldi incassati: " + compagniaAerea.getSommaGuadagno());
        bigliettiLabel.setText("Biglietti venduti: " + 50);
        textArea1.setText(compagniaAerea.cercaVolo(Objects.requireNonNull(comboBox1.getSelectedItem()).toString()));


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = (String) comboBox1.getSelectedItem();
                textArea1.setText(compagniaAerea.cercaVolo(codice));
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("CompagniaForm");
        frame.setContentPane(new CompagniaForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,250);
        frame.setVisible(true);
    }
}
