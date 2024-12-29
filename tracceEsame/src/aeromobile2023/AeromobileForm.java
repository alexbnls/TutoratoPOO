package aeromobile2023;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AeromobileForm {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JButton leggiFileButton;
    private JTextArea textArea1;
    private JTextField codiceVoloTextField;
    private JButton cercaTramiteCodiceButton;
    private ListaAeromobili aeromobili;
    public AeromobileForm() {
        aeromobili = new ListaAeromobili();
        JFrame frame = new JFrame("AeromobileForm");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setVisible(true);
        leggiFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                String tipo = (String) comboBox1.getSelectedItem();
                try {
                    List<Aeromobile> lista = aeromobili.leggiFile(tipo);
                    for(Aeromobile aeromobile: lista)
                        textArea1.append(aeromobile.toString()+"\n");
                    if(lista.isEmpty())
                        textArea1.append(tipo + " non presenti");

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        cercaTramiteCodiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                String codiceVolo = codiceVoloTextField.getText();
                boolean found = false;
                try {
                    List<Aeromobile> lista = aeromobili.leggiFile();
                    for(Aeromobile aeromobile: lista)
                    {
                        if(aeromobile.getClass().getSimpleName().equals("Aeroplano"))
                        {
                            Aeroplano aeroplano = (Aeroplano) aeromobile;
                            if(aeroplano.getCodiceVolo().equals(codiceVolo)) {
                                found = true;
                                textArea1.append(aeroplano.toString() + "\n");
                            }
                        }
                    }
                    if(!found) {
                        textArea1.setText("NON TROVATO");
                        throw new IllegalArgumentException("Codice invalido");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        AeromobileForm form = new AeromobileForm();
    }
}
