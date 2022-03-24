package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDto;

public interface UserDao {
	// 회원가입
		public int insert(UserDto dto) throws SQLException;

		// 조회
		public UserDto detail(String userId) throws SQLException;

		// 로그인
		public void login(String userId, String password) throws SQLException;

		// 회원 탈퇴
		public int delete(UserDto dto) throws SQLException;


		// 회원 정보 수정
		public int update(UserDto dto) throws SQLException;

		public int favoriteMethod(String userId, String dongCode) throws SQLException;
}
