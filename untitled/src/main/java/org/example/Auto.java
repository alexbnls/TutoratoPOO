package org.example;

public class Auto {
    private String marca, modello, targa;
    private double serbatoio, kmLitro;

    public Auto(String marca, String modello, String targa, double serbatoio, double kmLitro) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.serbatoio = serbatoio;
        this.kmLitro = kmLitro;
    }

    public String getModello() {
        return this.modello;
    }

    public double getKm() {
        return this.kmLitro;
    }
}
