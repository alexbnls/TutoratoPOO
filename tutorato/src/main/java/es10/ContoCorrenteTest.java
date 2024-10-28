package es10;

public class ContoCorrenteTest {
    public static void main(String[] args)
    {
        ContoCorrente contoCorrente = new ContoCorrente("Mario Rossi", 200);
        contoCorrente.preleva(200);
        System.out.println(contoCorrente.restituisciSaldo());
    }
}
