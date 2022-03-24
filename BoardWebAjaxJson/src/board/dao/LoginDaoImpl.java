package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import board.common.DBManager;
import board.dto.UserDto;

public class LoginDaoImpl implements LoginDao{
	private LoginDaoImpl() {};
	private static LoginDaoImpl instance = new LoginDaoImpl();
	public static LoginDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public UserDto login(String userEmail) {
		UserDto userDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			String sql = "select user_seq, user_name, user_password, user_email, user_profile_image_url, user_register_date from users where user_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userEmail);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userDto = new UserDto();
				userDto.setUserSeq(rs.getInt("user_seq"));
				userDto.setUserName(rs.getString("user_name"));
				userDto.setUserPassword(rs.getString("user_password"));
				userDto.setUserEmail(rs.getString("user_email"));
				userDto.setUserProfileImageUrl(rs.getString("user_profile_image_url"));
				userDto.setUserRegisterDate(rs.getDate("user_register_date"));
			}
		} catch(Exception e) {
			
		}
		finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		return userDto;
	}

}
