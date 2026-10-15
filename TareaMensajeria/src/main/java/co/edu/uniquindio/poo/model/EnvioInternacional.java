package co.edu.uniquindio.poo.model;

public class EnvioInternacional extends Envio{

    private static final double COSTO_FIJO= 15000;
    private static final double COSTO_KG= 9000;
    private static final double SEGURO= 20000;

    private String paisDestino;
    private boolean necesitaSeguro;

    public EnvioInternacional(String codigo, String destinatario, double pesoKg, String paisDestino, boolean necesitaSeguro) {
        super(codigo, destinatario, pesoKg);
        this.paisDestino = paisDestino;
        this.necesitaSeguro = necesitaSeguro;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public boolean isNecesitaSeguro() {
        return necesitaSeguro;
    }

    @Override
    public double calcularPrecio() {
        double costo= COSTO_FIJO+(COSTO_KG*getPesoKg());
        if (necesitaSeguro){
            costo+= SEGURO;
        }
        return costo;
    }
}
