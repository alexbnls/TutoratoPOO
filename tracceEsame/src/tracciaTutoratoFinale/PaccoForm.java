package tracciaTutoratoFinale;

import tracciaTutoratoFinale.centro.CentroSpedizioni;
import tracciaTutoratoFinale.pacco.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;

public class PaccoForm {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JButton inserisciPaccoSelezionatoButton;
    private JComboBox comboBox2;
    private JButton ordinaButton;
    private JTextField textField1;
    private JTextArea textArea2;
    private JButton calcolaButton;
    private JButton cercaButton;
    private JLabel labelCosto;
    private JTextArea textArea3;
    private JButton cercaConDestButton;
    private CentroSpedizioni centroSpedizioni;

    public PaccoForm() {
        centroSpedizioni = new CentroSpedizioni();

        inserisciPaccoSelezionatoButton.addActionListener(e -> {
            String tipo = (String) comboBox1.getSelectedItem();
            String id = JOptionPane.showInputDialog("Inserisci ID");
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Inserisci peso"));
            String destinazione = JOptionPane.showInputDialog("Inserisci destinazione");
            String priorita = JOptionPane.showInputDialog("Inserisci priorita' pacco (Alta/Media/Bassa)");
            Pacco pacco;
            switch (tipo) {
                case "Fragile":
                    String speciale = JOptionPane.showInputDialog("Imballaggio speciale (y/n)");
                    if (speciale.equals("y"))
                        centroSpedizioni.aggiungiPacco(pacco = new PaccoFragile(id, peso, destinazione, priorita, true));
                    else
                        centroSpedizioni.aggiungiPacco(pacco = new PaccoFragile(id, peso, destinazione, priorita, false));
                    break;
                case "Express":
                    int tempo = Integer.parseInt(JOptionPane.showInputDialog("Tempo di consegna desiderato (in ore)"));
                    centroSpedizioni.aggiungiPacco(pacco = new PaccoExpress(id, peso, destinazione, priorita, tempo));
                    break;
                case "Assicurato":
                    double valore = Double.parseDouble(JOptionPane.showInputDialog("Valore assicurato"));
                    centroSpedizioni.aggiungiPacco(pacco = new PaccoAssicurato(id, peso, destinazione, priorita, valore));
                    break;
                default:
                    centroSpedizioni.aggiungiPacco(pacco = new PaccoStandard(id, peso, destinazione, priorita));
                    break;
            }
            textArea1.append(pacco + "\n");
        });
        ordinaButton.addActionListener(e -> {
            String ord = (String) comboBox2.getSelectedItem();
            switch (ord)
            {
                case "Peso":
                    centroSpedizioni.ordinaPacchi(Comparator.comparingDouble(Pacco::getPeso));
                    break;
                case "Priorita":
                    centroSpedizioni.ordinaPacchi(Pacco::compareTo);
                    break;
                case "Destinazione":
                    centroSpedizioni.ordinaPacchi(Comparator.comparing(Pacco::getDestinazione));
                    break;
            }
            List<Pacco> pacchi = centroSpedizioni.getPaccoList();
            textArea1.setText("");
            for(Pacco pacco: pacchi)
                textArea1.append(pacco + "\n");
        });
        cercaButton.addActionListener(e -> {
            textArea2.setText("");
            String priorita = textField1.getText();
            List<Pacco> pacchi = centroSpedizioni.trovaPacchiPerPriorita(priorita);
            for(Pacco pacco : pacchi)
                textArea2.append(pacco + "\n");
        });

        calcolaButton.addActionListener(e -> textArea3.setText("" + centroSpedizioni.calcolaTotaleSpedizioni()));

        cercaConDestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText("");
                String dest = textField1.getText();
                List<Pacco> pacchi = centroSpedizioni.getPaccoList().stream().filter(pacco -> pacco.getDestinazione().equals(dest)).toList();
                for(Pacco pacco : pacchi)
                    textArea2.append(pacco + "\n");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PaccoForm");
        frame.setContentPane(new PaccoForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
