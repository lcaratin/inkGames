package sample;

import DAO.UsuarioCorporativoDAO;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.UsuarioPadraoDAO;
import VO.UsuarioPadraoVO;

public class ControllerSignUp implements Initializable{

    private ControllerHolder holder;

    private UsuarioPadraoDAO usuarioPadraoDAO = new UsuarioPadraoDAO();
    private UsuarioCorporativoDAO usuarioCorporativoDAO = new UsuarioCorporativoDAO();


    public TextField txt_Nome;
    public TextField txt_Sobrenome;
    public TextField txt_Email;
    public PasswordField txt_Senha;
    public PasswordField txt_ConfirmarSenha;
    public TextField txt_Username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void init(ControllerHolder controllerHolder) {
        holder = controllerHolder;
    }

    public void SignUpClick(MouseEvent mouseEvent) throws IOException {

        if(txt_Nome.getText().equals("")){
            System.out.println("Nome inválido");
            return;
        }

        if(txt_Sobrenome.getText().equals("")){
            System.out.println("Sobrenome inválido");
            return;
        }

        if(txt_Email.getText().equals("")){
            System.out.println("Email inválido");
            return;
        }

        if(txt_Username.getText().equals("")){
            System.out.println("Nome de usuário inválido");
            return;
        }

        if(txt_Senha.getText().equals("")){
            System.out.println("Senha inválida");
            return;
        }

        if(txt_ConfirmarSenha.getText().equals("")){
            System.out.println("Senha inválida");
            return;
        }

        if(!txt_Senha.getText().equals(txt_ConfirmarSenha.getText())) {
            txt_ConfirmarSenha.setText("");
            System.out.println("Senhas não coincidem");
            return;
        }

        if(usuarioPadraoDAO.pesquisaUsuarioPorUsernameOuEmail(txt_Username.getText(), txt_Email.getText()) != null) {
            txt_Username.setText("");
            txt_Email.setText("");
            System.out.println("Usuário ou e-mail já existente");
            return;
        }

        if(usuarioCorporativoDAO.pesquisaUsuarioPorEmail(txt_Email.getText()) != null) {
            txt_Email.setText("");
            System.out.println("Este e-mail já está cadastrado em uma conta corporativa");
            return;
        }


        UsuarioPadraoVO usuario = new UsuarioPadraoVO();
        usuario.setNome(txt_Nome.getText());
        usuario.setSobrenome(txt_Sobrenome.getText());
        usuario.setEmail(txt_Email.getText());
        usuario.setLogin(txt_Username.getText());
        usuario.setSenha(txt_Senha.getText());
        usuario.setEmail(txt_Username.getText());

        usuarioPadraoDAO.insert(usuario);

        System.out.println("Cadastro efetuado com sucesso");

        holder.BuildLogin();
    }

    public void SignUpCompanyClick(MouseEvent mouseEvent) throws  IOException {
        holder.BuildSignUpCompany();
    }

    public void BackClick(MouseEvent mouseEvent) throws  IOException {
        holder.BuildLogin();
    }
}
