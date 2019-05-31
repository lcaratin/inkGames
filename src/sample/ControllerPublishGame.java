package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.ProdutoDAO;
import  VO.ProdutoVO;

public class ControllerPublishGame implements Initializable {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    @FXML ControllerMainCompany main;

    public TextField txt_NomeJogo;
    public TextField txt_Preco;
    public TextField txt_Categoria;
    public TextArea txt_Descricao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void init(ControllerMainCompany controllerMain) {
        main = controllerMain;
    }

    public void PublishClick(MouseEvent mouseEvent) throws IOException {
        if(txt_NomeJogo.getText().equals("")) {
            System.out.println("Nome de jogo inválido");
            return;
        }

        float preco = 0;

        if(txt_Preco.getText().equals("")) {
            System.out.println("Preço inválido");
            return;
        }
        else {
            try {
                preco = Float.parseFloat(txt_Preco.getText());
            }
            catch (Exception ex) {
                txt_Preco.setText("");
                System.out.println("Preço inválido");
                return;
            }
        }

        if(txt_Categoria.getText().equals("")) {
            System.out.println("Categoria inválida");
            return;
        }

        if(txt_Descricao.getText().equals("")) {
            System.out.println("Descrição inválida");
            return;
        }

        try{
            ProdutoVO produtoVO = new ProdutoVO();
            produtoVO.setNome(txt_NomeJogo.getText());
            produtoVO.setPreco(preco);
            produtoVO.setCategoria(txt_Categoria.getText());
            produtoVO.setDescricao(txt_Descricao.getText());
            produtoVO.setDesenvolvedora(main.Usuario);

            produtoDAO.insert(produtoVO);

            System.out.println("Cadastro efetuado com sucesso");

            main.BuildGamesPage();
        }
        catch (Exception ex) {
            System.out.println("Falha no cadastro");
        }
    }
}
