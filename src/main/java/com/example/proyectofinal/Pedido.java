package com.example.proyectofinal;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private int numeroPedido;
    private Repartidor repartidor;
    private Cliente cliente;
    private static int cuentaPedidos=0;
    private Map <Receta, Integer> cantPorPlatillo;

    public Pedido(Cliente cliente, Repartidor repartidor){
        this.cliente=cliente;
        this.numeroPedido= cuentaPedidos++;
        this.repartidor=repartidor;
        this.cantPorPlatillo= new HashMap<>();
    }


    public HashMap<Receta,Integer> getCantPorPlatillo(){
        return new HashMap<>(this.cantPorPlatillo);
    }


    public Repartidor getRepartidor(){
        return this.repartidor;
    }

    public void agregarPlatillo(Receta platillo){
        if(!cantPorPlatillo.containsKey(platillo)){
            cantPorPlatillo.put(platillo,1);
        }else{
            cantPorPlatillo.put(platillo,cantPorPlatillo.get(platillo)+1);
        }
    }

    @Override
    public String toString() {
        return """
                -Pedido-
                
                Numero Pedido: %d
               
                
                -Informacion Pedido-
                %s
                
                -Informacion Repartidor-
                %s
                """.formatted(numeroPedido, cliente,repartidor);
    }

    public void mostrarInfo(){
        System.out.print(this);
    }

}
