package traccia2022.form;

import traccia2022.registrazione.BadDateException;
import traccia2022.registrazione.Membro;
import traccia2022.registrazione.NonMembro;
import traccia2022.registrazione.Studente;
import traccia2022.registrazioni.Registrazioni;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RegForm {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton generaButton;
    private JTextArea textArea1;
    private JButton totaleIncassatoButton;
    private JComboBox comboBox1;
    private JButton incassoButton;
    private Registrazioni registrazioni;

    public RegForm() {
        registrazioni = new Registrazioni();

        generaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int contS = 0, contM = 0, contNM = 0;
                int max = Integer.parseInt(textField1.getText());
                for (int i = 0; i < max; i++) {
                    int r = random.nextInt(3);
                    LocalDate startDate = LocalDate.of(2021, 12, 1);
                    LocalDate endDate = LocalDate.of(2022, 2, 28);
                    long giorni = ChronoUnit.DAYS.between(startDate, endDate);
                    LocalDate randomDate = startDate.plusDays(random.nextLong(giorni + 1));
                    if (r == 0) {
                        try {
                            registrazioni.aggiungiRegistrazione(new Studente("Ale" + i, "Db" + i, randomDate, "UNISA", "Triennale"));
                            contS++;
                        } catch (BadDateException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if (r == 1) {
                        try {
                            registrazioni.aggiungiRegistrazione(new Membro("Vin" + i, "Gl" + i, randomDate, "AGRIcsg", "ABC21"));
                            contM++;
                        } catch (BadDateException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(r == 2)
                    {
                        try {
                            registrazioni.aggiungiRegistrazione(new NonMembro("Gae" + i, "Ap" + i, randomDate, "sarno"));
                            contNM++;
                        } catch (BadDateException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
                textArea1.setText("Generate " + max + " registrazioni\n" + contS + " studenti\n" + contM + " membri\n" + contNM + " non membri\n******\n");
            }
        });
        totaleIncassatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append("Totale incassato: $" + registrazioni.dammiTotale() + "\n******\n");
            }
        });
        incassoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String tipo = (String) comboBox1.getSelectedItem();
               textArea1.append("Totale incassato da " + tipo + ": $" + registrazioni.dammiTotalePerTipoPartecipante(tipo) + "\n******\n");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RegForm");
        frame.setTitle("Ciao amici");
        frame.setContentPane(new RegForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
