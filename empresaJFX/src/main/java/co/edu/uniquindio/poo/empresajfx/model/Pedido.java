package co.edu.uniquindio.poo.empresajfx.model;

import java.time.LocalDate;
import java.util.Optional;

public class Pedido {
    private String idPedido;
    private LocalDate fechaSolicitud;
    private String estado; // ej. "Pendiente", "Enviado", "Entregado"
    private Cliente cliente;

    public Pedido(String idPedido, LocalDate fechaSolicitud, String estado, Cliente cliente) {
        this.idPedido = idPedido;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.cliente = cliente;
    }

    public String getIdPedido() { return idPedido; }
    public void setIdPedido(String idPedido) { this.idPedido = idPedido; }

    public LocalDate getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDate fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getNombreCliente() {
        return Optional.ofNullable(cliente)
                .map(c -> c.getNombre() + " " + c.getApellido())
                .orElse("Sin cliente");
    }
}

