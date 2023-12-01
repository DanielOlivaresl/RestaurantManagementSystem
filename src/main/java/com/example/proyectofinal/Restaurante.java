package com.example.proyectofinal;

import java.lang.reflect.Array;
import java.util.*;

public class Restaurante {
    private String nombre;
    private String ubicacion;
    private double calificacion;
    private List<Pedido> pedidos;

    private List<Receta> recetas;

    private Map<String,Cliente> clientes;




    public Restaurante(String restaurate, String ubicacion, double calificacion,List<Pedido> pedidos,List<Receta> recetas){
            this.nombre =restaurate;
            this.ubicacion=ubicacion;
            this.calificacion=calificacion;
            this.pedidos= pedidos;
            this.recetas= recetas;
            this.clientes=new HashMap<>();
    }

    public Restaurante() {

    }


    public void agregarPedido(Pedido pedido){

        this.pedidos.add(pedido);
    }

    public void agregarReceta(Receta receta){
        this.recetas.add(receta);
    }


    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }

    public List<Receta> getRecetas() {
        return new ArrayList<>(recetas);
    }



    public HashMap<String, Cliente> getClientes(){
        return new HashMap<String,Cliente>(this.clientes);
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setClientes(Map<String,Cliente> clientes){
        this.clientes=clientes;
    }

    @Override
    public String toString() {
        return """
                Nombre: %s 
                Ubicacion: %s
                Calificacion: %f 
                """.formatted(this.nombre,this.ubicacion,this.calificacion);
    }


    public void sortList(){
        Comparator<Receta>comp= new Comparator<>(){
            

            @Override
            public int compare(Receta o1,Receta o2){
                if(o1.getClass().equals(o2.getClass())){
                    return 0;
                }
                if(o1 instanceof Comida){
                    return -1;
                }

                if((o1 instanceof Bebida) && !(o2 instanceof  Comida)){
                    return -1;
                }

                return 1;
            }
        };
        this.recetas.sort(comp);
    }



    public void addCliente(Cliente cliente){
        if(cliente==null){
            String message="No se pudo agregar el cliente";
        }else{
            this.clientes.put(new String(cliente.telefono),cliente);

        }

    }


}



