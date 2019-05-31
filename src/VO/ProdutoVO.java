package VO;

public class ProdutoVO extends VO{
	private String nome;
	private Float preco;
	private String categoria;
	private String descricao;
	private UsuarioCorporativoVO desenvolvedora;

	public ProdutoVO() {

	}

	public ProdutoVO(int id, String nome, Float preco, String categoria, String descricao, UsuarioCorporativoVO desenvolvedora) {
		super(id);
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.desenvolvedora = desenvolvedora;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UsuarioCorporativoVO getDesenvolvedora() {
		return desenvolvedora;
	}
	public void setDesenvolvedora(UsuarioCorporativoVO desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
}
