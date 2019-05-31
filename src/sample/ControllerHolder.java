package sample;

import VO.UsuarioCorporativoVO;
import VO.UsuarioPadraoVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHolder implements Initializable {

    @FXML private BorderPane bdp_Holder;

    @FXML ControllerLogin controllerLogin;
    @FXML ControllerMain controllerMain;
    @FXML ControllerMainCompany controllerMainCompany;
    @FXML ControllerSignUp controllerSignUp;
    @FXML ControllerSignUpCompany controllerSignUpCompany;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            BuildLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BuildLogin() throws IOException {
        bdp_Holder.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenLogin.fxml"));
        BorderPane root =  loader.load();
        bdp_Holder.setCenter(root);

        controllerLogin = loader.getController();
        controllerLogin.init(this);
    }

    public void BuildSignUp() throws IOException {
        bdp_Holder.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenSignUp.fxml"));
        BorderPane root =  loader.load();
        bdp_Holder.setCenter(root);

        controllerSignUp = loader.getController();
        controllerSignUp.init(this);
    }

    public void BuildSignUpCompany() throws IOException {
        bdp_Holder.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenSignUpCompany.fxml"));
        BorderPane root =  loader.load();
        bdp_Holder.setCenter(root);

        controllerSignUpCompany = loader.getController();
        controllerSignUpCompany.init(this);
    }

    public void BuildMain(UsuarioPadraoVO usuarioLogado) throws IOException {
        bdp_Holder.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenMain.fxml"));
        BorderPane root =  loader.load();
        bdp_Holder.setCenter(root);

        controllerMain = loader.getController();
        controllerMain.init(this, usuarioLogado);
    }

    public void BuildMainCompany(UsuarioCorporativoVO usuarioLogado) throws IOException {
        bdp_Holder.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScreenMainCompany.fxml"));
        BorderPane root =  loader.load();
        bdp_Holder.setCenter(root);

        controllerMainCompany = loader.getController();
        controllerMainCompany.init(this, usuarioLogado);
    }
}
