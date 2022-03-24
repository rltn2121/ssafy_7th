package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import board.common.DBManager;
import board.dto.UserDto;

public class UserDaoImpl implements UserDao{
	private UserDaoImpl() {};
	private static UserDaoImpl instance = new UserDaoImpl();
	public static UserDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int register(UserDto dto) {
		int ret = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			String sql = "insert into users (USER_NAME, USER_PASSWORD,USER_EMAIL, USER_REGISTER_DATE) values (?, ?, ?, now());";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getUserPassword());
			pstmt.setString(3, dto.getUserEmail());
			
			ret = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.releaseConnection(pstmt, con);
		}
		return ret;
	}

}
