package VO;

public class UltimoUsuarioConectadoVO extends VO{
    private String login;
    private String senha;
    private Boolean salvarSenha;

    public UltimoUsuarioConectadoVO() {
    }

    public UltimoUsuarioConectadoVO(int id, String login, String senha, Boolean salvarSenha) {
        super(id);
        this.login = login;
        this.senha = senha;
        this.salvarSenha = salvarSenha;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Boolean getSalvarSenha() {
        return salvarSenha;
    }
    public void setSalvarSenha(Boolean salvarSenha) {
        this.salvarSenha = salvarSenha;
    }
}