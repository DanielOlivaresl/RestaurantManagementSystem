package com.example.proyectofinal;

public class Postre implements Receta{
    private String name;
    private String sabor;
    private int numRebanadas;
    private double calorias;

    public Postre(String name, String sabor, int numRebanadas, double calorias) {
        this.name = name;
        this.sabor = sabor;
        this.numRebanadas = numRebanadas;
        this.calorias = calorias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getNumRebanadas() {
        return numRebanadas;
    }

    public void setNumRebanadas(int numRebanadas) {
        this.numRebanadas = numRebanadas;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public void mostrarInfo() {
        Receta.super.mostrarInfo();
    }

    @Override
    public void preparar() {
        System.out.println("Preparando %s de sabor de %s que contiene un total de %f calorias".formatted(this.name,this.sabor, this.calorias));

    }

    @Override
    public String toString() {
        return """

                Nombre: %s
                Sabor: %s
                Numero de Rebanadas: %d
                Calorias: %f
                """.formatted(this.name,this.sabor,this.numRebanadas,this.calorias);


    }
}
