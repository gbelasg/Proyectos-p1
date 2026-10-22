package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado {

    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
        //Validaciones

        if (diasTrabajados < 0) {
            throw new DatosInvalidosException("Los días trabajados no pueden ser negativos.");
        }
        if (valorDia < 0) {
            throw new DatosInvalidosException("El valor del día no puede ser negativo.");
        }

        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    private static int validarDiasTrabajados(int dias) {
        // Supuesto: un mes tiene máximo 31 días. No puede ser negativo.
        if (dias < 0 || dias > 31) {
            throw new IllegalArgumentException("Los días trabajados deben estar entre 0 y 31.");
        }
        return dias;
    }
    private static float validarValorDia(float valorDia) {
        if (valorDia < 0) {
            throw new IllegalArgumentException("El valor del día no puede ser negativo.");
        }
        return valorDia;
    }



    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

    //Metodos

    public float calcularPagoDias(){
        return diasTrabajados*valorDia;
    }

    @Override
    public float calcularSalarioBruto() {
        return calcularPagoDias()+calcularBonificacionCategoria();
    }
    @Override
    public String getTipoEmpleado() {
        return "Temporal";
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal{" +
                "diasTrabajados=" + diasTrabajados +
                ", valorDia=" + valorDia +
                '}';
    }
}
