package sample;

import VO.ProdutoVO;
import VO.UsuarioPadraoVO;
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

public class ControllerMain implements Initializable {

    public enum CurrentScreen {Highlights, Store, Library}

    private  CurrentScreen currentScreen;

    private ControllerHolder holder;
    public static UsuarioPadraoVO usuarioLogado;
    /*@FXML ControllerBannerGame controllerBannerGame;
    @FXML ControllerSaleGame controllerSaleGame;
    @FXML ControllerLibraryGame controllerLibraryGame;
    @FXML ControllerStoreGame controllerStoreGame;*/

    @FXML ControllerStore controllerStore;
    @FXML ControllerGamePage controllerGamePage;
    @FXML ControllerOrder controllerOrder;

    @FXML ScrollPane mainPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            HighlightsClick(null);
        } catch (IOException e) {

        }
        mainPane.setVvalue(0);
    }

    public void init(ControllerHolder controllerHolder, UsuarioPadraoVO usuarioLogado) {
        ControllerMain.usuarioLogado = usuarioLogado;
        holder = controllerHolder;
    }

    public void HighlightsClick(MouseEvent mouseEvent) throws IOException {
        FlowPane root =  FXMLLoader.load(getClass().getResource("ScreenHighlights.fxml"));
        mainPane.setContent(root);
        mainPane.setVvalue(0);

        currentScreen = CurrentScreen.Highlights;
    }

    public void StoreClick(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenStore.fxml"));
        FlowPane root =  loader.load();
        mainPane.setContent(root);
        mainPane.setVvalue(0);
        controllerStore = loader.getController();
        controllerStore.init(this);


        currentScreen = CurrentScreen.Store;
    }

    public void LibraryClick(MouseEvent mouseEvent) throws IOException {
        FlowPane root =  FXMLLoader.load(getClass().getResource("ScreenLibrary.fxml"));
        mainPane.setContent(root);
        mainPane.setVvalue(0);

        currentScreen = CurrentScreen.Library;
    }

    public void ProfileClick(MouseEvent mouseEvent) throws IOException {
        BorderPane root =  FXMLLoader.load(getClass().getResource("ScreenProfile.fxml"));
        mainPane.setContent(root);
        mainPane.setVvalue(0);
    }

    public void LogOutClick(MouseEvent mouseEvent) throws IOException {
        holder.BuildLogin();
    }

    public void BuildGamePage(ProdutoVO produto) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenGamePage.fxml"));
        BorderPane root =  loader.load();
        mainPane.setContent(root);
        mainPane.setVvalue(0);

        controllerGamePage = loader.getController();
        controllerGamePage.init(this, produto);
    }

    public void BuildOrderPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenOrder.fxml"));
        BorderPane root =  loader.load();
        mainPane.setContent(root);
        mainPane.setVvalue(0);

        controllerOrder = loader.getController();
        controllerOrder.init(this);
    }

    public void BuildLibrary() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenLibrary.fxml"));
        FlowPane root =  loader.load();
        mainPane.setContent(root);
        mainPane.setVvalue(0);
    }
}
