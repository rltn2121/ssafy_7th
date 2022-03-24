package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	private static String url = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static String user = "root";
	private static String pw = "5ab5c87a";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pw);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void releaseConnection(PreparedStatement pstmt, Connection con) {
		try {
			if(pstmt != null)	pstmt.close();
			if(con != null)		con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void releaseConnection(Statement stmt, Connection con) {
		try {
			if(stmt != null)	stmt.close();
			if(con != null)		con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if(rs != null) 		rs.close();
			if(pstmt != null)	pstmt.close();
			if(con != null)		con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}