package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCClientUpdate {
	public static void main(String[] args) throws Exception {
		// DB 연결 정보
		String url = "jdbc:mysql://localhost:3306/startcamp_db?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String id = "root";
		String pw = "5ab5c87a";

		// 1. JDBC Driver 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. Connection 객체 생성 -> DB 연결
		Connection con = DriverManager.getConnection(url, id, pw);
		System.out.println(con);

		// 3. Statement 객체 생성 -> DB와 대화, 질의 (Query)
		Statement stmt = con.createStatement();
		String sql = "update person set person_age = 20 "
				+ "where person_id = '3'" ;
		int cnt = stmt.executeUpdate(sql);			// update된 row 수 반환		
		System.out.println(cnt);
		
		stmt.close();
		con.close();
				
	}
}
