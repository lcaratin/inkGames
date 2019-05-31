package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHighlights implements Initializable {

    @FXML FlowPane fpn_Highlights;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            BuildGames();
        }
        catch (IOException erro) {

        }
    }

    public void BuildGames() throws IOException
    {
        Pane banner =  FXMLLoader.load(getClass().getResource("ComponentBannerGame.fxml"));
        fpn_Highlights.getChildren().add(banner);
        for (int i = 0; i < 4; i++) {
            Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("ComponentSaleGame.fxml"));
            fpn_Highlights.getChildren().add(newLoadedPane);
        }
    }
}
