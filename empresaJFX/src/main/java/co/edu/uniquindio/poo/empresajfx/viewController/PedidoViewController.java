package co.edu.uniquindio.poo.empresajfx.viewController;

import co.edu.uniquindio.poo.empresajfx.App;
import co.edu.uniquindio.poo.empresajfx.controller.PedidoController;
import co.edu.uniquindio.poo.empresajfx.model.Cliente;
import co.edu.uniquindio.poo.empresajfx.model.Pedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.time.LocalDate;

public class PedidoViewController {
    private PedidoController pedidoController;
    private ObservableList<Pedido> listPedidos = FXCollections.observableArrayList();
    private ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    private Pedido selectedPedido;
    private App app;

    @FXML
    private TextField txtIdPedido;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private ComboBox<String> cbEstado;
    @FXML
    private ComboBox<Cliente> cbCliente;
    @FXML
    private TableView<Pedido> tblListPedido;
    @FXML
    private TableColumn<Pedido, String> tbcIdPedido;
    @FXML
    private TableColumn<Pedido, String> tbcFecha;
    @FXML
    private TableColumn<Pedido, String> tbcEstado;
    @FXML
    private TableColumn<Pedido, String> tbcCliente;

    @FXML
    void onAgregarPedido() { agregarPedido(); }
    @FXML
    void onActualizarPedido() { actualizarPedido(); }
    @FXML
    void onLimpiar() { limpiarSeleccion(); }
    @FXML
    void onEliminar() { eliminarPedido(); }

    public void setApp(App app) {
        this.app = app;
        this.pedidoController = new PedidoController(app.empresa);
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerDatos();

        cbEstado.setItems(FXCollections.observableArrayList("Pendiente", "En Proceso", "Enviado", "Entregado"));

        tblListPedido.setItems(listPedidos);
        cbCliente.setItems(listClientes);

        cbCliente.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente != null ? cliente.getNombre() + " " + cliente.getApellido() : "";
            }

            @Override
            public Cliente fromString(String string) {
                return null;
            }
        });

        listenerSelection();
    }

    private void initDataBinding() {
        tbcIdPedido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdPedido()));
        tbcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaSolicitud().toString()));
        tbcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado()));
        tbcCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCliente()));
    }

    private void obtenerDatos() {
        listPedidos.clear();
        listClientes.clear();
        listPedidos.addAll(pedidoController.obtenerListaPedidos());
        listClientes.addAll(pedidoController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tblListPedido.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPedido = newSelection;
            mostrarInformacionPedido(selectedPedido);
        });
    }

    private void mostrarInformacionPedido(Pedido pedido) {
        if (pedido != null) {
            txtIdPedido.setText(pedido.getIdPedido());
            dpFecha.setValue(pedido.getFechaSolicitud());
            cbEstado.setValue(pedido.getEstado());
            cbCliente.setValue(pedido.getCliente());
        }
    }

    private void agregarPedido() {
        Pedido pedido = buildPedido();
        if (pedido != null && pedidoController.crearPedido(pedido)) {
            listPedidos.add(pedido);
            limpiarCampos();
        }
    }

    private Pedido buildPedido() {
        try {
            LocalDate fecha = dpFecha.getValue();
            String estado = cbEstado.getValue();
            Cliente cliente = cbCliente.getValue();
            if (txtIdPedido.getText().isEmpty() || fecha == null || estado == null || cliente == null) {
                return null;
            }
            return new Pedido(txtIdPedido.getText(), fecha, estado, cliente);
        } catch (Exception e) {
            return null;
        }
    }

    private void eliminarPedido() {
        if (selectedPedido != null && pedidoController.eliminarPedido(selectedPedido.getIdPedido())) {
            listPedidos.remove(selectedPedido);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    private void actualizarPedido() {
        Pedido actualizado = buildPedido();
        if (selectedPedido != null && actualizado != null &&
                pedidoController.actualizarPedido(selectedPedido.getIdPedido(), actualizado)) {
            int index = listPedidos.indexOf(selectedPedido);
            if (index >= 0) {
                listPedidos.set(index, actualizado);
            }
            tblListPedido.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    private void limpiarSeleccion() {
        tblListPedido.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtIdPedido.clear();
        dpFecha.setValue(null);
        cbEstado.setValue(null);
        cbCliente.setValue(null);
    }
}
