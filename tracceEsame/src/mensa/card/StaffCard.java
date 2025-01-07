package mensa.card;

public class StaffCard extends Card{
    private String department;
    private double spentAmount;
    private String category;

    public StaffCard(int codice, String nome, String cognome, String department, double spentAmount, String category) {
        super(codice, nome, cognome);

        if(!category.equals("professor") && !category.equals("administrative"))
            throw new RuntimeException("Categoria errata");

        this.department = department;
        this.spentAmount = spentAmount;
        this.category = category;
    }

    public double pay()
    {
        double prezzo;
        if(category.equals("professor"))
            prezzo = 1.60;
        else
            prezzo = 4.00;

        spentAmount += prezzo;
        return prezzo;
    }

    public void changeCategory()
    {
        if(category.equals("professor"))
            category = "administrative";
        else
            category = "professor";
    }
}
