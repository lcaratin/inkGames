package DAO;

import java.sql.PreparedStatement;
import java.util.List;

import VO.ItemPedidoVO;
import VO.PedidoVO;
import VO.ProdutoVO;
import VO.VO;

public class PedidoDAO extends DAO{

	@Override
	public void insert(VO vo) {
		// TODO Auto-generated method stub
		PedidoVO pedido = (PedidoVO)vo; 
		try {

			String sql = "INSERT INTO INK.PEDIDO (USUARIO_ID) VALUES(?)";
			
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, pedido.getUsuario().getId());

			preparedStatement.executeUpdate();
			
			for (Integer i = 0; i < pedido.getProdutos().size(); i++) {
				ItemPedidoVO c = pedido.getProdutos().get(i);
				String sqlItem = "INSERT INTO INK.ITEM_PEDIDO (ID_USUARIO, PRODUTO_ID) VALUES(?)";
				
				PreparedStatement preparedStatementItem = this.connection.prepareStatement(sqlItem);
				
				preparedStatement.setInt(1, c.getProduto().getId());
				preparedStatement.setInt(2, c.getPedido().getId());

				preparedStatement.executeUpdate();
			}

		}
		catch(Exception e){
			e.printStackTrace();
		} 
	}

	@Override
	public void update(VO vo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(VO vo) {
		// TODO Auto-generated method stub
		PedidoVO pedido = (PedidoVO)vo;
		String sql = "DELETE FROM INK.PEDIDO WHERE ID = ?";
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, pedido.getId());
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<VO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
