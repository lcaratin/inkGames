package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Util.DbUtil;
import VO.VO;

public abstract class DAO {
	protected Connection connection;
	
	public DAO() {
		try {
			this.connection = DbUtil.getConnection();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public abstract void insert(VO vo);
	public abstract void update(VO vo);
	public abstract void delete(VO vo);
	public abstract List<VO> getAll();
}
