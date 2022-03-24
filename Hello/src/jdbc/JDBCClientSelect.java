package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCClientSelect {
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
		String sql = "select person_id, person_nm, person_age "
				+ "from person";
		
		// 4. ResultSet: -> Select 결과 반환
		ResultSet rs = stmt.executeQuery(sql);
		
		
		while(rs.next()) {	// 다음 라인 있으면 true 반환
			int person_id = rs.getInt("person_id");
			String person_nm = rs.getString("person_nm");
			int person_age = rs.getInt("person_age");
			
			System.out.println(person_id + " / " + person_nm + " / " + person_age);
		}
		
		rs.close();
		stmt.close();
		con.close();
				
	}
}
