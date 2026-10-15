package co.edu.uniquindio.poo.model;

public class EmpleadoPlanta extends Empleado{
    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    private static int validarHorasExtra(int horas) {
        // No se permiten horas extra negativas.
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas.");
        }
        return horas;
    }

    private static float validarMontoNoNegativo(float monto, String campo) {
        // Sirve para el valor de la hora extra y el auxilio de transporte.
        if (monto < 0) {
            throw new IllegalArgumentException("El " + campo + " no puede ser negativo.");
        }
        return monto;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public float getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(float valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public float getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(float auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public float calcularSalarioBruto() {
        float pagarHorasExtra= horasExtra*valorHoraExtra;
        return salarioBase+calcularBonificacionCategoria()+pagarHorasExtra+auxilioTransporte;
    }
    @Override
    public String getTipoEmpleado() {
        return "Planta";
    }

}
