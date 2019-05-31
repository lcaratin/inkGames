package sample;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPaymentMethod implements Initializable {

    private ControllerOrder order;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void init(ControllerOrder controllerOrder) {
        order = controllerOrder;
    }

    public void MethodClick(MouseEvent mouseEvent) throws IOException {
        order.BuildReview();
    }
}
