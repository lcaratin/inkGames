package DAO;

import VO.VO;
import VO.DesenvolvedoraVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DesenvolvedoraDAO extends DAO {

    public DesenvolvedoraDAO() {
        super();
    }

    @Override
    public void insert(VO vo) {
        DesenvolvedoraVO desenvolvedora = (DesenvolvedoraVO)vo;
        try {

            String sql = "INSERT INTO INK.DESENVOLVEDORA (NOME,DESCRICAO) VALUES(?,?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, desenvolvedora.getNome());
            preparedStatement.setString(2, desenvolvedora.getDescricao());

            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(VO vo) {
        // TODO Auto-generated method stub
        DesenvolvedoraVO desenvolvedora = (DesenvolvedoraVO)vo;
        try {

            String sql = "UPDATE INK.DESENVOLVEDORA SET NOME = ?, DESCRICAO = ? WHERE ID = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, desenvolvedora.getNome());
            preparedStatement.setString(3, desenvolvedora.getDescricao());

            preparedStatement.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(VO vo) {
        // TODO Auto-generated method stub
        DesenvolvedoraVO desenvolvedora = (DesenvolvedoraVO)vo;
        String sql = "DELETE FROM INK.PRODUTO WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, desenvolvedora.getId());
            preparedStatement.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<VO> getAll() {
        // TODO Auto-generated method stub

        List<VO> developerList = new ArrayList<VO>();

        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM INK.DESENVOLVEDORA");

            while (rs.next()) {

                DesenvolvedoraVO desenvolvedora = new DesenvolvedoraVO(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("DESCRICAO")
                );

                developerList.add(desenvolvedora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developerList;
    }
    public DesenvolvedoraVO pesquisaVO(int id) {
        // TODO Auto-generated method stub
        List<VO> developerList = new ArrayList<VO>();

        try {

            PreparedStatement statement = statement = this.connection.prepareStatement("SELECT * FROM INK.DESENVOLVEDORA WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                DesenvolvedoraVO desenvolvedora = new DesenvolvedoraVO(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("DESCRICAO")
                );
                developerList.add(desenvolvedora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (DesenvolvedoraVO)developerList.remove(0);
    }
}
