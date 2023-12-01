package com.example.proyectofinal;

public class Bebida implements Receta{

    private String nombre;
    private boolean alcholica;
    private double cantidad;
    private double precio;


    public Bebida(String nombre, boolean alcholica, double cantidad, double precio) {
        this.nombre = nombre;
        this.alcholica = alcholica;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlcholica() {
        return alcholica;
    }

    public void setAlcholica(boolean alcholica) {
        this.alcholica = alcholica;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        String esAlcholica;
        if(alcholica){
            esAlcholica="si";
        }else{
            esAlcholica="no";
        }




        return """

                Nombre: %s
                Alcholica: %s
                Cantidad: %f
                Precio: %f
                """.formatted(nombre,esAlcholica,cantidad,precio);
    }


    @Override
    public void mostrarInfo() {
        System.out.print(this);
    }

    @Override
    public void preparar() {
        System.out.println("Preparando "+ nombre+ "por un costo de "+precio);
    }
}
