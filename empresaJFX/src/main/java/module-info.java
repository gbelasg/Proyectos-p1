module co.edu.uniquindio.poo.empresajfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.empresajfx to javafx.fxml;
    opens co.edu.uniquindio.poo.empresajfx.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.empresajfx.model to javafx.base;

    exports co.edu.uniquindio.poo.empresajfx;
    exports co.edu.uniquindio.poo.empresajfx.viewController;
}