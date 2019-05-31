package DAO;

import VO.VO;
import VO.UltimoUsuarioConectadoVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UltimoUsuarioConectadoDAO extends DAO {

    public UltimoUsuarioConectadoDAO() {
        super();
    }

    @Override
    public void insert(VO vo) {
        UltimoUsuarioConectadoVO usuario = (UltimoUsuarioConectadoVO)vo;
        try {

            String sql = "INSERT INTO INK.ULTIMO_USUARIO_CONECTADO (LOGIN, SENHA, SALVAR_SENHA) VALUES(?,?,?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setBoolean(3, usuario.getSalvarSenha());

            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(VO vo) {
        // TODO Auto-generated method stub
        UltimoUsuarioConectadoVO usuario = (UltimoUsuarioConectadoVO)vo;
        try {

            String sql = "UPDATE INK.ULTIMO_USUARIO_CONECTADO SET LOGIN = ?, SENHA = ?, SALVAR_SENHA = ? WHERE ID = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setBoolean(3, usuario.getSalvarSenha());
            preparedStatement.setInt(4, usuario.getId());

            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(VO vo) {
        // TODO Auto-generated method stub
        UltimoUsuarioConectadoVO usuario = (UltimoUsuarioConectadoVO)vo;
        String sql = "DELETE FROM INK.ULTIMO_USUARIO_CONECTADO WHERE ID = ?";

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
            ResultSet rs = statement.executeQuery("SELECT * FROM INK.ULTIMO_USUARIO_CONECTADO");

            while (rs.next()) {

                UltimoUsuarioConectadoVO usuario = new UltimoUsuarioConectadoVO(
                        rs.getInt("ID"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"),
                        rs.getBoolean("SALVAR_SENHA")
                );

                userList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return userList;
    }
    public UltimoUsuarioConectadoVO pesquisaUltimoUsuario() {
        // TODO Auto-generated method stub
        List<VO> userList = new ArrayList<VO>();

        try {
            PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.ULTIMO_USUARIO_CONECTADO ORDER BY ID DESC LIMIT 1,1");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                UltimoUsuarioConectadoVO usuario = new UltimoUsuarioConectadoVO(
                        rs.getInt("ID"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA"),
                        rs.getBoolean("SALVAR_SENHA")
                );

                userList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (userList.size() != 0) ? (UltimoUsuarioConectadoVO)userList.remove(0) : null;
    }
}
