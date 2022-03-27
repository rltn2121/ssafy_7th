package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.backend.dto.User;
import com.ssafy.backend.util.DBUtil;

public class UserDaoImpl implements UserDao{
	private final DBUtil dbUtil = DBUtil.getInstance();
	private UserDaoImpl() {}
	private static UserDaoImpl instance = new UserDaoImpl();
	public static UserDaoImpl getInstance() {
		return instance;
	}
	@Override
	public User select(String id) throws SQLException {
		User user = null;
		String sql = "select * from user where id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setrecId(rs.getString("rec_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, con);
		}
		return user;
	}

}
