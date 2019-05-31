package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSaleGame implements Initializable {

    @FXML ControllerMain main;

    @FXML public BorderPane bdp_OldPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Text oldPrice = new Text("R$ 100,00");
        oldPrice.setFont(Font.font("Segoe UI", FontWeight.BOLD, FontPosture.REGULAR, 15));
        oldPrice.setStrikethrough(true);
        Color c = Color.web("#5d5d5d");
        oldPrice.setFill(c);
        bdp_OldPrice.setCenter(oldPrice);
    }
}
