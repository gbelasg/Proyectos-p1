package co.edu.uniquindio.poo.model;

/**
 * Se crea una excepcion propia para:
 * identificar el error pertinente a las reglas del sistema
 * Capturar los errores sin interferir con otros del sistema
 * La clase Exception es perteneciente a java
 */

public class DatosInvalidosException extends IllegalArgumentException{

    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
