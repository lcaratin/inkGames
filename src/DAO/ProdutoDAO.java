package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.VO;
import VO.ProdutoVO;
import VO.UsuarioCorporativoVO;

public class ProdutoDAO extends DAO{

	public ProdutoDAO() {
		super();
	}

	@Override
	public void insert(VO vo) {
		ProdutoVO produto = (ProdutoVO)vo;
		try {

			String sql = "INSERT INTO INK.PRODUTO (NOME,PRECO,CATEGORIA,DESCRICAO,ID_DESENVOLVEDORA) VALUES(?,?,?,?,?)";

			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setFloat(2, produto.getPreco());
			preparedStatement.setString(3, produto.getCategoria());
			preparedStatement.setString(4, produto.getDescricao());
			preparedStatement.setInt(5, produto.getDesenvolvedora().getId());

			preparedStatement.executeUpdate();

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(VO vo) {
		// TODO Auto-generated method stub
		ProdutoVO produto = (ProdutoVO)vo;
		try {

			String sql = "UPDATE INK.PRODUTO SET NOME = ?, PRECO = ?, CATEGORIA = ?, DESCRICAO = ?, DESENVOLVEDORA = ? WHERE ID = ?";

			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setFloat(2, produto.getPreco());
			preparedStatement.setString(3, produto.getCategoria());
			preparedStatement.setString(4, produto.getDescricao());
			preparedStatement.setInt(5, produto.getDesenvolvedora().getId());
			preparedStatement.setInt(6, produto.getId());

			preparedStatement.executeUpdate();

		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void delete(VO vo) {
		// TODO Auto-generated method stub
		ProdutoVO produto = (ProdutoVO)vo;
		String sql = "DELETE FROM INK.PRODUTO WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, produto.getId());
			preparedStatement.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<VO> getAll() {
		// TODO Auto-generated method stub

		List<VO> productList = new ArrayList<VO>();

		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM INK.PRODUTO");

			while (rs.next()) {

				ProdutoVO produto = new ProdutoVO(
						rs.getInt("ID"),
						rs.getString("NOME"),
						rs.getFloat("PRECO"),
						rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"),
						new UsuarioCorporativoVO()
				);

				productList.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return productList;
	}
	public ProdutoVO pesquisaVO(int id) {
		// TODO Auto-generated method stub
		List<VO> developerList = new ArrayList<VO>();
		DesenvolvedoraDAO ds = new DesenvolvedoraDAO();

		try {
			PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.PRODUTO WHERE ID = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ProdutoVO produto = new ProdutoVO(
						rs.getInt("ID"),
						rs.getString("NOME"),
						rs.getFloat("PRECO"),
						rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"),
						new UsuarioCorporativoVO()
				);

				developerList.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (ProdutoVO)developerList.remove(0);
	}
	public List<VO> pesquisaDinamicaVO(String pesquisa) {
		// TODO Auto-generated method stub
		List<VO> developerList = new ArrayList<VO>();
		DesenvolvedoraDAO ds = new DesenvolvedoraDAO();
		pesquisa += "%" ;

		try {
			PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.PRODUTO WHERE NOME LIKE ?");
			statement.setString(1, pesquisa);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ProdutoVO produto = new ProdutoVO(
						rs.getInt("ID"),
						rs.getString("NOME"),
						rs.getFloat("PRECO"),
						rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"),
						new UsuarioCorporativoVO()
				);

				developerList.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return developerList;
	}
}
