package com.example.proyectofinal;

public class Repartidor extends Persona {
    private static int numRepartidores;
    private int idRepartidor;
    private String medioTransporte;
    private double tiempoEstimadoEntrega;

    private double scoreEficiencia;


    public Repartidor(String name, String medioTransporte, double tiempoEstimadoEntrega, double scoreEficiencia) {
        super(name);
        this.medioTransporte = medioTransporte;
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
        this.scoreEficiencia = scoreEficiencia;
        this.idRepartidor=numRepartidores++;
    }

        public String getMedioTransporte() {
            return medioTransporte;
        }


    public static int getNumRepartidores() {
        return numRepartidores;
    }

    public static void setNumRepartidores(int numRepartidores) {
        Repartidor.numRepartidores = numRepartidores;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public double getTiempoEstimadoEntrega() {
        return tiempoEstimadoEntrega;
    }

    public void setTiempoEstimadoEntrega(double tiempoEstimadoEntrega) {
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
    }

    public double getScoreEficiencia() {
        return scoreEficiencia;
    }

    public void setScoreEficiencia(double scoreEficiencia) {
        this.scoreEficiencia = scoreEficiencia;
    }

    @Override
    public String toString() {
        return """
                Name: %s
                Id: %d
                Medio Transporte: %s
                Tiempo de Entrega: %f
                Eficiencia: %f
                """.formatted(nombre,idRepartidor,medioTransporte,tiempoEstimadoEntrega,scoreEficiencia);
    }

    @Override
    public void displayInfo() {
        System.out.print(this);
    }
}
