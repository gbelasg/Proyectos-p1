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
        // Validaciones: estas deben ir dentro del constructor, ademas para una mejor practicidad
        if (horasExtra < 0) {
            throw new DatosInvalidosException("Las horas extra no pueden ser negativas.");
        }
        if (valorHoraExtra < 0) {
            throw new DatosInvalidosException("El valor de la hora extra no puede ser negativo.");
        }

        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;


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

    //Metodos

    @Override
    public float calcularSalarioBruto() {
        float pagarHorasExtra= horasExtra*valorHoraExtra;
        return salarioBase+calcularBonificacionCategoria()+pagarHorasExtra+auxilioTransporte;
    }
    @Override
    public String getTipoEmpleado() {
        return "Planta";
    }

    @Override
    public String toString() {
        return "EmpleadoPlanta{" +
                "cargo='" + cargo + '\'' +
                ", horasExtra=" + horasExtra +
                ", valorHoraExtra=" + valorHoraExtra +
                ", auxilioTransporte=" + auxilioTransporte +
                '}';
    }
}
