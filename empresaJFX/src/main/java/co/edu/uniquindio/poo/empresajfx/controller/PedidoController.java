package co.edu.uniquindio.poo.empresajfx.controller;

import co.edu.uniquindio.poo.empresajfx.model.Cliente;
import co.edu.uniquindio.poo.empresajfx.model.Empresa;
import co.edu.uniquindio.poo.empresajfx.model.Pedido;

import java.util.Collection;
import java.util.LinkedList;

public class PedidoController {

    // 1. IMPORTANTE: Declarar el atributo 'empresa'
    private Empresa empresa;

    // 2. IMPORTANTE: Recibirlo en el constructor y asignarlo
    public PedidoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearPedido(Pedido pedido) {
        return empresa.agregarPedido(pedido);
    }

    public Collection<Pedido> obtenerListaPedidos() {
        return empresa.getPedidos();
    }

    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }

    public boolean eliminarPedido(String idPedido) {
        return empresa.eliminarPedido(idPedido);
    }

    public boolean actualizarPedido(String idPedido, Pedido pedido) {
        return empresa.actualizarPedido(idPedido, pedido);
    }
}
