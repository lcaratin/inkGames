package VO;

public class UsuarioCorporativoVO extends UsuarioVO{
	private String cnpj;

	public  UsuarioCorporativoVO () {

	}

	public UsuarioCorporativoVO(int id, String nome, String login, String senha, String email, String cnpj) {
		super(id, nome, login, senha, email);
		this.cnpj = cnpj;
	}

	public UsuarioCorporativoVO(String nome, String login, String senha, String email, String cnpj) {
		super(nome, login, senha, email);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
