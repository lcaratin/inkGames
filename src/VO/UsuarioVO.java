package VO;

public abstract class UsuarioVO extends VO{
	private String nome;
	private String login;
	private String senha;

	public UsuarioVO() {
	}

	public UsuarioVO(int id, String nome, String login, String senha, String email) {
		super(id);
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public UsuarioVO(String nome, String login, String senha, String email) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
}
