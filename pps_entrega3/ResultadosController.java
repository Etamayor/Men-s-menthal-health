package sample.pps_entrega3;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ResultadoController {

    @FXML
    private Text scoreText;
    private String estado;

    public void setScore(int score) {
        estado = calcularEstadoDepresion(score);
        scoreText.setText("Puntaje: " + score + " - Estado: " + estado);
    }

    private String calcularEstadoDepresion(int score) {
        if (score >= 0 && score <= 13) {
            return "Depresión mínima";
        } else if (score >= 14 && score <= 19) {
            return "Depresión moderada";
        } else if (score >= 20 && score <= 28) {
            return "Depresión desesperada";
        } else if (score >= 29 && score <= 63) {
            return "Depresión severa";
        } else {
            return "Puntaje fuera de rango";
        }
    }
}
