package co.edu.uniquindio.poo.model;

import java.util.*;

public class Empresa {
    private final ArrayList<Empleado>empleados= new ArrayList<>();

    public boolean existe(String documento) {
        return buscarPorDocumento(documento).isPresent();
    }

    public void agregar (Empleado empleado){
        Objects.requireNonNull(empleado, "El empleado no puede estar vacio");
        if (existe(empleado.getDocumento())){
            throw new IllegalArgumentException("Ya existe un emplecado con este documento" +empleado.getDocumento());
        }
        empleados.add(empleado);
    }
    public void registrarEmpleadoPlanta(String nombre, String documento, int edad, float salarioBase,
                                        CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension,
                                        String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {
        agregar(new EmpleadoPlanta(nombre, documento, edad, salarioBase, categoria,
                descuentoSalud, descuentoPension, cargo, horasExtra, valorHoraExtra, auxilioTransporte));
    }

    public void registrarEmpleadoVentas(String nombre, String documento, int edad, float salarioBase,
                                        CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension,
                                        float totalVentas, float porcentajeComision) {
        agregar(new EmpleadoVentas(nombre, documento, edad, salarioBase, categoria,
                descuentoSalud, descuentoPension, totalVentas, porcentajeComision));
    }

    public void registrarEmpleadoTemporal(String nombre, String documento, int edad, float salarioBase,
                                          CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension,
                                          int diasTrabajados, float valorDia) {
        agregar(new EmpleadoTemporal(nombre, documento, edad, salarioBase, categoria,
                descuentoSalud, descuentoPension, diasTrabajados, valorDia));
    }
    //Lista
    public List<Empleado>listaCompleta(){
        return List.copyOf(empleados);
    }
    //Mostrar la lista
    public void mostrarTodos() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();   // polimorfismo: cada tipo muestra sus propios datos
            System.out.println();
        }
    }
    public Optional<Empleado> buscarPorDocumento(String documento) {
        return empleados.stream()
                .filter(e -> e.getDocumento().equals(documento))
                .findFirst();
    }

    //empleado con mayor salario
    public Optional<Empleado> empleadoMayorSalario(){
        return empleados.stream().max(Comparator.comparingDouble(Empleado::calcularSalarioNeto));
    }
    //NOMINA
    public float calcularNomina(){
        float total=0;
        for (Empleado empleado: empleados){
            total+= empleado.calcularSalarioNeto();
        }
        return total;
    }




}
