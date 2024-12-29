package aeromobile2023;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaAeromobili {
    private List<Aeromobile> aeromobili;

    public ListaAeromobili()
    {
        aeromobili = new ArrayList<>();
    }

    public void addAeromobile(Aeromobile aeromobile) throws AeromobileException
    {
        for(Aeromobile aeromobile1: aeromobili)
            if(aeromobile1.equals(aeromobile))
                throw new AeromobileException("Aeromobile gia' presente");

        aeromobili.add(aeromobile);
    }

    public void salvaFile() throws IOException {
        File file = new File("aeromobili.dat");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, false));

        for(Aeromobile aeromobile: aeromobili)
            out.writeObject(aeromobile);

        out.close();
    }


    public List<Aeromobile> leggiFile() throws IOException {
        File file = new File("aeromobili.dat");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        List<Aeromobile> lista = new ArrayList<>();
        while(true)
        {
            try
            {
                Aeromobile aeromobile = (Aeromobile) in.readObject();
                lista.add(aeromobile);
            }
            catch (EOFException | ClassNotFoundException e)
            {
                in.close();
                break;
            }
        }
        return lista;
    }

    public List<Aeromobile> leggiFile(String tipo) throws IOException {
        File file = new File("aeromobili.dat");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        List<Aeromobile> lista = new ArrayList<>();
        while(true)
        {
            try
            {
                Aeromobile aeromobile = (Aeromobile) in.readObject();
                if(aeromobile.getClass().getSimpleName().equals(tipo))
                    lista.add(aeromobile);
            }
            catch (EOFException | ClassNotFoundException e)
            {
                in.close();
                break;
            }
        }
        return lista;
    }
}
