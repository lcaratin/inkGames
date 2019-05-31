package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import VO.UsuarioCorporativoVO;

public class ControllerMainCompany implements Initializable {

    private ControllerHolder holder;

    public UsuarioCorporativoVO Usuario = new UsuarioCorporativoVO();

    @FXML ControllerCompanyGames controllerCompanyGames;
    @FXML ControllerPublishGame controllerPublishGame;

    public ScrollPane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            CompanyGamesClick(null);
        } catch (IOException e) {

        }
        mainPane.setVvalue(0);
    }

    public void init(ControllerHolder controllerHolder, UsuarioCorporativoVO usuarioLogado) {
        holder = controllerHolder;
        Usuario = usuarioLogado;
    }

    public void CompanyGamesClick(MouseEvent mouseEvent) throws IOException {
        BuildGamesPage();
    }

    public void PublishGameClick(MouseEvent mouseEvent) throws IOException {
        BuildPublishPage();
    }

    public void ProfileClick(MouseEvent mouseEvent) throws IOException {
        BorderPane root =  FXMLLoader.load(getClass().getResource("ScreenProfileCompany.fxml"));
        mainPane.setContent(root);
        mainPane.setVvalue(0);
    }

    public void LogOutClick(MouseEvent mouseEvent) throws IOException {
        holder.BuildLogin();
    }

    public  void BuildPublishPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenPublishGame.fxml"));
        BorderPane root =  loader.load();
        mainPane.setContent(root);
        mainPane.setVvalue(0);

        controllerPublishGame = loader.getController();
        controllerPublishGame.init(this);
    }

    public  void BuildGamesPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenCompanyGames.fxml"));
        FlowPane root =  loader.load();
        mainPane.setContent(root);
        mainPane.setVvalue(0);

        controllerCompanyGames = loader.getController();
        controllerCompanyGames.init(this);
    }
}
