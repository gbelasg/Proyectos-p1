package co.edu.uniquindio.poo.model;

public enum CategoriaEmpleado {
    JUNIOR(0.05f), //f indica que es de tipo float
    SEMI_SENIOR(0.10f),
    SENIOR (0.15f);

    private final float porcentajeBonificacion;

    CategoriaEmpleado(float porcentajeBonificacion) {
        this.porcentajeBonificacion = porcentajeBonificacion;
    }



    public float getPorcentajeBonificacion() {
        return porcentajeBonificacion;
    }
}
