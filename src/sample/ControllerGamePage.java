package sample;

import DAO.AvaliacaoDAO;
import VO.AvaliacaoVO;
import VO.ProdutoVO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGamePage implements Initializable {

    public Label txt_Preco;
    public Label txt_Nome;
    public Label txt_Desc;
    public Button btn_Comentario;
    public TextField txt_Comentario;
    public ProdutoVO produto;
    public Label txt_ComentarioBanco;
    @FXML ControllerMain main;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void init(ControllerMain controllerMain, ProdutoVO produto) {
        main = controllerMain;
        txt_Desc.setText(produto.getDescricao());
        txt_Nome.setText(produto.getNome());
        txt_Preco.setText("Comprar: R$ " + produto.getPreco().toString());
        this.produto = produto;

        AvaliacaoDAO dao = new AvaliacaoDAO();
        if (dao.getAll().size() > 0){

            AvaliacaoVO aval = (AvaliacaoVO)dao.getAll().remove(0);
            txt_ComentarioBanco.setText(aval.getComentario());
        }
    }

    public void OrderGameClick(MouseEvent mouseEvent) throws IOException {
        main.BuildOrderPage();
    }

    public void AvalClick(MouseEvent mouseEvent) throws IOException{
        AvaliacaoVO avalicao = new AvaliacaoVO(
                "Comentário",
                txt_Comentario.getText(),
                this.produto,
                ControllerMain.usuarioLogado
        );
        AvaliacaoDAO dao = new AvaliacaoDAO();
        dao.insert(avalicao);
    }
}
