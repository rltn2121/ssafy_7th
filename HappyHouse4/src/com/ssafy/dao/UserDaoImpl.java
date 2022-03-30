package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.dto.UserDto;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao{
	
	private final DBUtil util = DBUtil.getUtil();
	
	private static UserDaoImpl instance = new UserDaoImpl();
	
	private UserDaoImpl() {}

	public static UserDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int register(UserDto userDto) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int ret = -1;
		
		try {
			con = util.getConnection();
			String sql = 
					"INSERT INTO member_info " + 
					" (Member_id, Member_pwd, Member_nm, Member_add, Member_tell) " + 
					" VALUES ( ?, ?, ?, ?, ? ) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userDto.getMember_id());
			pstmt.setString(2,  userDto.getMember_pwd());
			pstmt.setString(3,  userDto.getMember_nm());
			pstmt.setString(4,  userDto.getMember_add());
			pstmt.setString(5,  userDto.getMember_tell());

			ret = pstmt.executeUpdate();

		}catch(Exception e) {			
			e.printStackTrace();
		}finally {
			util.close(rs, pstmt, con);
		}
		
		return ret;
	}

	@Override
	public UserDto login(String Member_id) {
		
		UserDto user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;
		
		try {
			con = util.getConnection();
			String sql = "SELECT * FROM member_info where Member_id= ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  Member_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
                // ResultSet을 통해서 조회 결과를 넘겨받는다.
                String id = rs.getString("Member_id");
                String pwd = rs.getString("Member_pwd");
                String nm = rs.getString("Member_nm");
                String add = rs.getString("Member_add");
                String tell = rs.getString("Member_tell");
                // 조회 결과를 이용해 User 객체를 생성한다.
                user = new UserDto(id, pwd, nm, add, tell);
            }

		}catch(Exception e) {			
			e.printStackTrace();
		}finally {
			util.close(rs, pstmt, con);
		}
		
		return user;
	}
	public int remove(String Member_id) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      int ret = -1;
	      
	      try {
	         con = util.getConnection();
	         String sql = "delete from member_info where Member_id = ?;";
	         
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1,  Member_id);

	         ret = pstmt.executeUpdate();

	      }catch(Exception e) {         
	         e.printStackTrace();
	      }finally {
	         util.close(rs, pstmt, con);
	      }
	      
	      return ret;
	   }

	@Override
	   public UserDto view(String Member_id) {
	      
	      UserDto user = null;
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         con = util.getConnection();
	         String sql = "SELECT * FROM member_info where Member_id= ? ";
	         
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1,  Member_id);
	         
	         rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	                // ResultSet을 통해서 조회 결과를 넘겨받는다.
	                String id = rs.getString("Member_id");
	                String pwd = rs.getString("Member_pwd");
	                String nm = rs.getString("Member_nm");
	                String add = rs.getString("Member_add");
	                String tell = rs.getString("Member_tell");
	                // 조회 결과를 이용해 User 객체를 생성한다.
	                user = new UserDto(id, pwd, nm, add, tell);
	            }

	      }catch(Exception e) {         
	         e.printStackTrace();
	      }finally {
	         util.close(rs, pstmt, con);
	      }
	      
	      return user;
	   }

	@Override
	   public int edit(String Member_id, String pwd, String name, String address, String tell) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      int ret = -1;
	      
	      try {
	         con = util.getConnection();
	         String sql = "update member_info "
	               + " set member_pwd= ?, member_nm = ?, member_add = ?, member_tell = ? "
	               + " where member_id = ?;";
	         
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1,  pwd);
	         pstmt.setString(2,  name);
	         pstmt.setString(3,  address);
	         pstmt.setString(4,  tell);
	         pstmt.setString(5,  Member_id);

	         ret = pstmt.executeUpdate();

	      }catch(Exception e) {         
	         e.printStackTrace();
	      }finally {
	         util.close(rs, pstmt, con);
	      }
	      
	      return ret;
	   }
}
