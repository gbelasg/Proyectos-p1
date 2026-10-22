package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;



class EnvioNacionalTest {


    private static final Logger LOG = Logger.getLogger(EnvioNacionalTest.class.getName());


    @Test
    void calcularPrecio() {
        EnvioNacional envioConDomicilio = new EnvioNacional("ENV001", "Juan Pérez", 5.0, "Medellín", true);
        assertEquals(19000.0, envioConDomicilio.calcularPrecio(), 0.001);


        EnvioNacional envioSinDomicilio = new EnvioNacional("ENV002", "Maria Gómez", 5.0, "Cali", false);
        assertEquals(16000.0, envioSinDomicilio.calcularPrecio(), 0.001);


    }

}
