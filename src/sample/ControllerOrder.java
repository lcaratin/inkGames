package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOrder implements Initializable {

    private ControllerMain main;

    @FXML BorderPane mainPane;

    @FXML ControllerPaymentMethod controllerPaymentMethod;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            BuildPaymentMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(ControllerMain controllerMain) {
        main = controllerMain;
    }

    void BuildPaymentMethod() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenPaymentMethod.fxml"));
        BorderPane root =  loader.load();
        mainPane.setCenter(root);

        controllerPaymentMethod = loader.getController();
        controllerPaymentMethod.init(this);
    }

    void BuildReview() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenReviewOrder.fxml"));
        BorderPane root =  loader.load();
        mainPane.setCenter(root);
    }

    public void ComfirmOrderClick(MouseEvent mouseEvent) throws IOException {
        main.BuildLibrary();
    }

    public void CancelOrderClick(MouseEvent mouseEvent) throws  IOException {
        //main.BuildGamePage();
    }
}
