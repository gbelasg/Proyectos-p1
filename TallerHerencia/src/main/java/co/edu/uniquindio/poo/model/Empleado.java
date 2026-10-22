package co.edu.uniquindio.poo.model;

public  abstract class Empleado {

    protected String nombre;
    protected final String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }
    private static float validarSalario(float salario) {
        // float es primitivo: solo revisamos que sea mayor que cero.
        if (salario <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor que cero.");
        }
        return salario;
    }
    private static float validarDescuento(float descuento, String tipo) {
        // Escala de 0 a 100.
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException(
                    "El descuento de " + tipo + " debe estar entre 0 y 100%.");
        }
        return descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEmpleado categoria) {
        this.categoria = categoria;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    //Metodos requeridos

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria(){
        return salarioBase*categoria.getPorcentajeBonificacion();
    }

    public float calcularDescuentos(){
        return calcularSalarioBruto()*(descuentoSalud+descuentoPension);
    }
    public float calcularSalarioNeto(){
        return calcularSalarioBruto()+calcularBonificacionCategoria()-calcularDescuentos();
    }
    public abstract String getTipoEmpleado();


    public ResumenPago generarResumenPago() {
        return new ResumenPago(documento, nombre, getTipoEmpleado(),
                calcularSalarioBruto(), calcularDescuentos(), calcularSalarioNeto());
    }



    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", salarioBase=" + salarioBase +
                ", categoria=" + categoria +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                '}';
    }
}
