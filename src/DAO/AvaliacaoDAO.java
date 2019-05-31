package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.AvaliacaoVO;
import VO.ProdutoVO;
import VO.UsuarioPadraoVO;
import VO.VO;

public class AvaliacaoDAO extends DAO{

	public AvaliacaoDAO() {
		super();
	}

	@Override
	public void insert(VO vo) {
		// TODO Auto-generated method stub		
		try {

			AvaliacaoVO avaliacao = (AvaliacaoVO)vo ;
			System.out.println(avaliacao.getComentario());
			PreparedStatement stmt = connection.prepareStatement("insert into avaliacao(titulo, comentario, id_produto, id_usuario) values(?,?,?,?)");
			
			stmt.setString(1, avaliacao.getTitulo());
			stmt.setString(2, avaliacao.getComentario());
			stmt.setInt(3 ,avaliacao.getProduto().getId());
			stmt.setInt(4, avaliacao.getUsuario().getId());
			
			stmt.execute();
			stmt.close();	

		}
		catch(Exception e){
			e.printStackTrace();
		} 				
	}

	@Override
	public void update(VO vo) {
		// TODO Auto-generated method stub
		AvaliacaoVO avaliacao = (AvaliacaoVO)vo  ;		
		try {

			String sql = "UPDATE INK.avaliacao SET titulo = ?, comentario = ?, id_produto = ? , id_usuario = ? WHERE ID = ?";
			
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, avaliacao.getTitulo());
			preparedStatement.setString(2, avaliacao.getComentario());
			preparedStatement.setInt(3 ,avaliacao.getProduto().getId());
			preparedStatement.setInt(4, avaliacao.getUsuario().getId());
			preparedStatement.setInt(4, avaliacao.getId());

			preparedStatement.executeUpdate();

		}
		catch(Exception e){
			e.printStackTrace();
		} 
	}

	@Override
	public void delete(VO vo) {
		// TODO Auto-generated method stub
		AvaliacaoVO avaliacao = (AvaliacaoVO)vo  ;

		String sql = "DELETE FROM INK.avaliacao WHERE ID = ?";
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, avaliacao.getId());
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
            ResultSet rs = statement.executeQuery("SELECT * FROM INK.avaliacao");
            
            while (rs.next()) {
                
            	AvaliacaoVO avaliacao = new AvaliacaoVO(
            		rs.getInt("ID"),
            		rs.getString("TITULO"),
            		rs.getString("COMENTARIO"),
            		new ProdutoVO(),
            		new UsuarioPadraoVO()         		
            	);

            	productList.add(avaliacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return productList;
	}
	public AvaliacaoVO pesquisaVO(int id) {
		// TODO Auto-generated method stub
		List<VO> developerList = new ArrayList<VO>();
		ProdutoDAO prodDAO = new ProdutoDAO();
		UsuarioPadraoDAO userDAO = new UsuarioPadraoDAO();

		try {
			PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.AVALIACAO WHERE ID_produto = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				AvaliacaoVO avaliacao = new AvaliacaoVO(
						rs.getInt("ID"),
						rs.getString("TITULO"),
						rs.getString("COMENTARIO"),
						prodDAO.pesquisaVO(rs.getInt("ID_PRODUTO")),
						userDAO.pesquisaVO(rs.getInt("ID_USUARIO"))
				);

				developerList.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (AvaliacaoVO)developerList.remove(0);
	}
}
