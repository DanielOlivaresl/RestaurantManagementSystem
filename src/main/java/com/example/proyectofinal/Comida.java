package com.example.proyectofinal;

public class Comida implements Receta{

    private double costo;
    private String nombre;
    private String origen;


    public Comida(double costo, String nombre, String origen){
        this.costo=costo;
        this.nombre=nombre;
        this.origen=origen;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return """

                Costo: %f
                Nombre: %s
                Origen: %s
                """.formatted(costo,nombre,origen);
    }




    @Override
    public void mostrarInfo() {
        System.out.print(this);
    }

    @Override
    public void preparar() {
        System.out.println("Preparando "+ nombre + "tendra un costo de "+costo+ "$");
    }
}
