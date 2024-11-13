package sample.pps_entrega3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleSignUp() {
        // Aquí puedes manejar la lógica de registro o cambiar de escena a una vista de registro.
        loadScene("/sample/pps_entrega3/Signup.fxml");  // Asegúrate de tener un archivo Signup.fxml si es necesario
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Campos Vacíos", "Todos los campos deben estar llenos.");
            return;
        }

        boolean loginSuccessful = false;

        try {
            List<String> userData = Files.readAllLines(Paths.get("userdata.txt"));
            for (String line : userData) {
                String[] parts = line.split("&");
                String storedUsername = parts[0].split("=")[1];
                String storedPassword = parts[2].split("=")[1];

                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    loginSuccessful = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "No se pudo leer el archivo de usuarios.");
            return;
        }

        if (loginSuccessful) {
            loadScene("/sample/pps_entrega3/Encuesta.fxml");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error de Login", "El nombre de usuario o la contraseña no son correctos.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error de Carga", "No se pudo cargar la escena.");
        }
    }
}
