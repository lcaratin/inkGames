package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCompanyGames implements Initializable {

    private ControllerMainCompany main;

    @FXML FlowPane fpn_CompanyGames;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            BuildGames();
        }
        catch (IOException erro) {

        }
    }

    public void init(ControllerMainCompany controllerMainCompany) {
        main = controllerMainCompany;
    }

    public void BuildGames() throws IOException
    {
        for (int i = 0; i < 9; i++) {
            Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("ComponentCompanyGame.fxml"));
            fpn_CompanyGames.getChildren().add(newLoadedPane);
        }
    }

    public void ComapanyGamesClick(MouseEvent mouseEvent) throws IOException {
        main.BuildPublishPage();
    }
}
