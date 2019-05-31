package VO;

public class UsuarioPadraoVO extends UsuarioVO{
	private  String sobrenome;

	public UsuarioPadraoVO() {

	}

	public UsuarioPadraoVO(int id, String nome, String sobrenome, String login, String senha, String email) {
		super(id, nome, login, senha, email);
		this.sobrenome = sobrenome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
