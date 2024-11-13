package sample.pps_entrega3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EncuestaController {

    @FXML
    private CheckBox checkbox0;
    @FXML
    private CheckBox checkbox1;
    @FXML
    private CheckBox checkbox2;
    @FXML
    private CheckBox checkbox3;
    @FXML
    public CheckBox checkBox4;
    @FXML
    public CheckBox checkBox5;
    @FXML
    public CheckBox checkBox6;
    @FXML
    public CheckBox checkBox7;
    @FXML
    public CheckBox checkBox8;
    @FXML
    public CheckBox checkBox9;
    @FXML
    public CheckBox checkBox10;
    @FXML
    public CheckBox checkBox11;
    @FXML
    public CheckBox checkBox12;
    @FXML
    public CheckBox checkBox13;
    @FXML
    public CheckBox checkBox14;
    @FXML
    public CheckBox checkBox15;
    @FXML
    public CheckBox checkBox16;
    @FXML
    public CheckBox checkBox17;
    @FXML
    public CheckBox checkBox18;
    @FXML
    public CheckBox checkBox19;
    @FXML
    public CheckBox checkBox20;
    @FXML
    public CheckBox checkBox21;
    @FXML
    public CheckBox checkBox22;
    @FXML
    public CheckBox checkBox23;
    @FXML
    public CheckBox checkBox24;
    @FXML
    public CheckBox checkBox25;
    @FXML
    public CheckBox checkBox26;
    @FXML
    public CheckBox checkBox27;
    @FXML
    public CheckBox checkBox28;
    @FXML
    public CheckBox checkBox29;
    @FXML
    public CheckBox checkBox30;
    @FXML
    public CheckBox checkBox31;
    @FXML
    public CheckBox checkBox32;
    @FXML
    public CheckBox checkBox33;
    @FXML
    public CheckBox checkBox34;
    @FXML
    public CheckBox checkBox35;
    @FXML
    public CheckBox checkBox36;
    @FXML
    public CheckBox checkBox37;
    @FXML
    public CheckBox checkBox38;
    @FXML
    public CheckBox checkBox39;
    @FXML
    public CheckBox checkBox40;
    @FXML
    public CheckBox checkBox41;
    @FXML
    public CheckBox checkBox42;
    @FXML
    public CheckBox checkBox43;
    @FXML
    public CheckBox checkBox44;
    @FXML
    public CheckBox checkBox45;
    @FXML
    public CheckBox checkBox46;
    @FXML
    public CheckBox checkBox47;
    @FXML
    public CheckBox checkBox48;
    @FXML
    public CheckBox checkBox49;
    @FXML
    public CheckBox checkBox50;
    @FXML
    public CheckBox checkBox51;
    @FXML
    public CheckBox checkBox52;
    @FXML
    public CheckBox checkBox53;
    @FXML
    public CheckBox checkBox54;
    @FXML
    public CheckBox checkBox55;
    @FXML
    public CheckBox checkBox56;
    @FXML
    public CheckBox checkBox57;
    @FXML
    public CheckBox checkBox58;
    @FXML
    public CheckBox checkBox59;
    @FXML
    public CheckBox checkBox60;
    @FXML
    public CheckBox checkBox61;
    @FXML
    public CheckBox checkBox62;
    @FXML
    public CheckBox checkBox63;
    @FXML
    public CheckBox checkBox64;
    @FXML
    public CheckBox checkBox65;
    @FXML
    public CheckBox checkBox66;
    @FXML
    public CheckBox checkBox67;
    @FXML
    public CheckBox checkBox68;
    @FXML
    public CheckBox checkBox69;
    @FXML
    public CheckBox checkBox70;
    @FXML
    public CheckBox checkBox71;
    @FXML
    public CheckBox checkBox72;
    @FXML
    public CheckBox checkBox73;
    @FXML
    public CheckBox checkBox74;
    @FXML
    public CheckBox checkBox75;
    @FXML
    public CheckBox checkBox76;
    @FXML
    public CheckBox checkBox77;
    @FXML
    public CheckBox checkBox78;
    @FXML
    public CheckBox checkBox79;
    @FXML
    public CheckBox checkBox80;
    @FXML
    public CheckBox checkBox81;

    private CheckBox[] checkBoxes;

    @FXML
    private Button sendButton;

    @FXML
    public void initialize() {
        checkBoxes = new CheckBox[]{
                checkbox0, checkbox1, checkbox2, checkbox3,
                checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9,
                checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15,
                checkBox16, checkBox17, checkBox18, checkBox19, checkBox20, checkBox21,
                checkBox22, checkBox23, checkBox24, checkBox25, checkBox26, checkBox27,
                checkBox28, checkBox29, checkBox30, checkBox31, checkBox32, checkBox33,
                checkBox34, checkBox35, checkBox36, checkBox37, checkBox38, checkBox39,
                checkBox40, checkBox41, checkBox42, checkBox43, checkBox44, checkBox45,
                checkBox46, checkBox47, checkBox48, checkBox49, checkBox50, checkBox51,
                checkBox52, checkBox53, checkBox54, checkBox55, checkBox56, checkBox57,
                checkBox58, checkBox59, checkBox60, checkBox61, checkBox62, checkBox63,
                checkBox64, checkBox65, checkBox66, checkBox67, checkBox68, checkBox69,
                checkBox70, checkBox71, checkBox72, checkBox73, checkBox74, checkBox75,
                checkBox76, checkBox77, checkBox78, checkBox79, checkBox80, checkBox81
        };
    }

    @FXML
    private void handleSendButtonAction(ActionEvent event) {
        try {
            int score = calculateScore();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/pps_entrega3/resultado.fxml"));
            Parent root = loader.load();

            ResultadoController resultadoController = loader.getController();
            resultadoController.setScore(score);

            Stage stage = (Stage) sendButton.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculateScore() {
        int totalScore = 0;
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                totalScore += Integer.parseInt(checkBox.getUserData().toString());
            }
        }
        return totalScore;
    }
}
