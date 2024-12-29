package automezzo2022;

public class HertzTest {
    public static void main(String[] args)
    {
        Automezzo automezzo1 = new Auto("Volvo", "boh", 90, "BL611ED");
        Automezzo automezzo2 = new Furgone("Citroen", "figo", 300, "AA000BB");
        Automezzo automezzo3 = new Moto("Honda","hornet", 70, "VG911AV");

        Hertz hertz = new Hertz();

        hertz.addMezzo(automezzo1);
        hertz.addMezzo(automezzo2);
        hertz.addMezzo(automezzo3);

        try{
            hertz.effettuaPrestito("VG911AV");
            hertz.effettuaPrestito("BL611ED");
            hertz.effettuaPrestito("AA000BB");
        } catch (PrestitoException e) {
            System.out.println(e);
        }
        System.out.println(hertz.dammiAutomezzoPerTarga("BL611ED"));

        try{
            System.out.println("Auto ricavo: " + hertz.effettuaReso("BL611ED"));
            System.out.println("Furgone ricavo: " + hertz.effettuaReso("AA000BB"));
            System.out.println("Moto ricavo: " + hertz.effettuaReso("VG911AV"));
        } catch (PrestitoException e)
        {
            System.out.println(e);
        }

    }

}
