package co.edu.uniquindio.poo.empresajfx.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Cliente> clientes;
    private Collection<Pedido> pedidos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.clientes = new LinkedList<>();
        this.pedidos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Collection<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }


    public boolean agregarPedido(Pedido pedido) {
        if (!verificarPedido(pedido.getIdPedido())) {
            pedidos.add(pedido);
            return true;
        }
        return false;
    }

    public boolean eliminarPedido(String idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido)) {
                pedidos.remove(pedido);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarPedido(String idPedido, Pedido actualizado) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido)) {
                pedido.setIdPedido(actualizado.getIdPedido());
                pedido.setFechaSolicitud(actualizado.getFechaSolicitud());
                pedido.setEstado(actualizado.getEstado());
                pedido.setCliente(actualizado.getCliente());
                return true;
            }
        }
        return false;
    }

    public boolean verificarPedido(String idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido)) {
                return true;
            }
        }
        return false;
    }
}


