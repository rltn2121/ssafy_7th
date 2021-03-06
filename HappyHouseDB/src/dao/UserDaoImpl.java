package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBManager;
import dto.UserDto;

public class UserDaoImpl implements UserDao{
	// 회원가입
	public int insert(UserDto dto) throws SQLException {
		int ret = -1;

		String sql = "insert into user (userId, password, email, name, age) value (?, ?, ?, ?, ?)";
		Connection con = DBManager.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getUserId());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getEmail());
		pstmt.setString(4, dto.getName());
		pstmt.setInt(5, dto.getAge());

		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}

	// 조회
	public UserDto detail(String userId) throws SQLException {
		UserDto dto = null;

		String sql = "select * " + "from user where userId = ? ";
		Connection con = DBManager.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, userId);

		ResultSet rset = pstmt.executeQuery(); // select
		if (rset.next()) {
			dto = new UserDto();
			dto.setNO(rset.getInt("NO"));
			dto.setUserId(rset.getString("userId"));
			dto.setPassword(rset.getString("password"));
			dto.setEmail(rset.getString("email"));
			dto.setName(rset.getString("name"));
			dto.setAge(rset.getInt("age"));
		}
		DBManager.releaseConnection(rset, pstmt, con);
		return dto;
	}

	// 로그인
	public void login(String userId, String password) throws SQLException {
		UserDto dto = null;

		String sql = "select * " + "from user where userId = ? and password = ? ";
		Connection con = DBManager.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, userId);
		pstmt.setString(2, password);

		ResultSet rset = pstmt.executeQuery(); // select
		if (rset.next()) {
			System.out.println("로그인 성공!");
		} else
			System.out.println("로그인 실패!");
		DBManager.releaseConnection(rset, pstmt, con);
	}

	// 회원 탈퇴
	public int delete(UserDto dto) throws SQLException {
		int ret = -1;

		String sql = "delete from user where userId = ?";
		Connection con = DBManager.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getUserId());

		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}


	// 회원 정보 수정
	public int update(UserDto dto) throws SQLException {
		int ret = -1;

		String sql = "update user set password = ?, email = ?, " + "name = ?, age = ? where userId = ? ";
		Connection con = DBManager.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getPassword());
		pstmt.setString(2, dto.getEmail());
		pstmt.setString(3, dto.getName());
		pstmt.setInt(4, dto.getAge());
		pstmt.setString(5, dto.getUserId());

		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}

	// 관심 지역 조회
	// userId, dongCode 확인

	public int favoriteMethod(String userId, String dongCode) throws SQLException {
		int ret = -1;

		String sql = "select * " + "from favorite where userId = ? and dongCode = ? ";
		Connection con = DBManager.getConnection();

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, userId);
		pstmt.setString(2, dongCode);

		ResultSet rset = pstmt.executeQuery(); // select
		if (rset.next()) {
			// 토글
			sql = "update favorite set flag = 1 - flag where userId = ? and dongCode = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, dongCode);

		} else {
			// 추가
			sql = "insert into favorite (userId, dongCode, flag) value (?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, dongCode);
			pstmt.setInt(3, 1);

		}
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(rset, pstmt, con);
		return ret;
	}

}
