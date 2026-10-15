package co.edu.uniquindio.poo.model;

public class EnvioExpress extends EnvioNacional{
    private static final double REGARGO= 0.30;
    private static final double HORARIO= 5000;

           private int horasDeEntrega;

    public EnvioExpress(String codigo, String destinatario, double pesoKg, String destino, boolean domicilio, int horasDeEntrega) {
        super(codigo, destinatario, pesoKg, destino, domicilio);
        this.horasDeEntrega = horasDeEntrega;
    }

    public int getHorasDeEntrega() {
        return horasDeEntrega;
    }

    @Override
    public double calcularPrecio() {
        double costo= super.calcularPrecio() *(1+REGARGO);
        if (horasDeEntrega<=24){
            costo+=HORARIO;
        }
        return costo;
    }
}
