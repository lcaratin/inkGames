package VO;

public class DesenvolvedoraVO extends VO{
	private String nome;
	private String descricao;
	
	public DesenvolvedoraVO() {}
	
	public DesenvolvedoraVO(int id, String nome, String descricao) {
		super(id);
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
