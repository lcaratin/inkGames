package sample;

import VO.ProdutoVO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStoreGame implements Initializable {

    public ProdutoVO produto;
    public Label txt_Preco;
    public Label txt_Nome;
    public Label txt_Desc;
    public @FXML ControllerMain main;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void init(ControllerMain controllerMain, ProdutoVO produto) {
        this.main = controllerMain;
        this.produto = produto;

        this.txt_Preco.setText("R$ " + produto.getPreco().toString());
        this.txt_Nome.setText(produto.getNome());
        this.txt_Desc.setText(produto.getDescricao());
    }

    public void ComponentClick(MouseEvent mouseEvent) throws IOException {
        System.out.println("teste x");
        System.out.println(this.produto.getNome());
        System.out.println("teste x");
        System.out.println(this.main == null);
        this.main.BuildGamePage(this.produto);
    }
}
