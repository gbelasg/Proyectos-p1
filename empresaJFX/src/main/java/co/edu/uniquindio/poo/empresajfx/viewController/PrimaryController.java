package co.edu.uniquindio.poo.empresajfx.viewController;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.empresajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button primaryButton;

    @FXML
    private Button btnOpenCrudPedido;

    private App app;

    @FXML
    void onOpenCrudCliente() {
        app.openCrudCliente();
    }

    @FXML
    void onOpenCrudPedido() {
        app.openCrudPedido();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
    }
}




