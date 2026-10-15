package co.edu.uniquindio.poo.model;

public class EmpleadoVentas extends Empleado {
     private float totalVentas;
     private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }
    private static float validarPorcentajeComision(float porcentaje) {
        // Porcentaje entre 0 y 100.
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje de comisión debe estar entre 0 y 100 (ej: 3 = 3%).");
        }
        return porcentaje;
    }




    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }
    public float calcularComision(){
        return (totalVentas*porcentajeComision)/100;
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBase+calcularBonificacionCategoria()+calcularComision();
    }
    @Override
    public String getTipoEmpleado() {
        return "Ventas";
    }

}
