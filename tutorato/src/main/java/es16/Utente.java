package es16;

public class Utente {
    private String id;
    private String nome;
    private String email;


    public Utente(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
