package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse_rf?serverTimezone=UTC";
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String ID = "root";
	static final String PASSWORD = "5ab5c87a";

	private static DBUtil util = new DBUtil();
	public static DBUtil getUtil() {
		return util;
	}
	
	private DBUtil(){
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}

	public void close(AutoCloseable... acs) {
		for(AutoCloseable c: acs) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

