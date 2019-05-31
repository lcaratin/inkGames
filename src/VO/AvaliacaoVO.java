package VO;

public class AvaliacaoVO extends VO{
	private String titulo;
	private String comentario;
	private ProdutoVO produto;
	private UsuarioPadraoVO usuario;
	
	public AvaliacaoVO(int id, String titulo, String comentario, ProdutoVO produto, UsuarioPadraoVO usuario) {
		super(id);
		this.titulo = titulo;
		this.comentario = comentario;
		this.produto = produto;
		this.usuario = usuario;
	}

	public AvaliacaoVO(String titulo, String comentario, ProdutoVO produto, UsuarioPadraoVO usuario) {
		this.titulo = titulo;
		this.comentario = comentario;
		this.produto = produto;
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public ProdutoVO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
	}
	public UsuarioPadraoVO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioPadraoVO usuario) {
		this.usuario = usuario;
	}
	
	
}
