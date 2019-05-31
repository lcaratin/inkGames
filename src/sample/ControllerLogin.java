package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.UsuarioPadraoDAO;
import VO.UsuarioPadraoVO;

import DAO.UsuarioCorporativoDAO;
import VO.UsuarioCorporativoVO;

import DAO.UltimoUsuarioConectadoDAO;
import VO.UltimoUsuarioConectadoVO;


import org.w3c.dom.Text;

public class ControllerLogin implements Initializable {

    private UsuarioPadraoDAO usuarioPadraoDAO = new UsuarioPadraoDAO();
    private UsuarioCorporativoDAO usuarioCorporativoDAO = new UsuarioCorporativoDAO();
    private  UltimoUsuarioConectadoDAO ultimoUsuarioConectadoDAO = new UltimoUsuarioConectadoDAO();

    private ControllerHolder holder;

    public TextField txt_NomeEmail;
    public PasswordField txt_Senha;
    public CheckBox cb_LembrarSenha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UltimoUsuarioConectadoVO usuarioLogado = new UltimoUsuarioConectadoVO();
        usuarioLogado = ultimoUsuarioConectadoDAO.pesquisaUltimoUsuario();

        if(usuarioLogado != null) {
            if(usuarioLogado.getSalvarSenha()) {
                try {
                    AutenticaUsuario(usuarioLogado.getLogin(), usuarioLogado.getSenha());
                }
                catch (IOException ex) {
                    System.out.println("não foi possível autenticar");
                }
            }
        }
    }

    public void init(ControllerHolder controllerHolder) {
        holder = controllerHolder;
    }

    public void LoginClick(ActionEvent actionEvent) throws IOException {

        if(txt_NomeEmail.getText().equals("")){
            System.out.println("Usuário inválido");
            return;
        }

        if(txt_Senha.getText().equals("")){
            System.out.println("Senha inválida");
            return;
        }

        AutenticaUsuario (txt_NomeEmail.getText(), txt_Senha.getText());
    }

    public void AutenticaUsuario (String user, String pass) throws IOException  {
        UsuarioPadraoVO usuarioPadraoVO = new UsuarioPadraoVO();
        usuarioPadraoVO = usuarioPadraoDAO.autenticaUsuario(user, pass);

        if(usuarioPadraoVO != null) {
            System.out.println("Login usuário padrão efetuado com sucesso");

            UltimoUsuarioConectadoVO usuarioLogado = new UltimoUsuarioConectadoVO();
            usuarioLogado.setLogin(txt_NomeEmail.getText());
            usuarioLogado.setSenha(txt_Senha.getText());
            usuarioLogado.setSalvarSenha(cb_LembrarSenha.isSelected());
            System.out.println(cb_LembrarSenha.isSelected());

            ultimoUsuarioConectadoDAO.insert(usuarioLogado);

            holder.BuildMain(usuarioPadraoVO);
        }
        else {
            UsuarioCorporativoVO usuarioCorporativoVO = new UsuarioCorporativoVO();
            usuarioCorporativoVO = usuarioCorporativoDAO.autenticaUsuario(user, pass);

            if(usuarioCorporativoVO != null) {
                System.out.println("Login usuário corporativo efetuado com sucesso");

                UltimoUsuarioConectadoVO usuarioLogado = new UltimoUsuarioConectadoVO();
                usuarioLogado.setLogin(txt_NomeEmail.getText());
                usuarioLogado.setSenha(txt_Senha.getText());
                usuarioLogado.setSalvarSenha(cb_LembrarSenha.isSelected());

                ultimoUsuarioConectadoDAO.insert(usuarioLogado);

                holder.BuildMainCompany(usuarioCorporativoVO);
            }
            else {
                txt_NomeEmail.setText("");
                txt_Senha.setText("");
                System.out.println("usuário não encontrado");
            }
        }
    }

    public void SignUpClick(ActionEvent actionEvent) throws IOException {
        holder.BuildSignUp();
    }
}
