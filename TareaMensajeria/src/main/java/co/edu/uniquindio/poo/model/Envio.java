package co.edu.uniquindio.poo.model;

import java.util.Optional;

public abstract class  Envio {
    private String codigo;
    protected String destinatario;
    protected double pesoKg;
    private EmpresaEnvios ownedByEmpresa;

    public Envio(String codigo, String destinatario, double pesoKg) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.pesoKg = pesoKg;
        this.ownedByEmpresa= ownedByEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public EmpresaEnvios getOwnedByEmpresa() {
        return ownedByEmpresa;
    }

    public void setOwnedByEmpresa(EmpresaEnvios ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public abstract double calcularPrecio();



    @Override
    public String toString() {
        return "Envio{" +
                "codigo='" + codigo + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", pesoKg=" + pesoKg +
                '}';
    }
}
