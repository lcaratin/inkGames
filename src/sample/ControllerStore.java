package sample;

import DAO.ProdutoDAO;
import VO.ProdutoVO;
import VO.VO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStore implements Initializable {

    private  ControllerMain main;

    @FXML FlowPane fpn_Store;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //try {
            //BuildGames();
        //}
        //catch (IOException erro) {

        //}
    }

    public void init(ControllerMain controllerMain) {

        main = controllerMain;
        System.out.println("Controlador Store");
        System.out.println(main == null);

        try {
        BuildGames();
        }
        catch (IOException erro) {

        }
    }

    public void BuildGames() throws IOException
    {

        ProdutoDAO dao = new ProdutoDAO();
        List<VO> productList = dao.getAll();

        System.out.println(productList.toString());

        for (VO produto:
             productList) {
            System.out.println( ((ProdutoVO)produto).getNome()) ;

            FXMLLoader loadedPane =  new FXMLLoader(getClass().getResource("ComponentStoreGame.fxml"));

            Pane pane = loadedPane.load();
            ControllerStoreGame controller = loadedPane.getController();
            System.out.print("Controlador Store debug main");
            System.out.print(main == null);
            controller.init(main, (ProdutoVO)produto);
            fpn_Store.getChildren().add(pane);
        }
    }

    public void StoreClick(MouseEvent mouseEvent) throws IOException {
        //main.BuildGamePage();
    }
}
