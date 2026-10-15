package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Envio;
import co.edu.uniquindio.poo.model.EnvioExpress;
import co.edu.uniquindio.poo.model.EnvioInternacional;
import co.edu.uniquindio.poo.model.EnvioNacional;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        List<Envio> envios= new ArrayList<>();

        envios.add(new EnvioNacional("N-001", "Maria Cardona", 8, "Cartagena", true));
        envios.add(new EnvioInternacional("I-002", "Valeria Jimenez", 4, "España", false));
        envios.add(new EnvioExpress("E-001", "Samuel Vargas", 10, "Medellin", true, 15));

        System.out.println("===LISTA ENVIOS===");
        double total=0;
        for (Envio envio: envios){
            System.out.println(envio);
            total+= envio.calcularPrecio();
        }
        System.out.println("COBRAR: $" +total);

    }
}
