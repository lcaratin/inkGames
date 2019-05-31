package DAO;

import VO.VO;
import  VO.UsuarioPadraoVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPadraoDAO extends DAO {

    public UsuarioPadraoDAO() {
        super();
    }

    @Override
    public void insert(VO vo) {
        UsuarioPadraoVO usuario = (UsuarioPadraoVO) vo;
        try {

            String sql = "INSERT INTO INK.USUARIO_PADRAO (NOME,LOGIN,SENHA,EMAIL, SOBRENOME) VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setString(5, usuario.getSobrenome());

            preparedStatement.execute();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(VO vo) {
        // TODO Auto-generated method stub
        UsuarioPadraoVO usuario = (UsuarioPadraoVO) vo;
        try {

            String sql = "UPDATE INK.USUARIO_PADRAO SET NOME = ?, LOGIN = ?, SENHA = ?, EMAIL = ?, SOBRENOME = ? WHERE ID = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setString(5, usuario.getSobrenome());
            preparedStatement.setInt(6, usuario.getId());

            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(VO vo) {
        // TODO Auto-generated method stub
        UsuarioPadraoVO usuario = (UsuarioPadraoVO) vo;
        String sql = "DELETE FROM INK.USUARIO_PADRAO WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, usuario.getId());
            preparedStatement.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<VO> getAll() {
        // TODO Auto-generated method stub

        List<VO> userList = new ArrayList<VO>();

        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM INK.USUARIO_PADRAO");

            while (rs.next()) {

                UsuarioPadraoVO usuario = new UsuarioPadraoVO(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"),
                        rs.getString("EMAIL")
                );

                userList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public UsuarioPadraoVO pesquisaVO(int id) {
        // TODO Auto-generated method stub
        List<VO> developerList = new ArrayList<VO>();

        try {
            PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.USUARIO_PADRAO WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                UsuarioPadraoVO user = new UsuarioPadraoVO(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"),
                        rs.getString("EMAIL")
                );
                developerList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (developerList.size() != 0) ? (UsuarioPadraoVO)developerList.remove(0) : null;
    }

    public UsuarioPadraoVO autenticaUsuario(String login, String senha) {
        // TODO Auto-generated method stub
        List<VO> developerList = new ArrayList<VO>();

        try {
            PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.USUARIO_PADRAO WHERE LOGIN = ? AND SENHA = ?");
            statement.setString(1, login);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                UsuarioPadraoVO user = new UsuarioPadraoVO(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"),
                        rs.getString("EMAIL")
                );
                developerList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return (developerList.size() != 0) ? (UsuarioPadraoVO)developerList.remove(0) : null;
    }

    public UsuarioPadraoVO pesquisaUsuarioPorUsernameOuEmail(String login, String email) {
        // TODO Auto-generated method stub
        List<VO> developerList = new ArrayList<VO>();

        try {
            PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.USUARIO_PADRAO WHERE LOGIN = ? OR EMAIL = ?");
            statement.setString(1, login);
            statement.setString(2, email);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                UsuarioPadraoVO user = new UsuarioPadraoVO(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"),
                        rs.getString("EMAIL")
                );
                developerList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return (developerList.size() != 0) ? (UsuarioPadraoVO)developerList.remove(0) : null;
    }
}
