package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.UsuarioCorporativoVO;
import VO.VO;

public class UsuarioCorporativoDAO extends DAO{

	public UsuarioCorporativoDAO() {
		super();
	}

	@Override
	public void insert(VO vo) {
		// TODO Auto-generated method stub		
		try {

			UsuarioCorporativoVO user = (UsuarioCorporativoVO)vo ;
			PreparedStatement stmt = connection.prepareStatement("insert into usuario_corporativo(nome, login, senha, email, cnpj) values(?,?,?,?,?)");
			
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getCnpj());
			
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
		UsuarioCorporativoVO user = (UsuarioCorporativoVO)vo ;		
		try {

			String sql = "UPDATE usuario_corporativo SET NOME = ?, login = ?, senha = ?, email = ? , cnpj = ? WHERE ID = ?";
			
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getSenha());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getCnpj());
			preparedStatement.setInt(6, user.getId());

			preparedStatement.executeUpdate();

		}
		catch(Exception e){
			e.printStackTrace();
		} 
	}

	@Override
	public void delete(VO vo) {
		// TODO Auto-generated method stub
		UsuarioCorporativoVO user = (UsuarioCorporativoVO)vo ;

		String sql = "DELETE FROM usuario_corporativo WHERE ID = ?";
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, user.getId());
			preparedStatement.execute();
			
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
            ResultSet rs = statement.executeQuery("SELECT * FROM USUARIO_CORPORATIVO");
            
            while (rs.next()) {
                
            	UsuarioCorporativoVO user = new UsuarioCorporativoVO(
            		rs.getInt("ID"),
            		rs.getString("NOME"),
            		rs.getString("LOGIN"),
            		rs.getString("SENHA"),
            		rs.getString("EMAIL"),
            		rs.getString("CNPJ")
            	);

            	productList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return productList;
	}

	public UsuarioCorporativoVO pesquisaVO(int id) {
		// TODO Auto-generated method stub
		List<VO> developerList = new ArrayList<VO>();

		try {
			PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.USUARIO_CORPORATIVO WHERE ID = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				UsuarioCorporativoVO user = new UsuarioCorporativoVO(
						rs.getInt("ID"),
						rs.getString("NOME"),
						rs.getString("LOGIN"),
						rs.getString("SENHA"),
						rs.getString("EMAIL"),
						rs.getString("CNPJ")
				);
				developerList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (developerList.size() != 0) ? (UsuarioCorporativoVO)developerList.remove(0) : null;
	}

	public UsuarioCorporativoVO autenticaUsuario(String email, String senha) {
		// TODO Auto-generated method stub
		List<VO> developerList = new ArrayList<VO>();

		try {
			PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.USUARIO_CORPORATIVO WHERE EMAIL = ? AND SENHA = ?");
			statement.setString(1, email);
			statement.setString(2, senha);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				UsuarioCorporativoVO user = new UsuarioCorporativoVO(
						rs.getInt("ID"),
						rs.getString("NOME"),
						rs.getString("LOGIN"),
						rs.getString("SENHA"),
						rs.getString("EMAIL"),
						rs.getString("CNPJ")
				);
				developerList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return (developerList.size() != 0) ? (UsuarioCorporativoVO)developerList.remove(0) : null;
	}

	public UsuarioCorporativoVO pesquisaUsuarioPorEmail(String email) {
		// TODO Auto-generated method stub
		List<VO> developerList = new ArrayList<VO>();

		try {
			PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.USUARIO_CORPORATIVO WHERE EMAIL = ?");
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				UsuarioCorporativoVO user = new UsuarioCorporativoVO(
						rs.getInt("ID"),
						rs.getString("NOME"),
						rs.getString("LOGIN"),
						rs.getString("SENHA"),
						rs.getString("EMAIL"),
						rs.getString("CNPJ")
				);
				developerList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return (developerList.size() != 0) ? (UsuarioCorporativoVO)developerList.remove(0) : null;
	}
}
