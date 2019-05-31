package VO;

public class ItemPedidoVO extends VO{
	private PedidoVO pedido;
	private ProdutoVO produto;
	
	public ItemPedidoVO(PedidoVO pedido, ProdutoVO produto) {
		super();
		this.pedido = pedido;
		this.produto = produto;
	}
	public PedidoVO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoVO pedido) {
		this.pedido = pedido;
	}
	public ProdutoVO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
	}
}
