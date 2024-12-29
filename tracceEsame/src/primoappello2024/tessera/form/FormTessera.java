package primoappello2024.tessera.form;

import primoappello2024.tessera.ListaPienaException;
import primoappello2024.tessera.TesseraSportiva;
import primoappello2024.tessera.TicketNonUsabileException;
import primoappello2024.tickets.TicketSingolo;
import primoappello2024.tickets.TicketSportivo;
import primoappello2024.tickets.TicketTorneo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.Random;

public class FormTessera {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton ottieniTesseraButton;
    private JButton salvaSuFileButton;
    private JButton usaBigliettiRandomButton;
    private TesseraSportiva tesseraSportiva;
    private static final File file = new File("tickets.dat");

    public void readFile() throws IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        while (true) {
            try {
                TicketSportivo ticketSportivo = (TicketSportivo) in.readObject();
                tesseraSportiva.addTicket(ticketSportivo);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            } catch (ListaPienaException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public FormTessera() throws IOException, ListaPienaException, TicketNonUsabileException {
        tesseraSportiva = new TesseraSportiva("Paris2024");
        if (!file.exists()) {
            TicketSportivo t1 = new TicketSingolo("Calcio", "Siano", 20);
            TicketSportivo t2 = new TicketSingolo("Basket", "Siano", 10);
            TicketSportivo t3 = new TicketSingolo("Pallavolo", "Siano", 60);
            TicketSportivo t4 = new TicketSingolo("Nigga", "Siano", 0.5);
            TicketSportivo t5 = new TicketTorneo("DevOps", "Unisa", 50);

            tesseraSportiva.addTicket(t1);
            tesseraSportiva.addTicket(t2);
            tesseraSportiva.addTicket(t3);
            tesseraSportiva.addTicket(t4);
            tesseraSportiva.addTicket(t5);

        } else
            readFile();

        ottieniTesseraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                List<TicketSportivo> tickets = tesseraSportiva.getTickets();
                for(TicketSportivo ticketSportivo : tickets)
                {
                    textArea1.append(ticketSportivo.toString() + "\n");
                }
            }
        });
        salvaSuFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!tesseraSportiva.isUsabile()) {
                        file.delete();
                        throw new RuntimeException("fuck u non ci sono biglietti usabili");
                    }

                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                    List<TicketSportivo> tickets = tesseraSportiva.getTickets();
                    for(TicketSportivo ticketSportivo : tickets)
                        if(!ticketSportivo.isUsed())
                            out.writeObject(ticketSportivo);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        usaBigliettiRandomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                for (int i = 0; i < 1; i++) {
                    int indexT = random.nextInt(5);
                    try {
                        tesseraSportiva.utilizza(indexT);
                    } catch (TicketNonUsabileException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws ListaPienaException, TicketNonUsabileException, IOException {
        JFrame frame = new JFrame("FormTessera");
        frame.setContentPane(new FormTessera().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
