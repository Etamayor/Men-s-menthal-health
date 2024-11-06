package sample.pps_entrega3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class SignupController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private javafx.scene.control.CheckBox rememberMeCheckbox;

    @FXML
    private javafx.scene.control.Button signUpButton;

    @FXML
    private javafx.scene.control.Button loginButton;

    @FXML
    private void handleSignUp() throws IOException {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("Todos los campos deben estar llenos.");
            return;
        }

        String encryptedData;
        try {
            encryptedData = encryptData(username, email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Files.write(Paths.get("userdata.enc"), encryptedData.getBytes(StandardCharsets.UTF_8));

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/pps_entrega3/Encuesta.fxml"));
            Parent surveyRoot = loader.load();

            Stage stage = (Stage) signUpButton.getScene().getWindow();
            stage.setScene(new Scene(surveyRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo cargar el archivo de la encuesta.");
            // Puedes mostrar un alerta al usuario si el archivo no se carga.
        }
    }

    @FXML
    private void handleLogin() {
        // Aquí puedes manejar la lógica de inicio de sesión
        System.out.println("Login button pressed");

        // Puedes redireccionar a una nueva escena si lo deseas
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/pps_entrega3/Login.fxml"));
            Parent loginRoot = loader.load();

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(loginRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para encriptar los datos
    private String encryptData(String username, String email, String password) throws Exception {
        String key = "Bar12345Bar12345"; // 128 bit key (debería ser gestionada y almacenada de manera segura)
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        String data = "username=" + username + "&email=" + email + "&password=" + password;
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
