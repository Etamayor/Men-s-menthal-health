package sample.pps_entrega3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private void handleSignUp() throws IOException {
        // Correcta carga del archivo FXML desde el paquete sample/pps_entrega3
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/pps_entrega3/Signup.fxml"));
        if (loader.getLocation() == null) {
            throw new IllegalStateException("Location of Signup.fxml is not set or incorrect");
        }
        Parent signUpRoot = loader.load();

        // Obtener el Stage actual (la ventana) y cambiar la escena
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        stage.setScene(new Scene(signUpRoot));
        stage.show();
    }

    // Otros métodos del controlador
}
