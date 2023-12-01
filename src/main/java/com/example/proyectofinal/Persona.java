package com.example.proyectofinal;

abstract public class Persona {
    protected String nombre;
    protected char[] telefono;


    public Persona(String name){
        this.nombre =name;
        this.telefono= new char[10];
    }


    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTelefono(){
        return new String(telefono);
    }

    public void setTelefono(String telefono){
        if(telefono.length()>10){
            System.out.println("Invalid");
        }else{
            this.telefono=telefono.toCharArray();
        }
    }



    public abstract void displayInfo();


}
