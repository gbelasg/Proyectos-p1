package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        EmpresaEnvios empresaEnvios= new EmpresaEnvios("Envios UQ");

         EnvioNacional envio= new EnvioNacional("N-001", "Maria Cardona", 8, "Cartagena", true);
         EnvioInternacional envio2= new EnvioInternacional("I-002", "Valeria Jimenez", 4, "España", false);
        EnvioExpress envio3= new EnvioExpress("E-001", "Samuel Vargas", 10, "Medellin", true, 15);

        System.out.println("===LISTA ENVIOS===");

    }
}
