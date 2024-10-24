package sample.pps_entrega3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField emailOrUsernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private CheckBox rememberMeCheckbox;

    @FXML
    private Text forgotPasswordText;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    public void initialize() {}
}
