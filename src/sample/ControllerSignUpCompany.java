package sample;

import DAO.UsuarioCorporativoDAO;
import VO.UsuarioCorporativoVO;
import VO.UsuarioPadraoVO;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSignUpCompany implements Initializable{

    public TextField txtRazao;
    public TextField txtCNPJ;
    public TextField txtEmail;
    public PasswordField txtSenha;
    public PasswordField txtConfirmarSenha;
    private ControllerHolder holder;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void init(ControllerHolder controllerHolder) {
        holder = controllerHolder;
    }

    public void SignUpClick(MouseEvent mouseEvent) throws IOException {
        if(txtRazao.getText().equals("")){
            System.out.println("Razão inválido");
            return;
        }

        if(txtCNPJ.getText().equals("")){
            System.out.println("CNPJ inválido");
            return;
        }

        if(txtEmail.getText().equals("")){
            System.out.println("Email inválido");
            return;
        }

        if(txtSenha.getText().equals("")){
            System.out.println("Senha inválido");
            return;
        }

        if(!txtSenha.getText().equals(txtConfirmarSenha.getText())) {
            System.out.println("Senhas não coincidem");
            return;
        }

        UsuarioCorporativoVO usuario = new UsuarioCorporativoVO(
                txtRazao.getText(),
                txtEmail.getText(),
                txtSenha.getText(),
                txtEmail.getText(),
                txtCNPJ.getText()
        );

        UsuarioCorporativoDAO dao = new UsuarioCorporativoDAO();
        dao.insert(usuario);

        holder.BuildLogin();
    }
}
