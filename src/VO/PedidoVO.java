package VO;
import java.util.List;
import java.util.ArrayList;;

public class PedidoVO extends VO{
	private UsuarioPadraoVO usuario;
	private List<ItemPedidoVO> produtos;
	
	public PedidoVO(UsuarioPadraoVO usuario, List<ItemPedidoVO> produtos) {
		super();
		this.usuario = usuario;
		this.produtos = produtos;
	}

	public UsuarioPadraoVO getUsuario() {
		return usuario;
	}
	
	public PedidoVO(List<ItemPedidoVO> produtos) {
		super();
		this.produtos = produtos;
	}

	public List<ItemPedidoVO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ItemPedidoVO> produtos) {
		this.produtos = produtos;
	}

}
