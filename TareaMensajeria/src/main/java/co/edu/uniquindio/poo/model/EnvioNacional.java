package co.edu.uniquindio.poo.model;

import java.util.Objects;

public class EnvioNacional extends Envio{

    private static final double COSTO_FIJO= 6000;
    private static final double COSTO_KG= 2000;
    private static final double RECARGO= 3000;

    private String destino;
    private boolean domicilio;

    public EnvioNacional(String codigo, String destinatario, double pesoKg, String destino, boolean domicilio) {
        super(codigo, destinatario, pesoKg);
        this.destino = destino;
        this.domicilio = domicilio;
    }

    public String getDestino() {
        return destino;
    }

    public boolean isDomicilio() {
        return domicilio;
    }


    @Override
    public double calcularPrecio() {
        double costo= COSTO_FIJO +(COSTO_KG*getPesoKg());
        if (domicilio){
            costo+= RECARGO;
        }
        return costo;
    }
}
