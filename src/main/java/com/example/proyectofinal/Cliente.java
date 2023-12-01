package com.example.proyectofinal;

public class Cliente extends Persona{

    private String domicilio;
    private String  metodoPago;


    public Cliente(String name, String domicilio, String metodoPago) {
        super(name);
        this.domicilio= domicilio;
        this.metodoPago=metodoPago;
    }


    public String getDomicilio() {
        return domicilio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }


    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return """
                --Cliente--
                Nombre: %s
                Domicilio: %s
                Metodo de Pago: %s
                
                """.formatted(nombre, domicilio,metodoPago);


    }

    @Override
    public void displayInfo() {
            System.out.print(this);
    }
}
