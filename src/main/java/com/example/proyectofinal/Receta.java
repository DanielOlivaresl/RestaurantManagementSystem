package com.example.proyectofinal;

public interface Receta{

    public default void mostrarInfo(){
        System.out.println("No hay informacion que mostrar");
    }



    public void preparar();



}
