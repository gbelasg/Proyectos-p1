package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Empresa empresa= new Empresa("Empresa", "2217");

        String menu = "SISTEMA DE GESTIÓN DE NOMINA\n\n" +
                "1. Registrar nuevo empleado\n" +
                "2. Mostrar todos los empleados\n" +
                "3. Buscar empleado por documento\n" +
                "4. Mostrar empleado con mayor salario neto\n" +
                "5. Calcular nómina total de la empresa\n" +
                "6. Mostrar resúmenes de pago (Records)\n" +
                "0. Salir\n" +
                "\n" +
                "Ingrese el número de la opción deseada: ";
        int opcion;
        do {
            opcion = leerEntero(menu);

            switch (opcion) {
                case 1:
                    registrarEmpleadoPlanta(empresa);
                    break;
                case 2:
                    registrarEmpleadoVentas(empresa);
                    break;
                case 3:
                    registrarEmpleadoTemporal(empresa);
                    break;
                case 4:
                    obtenerTodosLosEmpleados(empresa);
                    break;
                case 5:
                    buscarEmpleadoPorDocumento(empresa);
                break;
                case 6:
                    mostrarEmpleadoMayorSalario(empresa);
                    break;
                case 7:
                    mostrarNominaTotal(empresa);
                    break;
                case 8:
                    listarResumenesPago(empresa);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);
    }


    //Metodos menu
    private static void registrarEmpleadoPlanta(Empresa empresa) {
        try {
            String nombre = leerTexto("Nombre completo:");
            String documento = leerTexto("Documento de identidad:");
            int edad = leerEntero("Edad:");
            float salarioBase = leerFloat("Salario base:");
            CategoriaEmpleado categoria = seleccionarCategoria();
            float descuentoSalud = leerFloat("Descuento salud (%):");
            float descuentoPension = leerFloat("Descuento pensión (%):");

            String cargo = leerTexto("Cargo:");
            int horasExtra = leerEntero("Horas extra trabajadas:");
            float valorHoraExtra = leerFloat("Valor por hora extra:");
            float auxilioTransporte = leerFloat("Auxilio de transporte:");

            Empleado emp = new EmpleadoPlanta(nombre, documento, edad, salarioBase, categoria,
                    descuentoSalud, descuentoPension, cargo, horasExtra, valorHoraExtra, auxilioTransporte);

            String mensaje = empresa.agregarEmpleado(emp);
            JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (DatosInvalidosException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void registrarEmpleadoVentas(Empresa empresa) {
        try {
            String nombre = leerTexto("Nombre completo:");
            String documento = leerTexto("Documento de identidad:");
            int edad = leerEntero("Edad:");
            float salarioBase = leerFloat("Salario base:");
            CategoriaEmpleado categoria = seleccionarCategoria();
            float descuentoSalud = leerFloat("Descuento salud (%):");
            float descuentoPension = leerFloat("Descuento pensión (%):");

            float ventasTotales = leerFloat("Ventas totales del mes:");
            float porcentajeComision = leerFloat("Porcentaje de comisión (%):");

            Empleado emp = new EmpleadoVentas(nombre, documento, edad, salarioBase, categoria,
                    descuentoSalud, descuentoPension, ventasTotales, porcentajeComision);

            String mensaje = empresa.agregarEmpleado(emp);
            JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (DatosInvalidosException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void registrarEmpleadoTemporal(Empresa empresa) {
        try {
            String nombre = leerTexto("Nombre completo:");
            String documento = leerTexto("Documento de identidad:");
            int edad = leerEntero("Edad:");
            float salarioBase = leerFloat("Salario base:");
            CategoriaEmpleado categoria = seleccionarCategoria();
            float descuentoSalud = leerFloat("Descuento salud (%):");
            float descuentoPension = leerFloat("Descuento pensión (%):");

            int diasTrabajados = leerEntero("Días trabajados:");
            float valorDia = leerFloat("Valor por día:");

            Empleado empleado = new EmpleadoTemporal(nombre, documento, edad, salarioBase, categoria,
                    descuentoSalud, descuentoPension, diasTrabajados, valorDia);

            String mensaje = empresa.agregarEmpleado(empleado);
            JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (DatosInvalidosException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void obtenerTodosLosEmpleados(Empresa empresa) {
        List<Empleado> empleados = empresa.mostrarTodosLosEmpleados();
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }

        String mensaje = "LISTA DE EMPLEADOS\n\n";
        for (Empleado empleado : empleados) {
            mensaje += empresa.toString() + "\n--------\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
    private static void buscarEmpleadoPorDocumento(Empresa empresa) {
        try {
            String documento = leerTexto("Ingrese el documento a buscar:");

            Optional<Empleado> empleadoEncontrado = empresa.buscarEmpleadoPorDocumento(documento);

            if (empleadoEncontrado.isPresent()) {
                Empleado empleado = empleadoEncontrado.get();
                JOptionPane.showMessageDialog(null, "Empleado Encontrado:\n\n" + empleado.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el documento: " + documento);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    }
    private static void mostrarEmpleadoMayorSalario(Empresa empresa) {
        Empleado mayor = empresa.obtenerEmpleadoMayorSalarioNeto();
        if (mayor == null) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados en el sistema.");
        } else {
            String mensaje = mayor.toString() + "\n\nSalario Neto: $" + mayor.calcularSalarioNeto();
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    private static void mostrarNominaTotal(Empresa empresa) {
        float nominaTotal = empresa.calcularNominaTotal();
        String mensaje = "Nómina total a pagar por la empresa: $" + nominaTotal;
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void listarResumenesPago(Empresa empresa) {
        List<ResumenPago> resumenesPago = empresa.obtenerResumenesDePagp();
        if (resumenesPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay resúmenes de pago para generar.");
            return;
        }

        String mensaje = " RESÚMENES DE PAGO \n\n";
        for (ResumenPago resumenPago : resumenesPago) {
            mensaje += resumenesPago.toString() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }


    //  lecturas
    public static int leerEntero(String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }

    public static float leerFloat(String mensaje) {
        return Float.parseFloat(JOptionPane.showInputDialog(mensaje));
    }

    public static String leerTexto(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }
    public static CategoriaEmpleado seleccionarCategoria() {
        CategoriaEmpleado[] categorias = CategoriaEmpleado.values();
        return (CategoriaEmpleado) JOptionPane.showInputDialog(
                null,
                "Seleccione la categoría del empleado:",
                "Categoría",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categorias,
                categorias[0]
        );
    }


    }

