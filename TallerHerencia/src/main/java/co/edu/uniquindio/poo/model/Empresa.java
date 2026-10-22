package co.edu.uniquindio.poo.model;

import java.util.*;

public class Empresa {
    private String nombreEmpresa;
    private String nit;
    private final ArrayList<Empleado>empleados= new ArrayList<>();

    public Empresa(String nombreEmpresa, String nit) {
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        //Validaciones

    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    //Metodos

    public String agregarEmpleado(Empleado nuevoEmpleado) {
        if (nuevoEmpleado == null) {
            throw new DatosInvalidosException("El empleado no puede ser nulo.");
        }

        Optional<Empleado> empleadoEncontrado = buscarEmpleadoPorDocumento(nuevoEmpleado.getDocumento());

        if (empleadoEncontrado.isPresent()) {
            throw new DatosInvalidosException("Ya existe un empleado registrado con el documento: " + nuevoEmpleado.getDocumento());
        }

        empleados.add(nuevoEmpleado);
        return "El empleado ha sido registrado exitosamente";
    }
    public Optional<Empleado> buscarEmpleadoPorDocumento(String documento) {
        return empleados.stream()
                .filter(empleado -> empleado.getDocumento().equals(documento))
                .findFirst();
    }
    public List<Empleado> mostrarTodosLosEmpleados(){
        return this.empleados;
    }
    public Empleado obtenerEmpleadoMayorSalarioNeto(){
        return  empleados.stream().max(Comparator.comparingDouble(
                Empleado::calcularSalarioNeto)).orElse(null);
    }
    public float calcularNominaTotal(){
        return (float) empleados.stream().mapToDouble(  //mapToDouble tranforma metodos de una lista en un valor double, en este caso al pasar por cada empleado de la lista ejecuta el metodo transformando en una lista decimal
                Empleado::calcularSalarioNeto).sum();
    }
    public List<ResumenPago> obtenerResumenesDePagp(){
        return empleados.stream().map(Empleado::generarResumenPago).toList();
        //map transforma la lista manteniendo la cantidad de elemento
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "nombreEmpresa='" + nombreEmpresa + '\'' +
                ", nit='" + nit + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}





