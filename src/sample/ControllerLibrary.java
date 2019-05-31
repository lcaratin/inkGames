package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLibrary implements Initializable {

    @FXML FlowPane fpn_Library;

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
        for (int i = 0; i < 9; i++) {
            Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("ComponentLibraryGame.fxml"));
            fpn_Library.getChildren().add(newLoadedPane);
        }
    }
}
