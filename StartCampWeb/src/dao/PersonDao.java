package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.DBManager;
import dto.PersonDto;

public class PersonDao {

	public PersonDto getPerson(int personId) {
		PersonDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		// Statement -> 성능 안좋음
		// String sql = "select * from person where person_id = " + personId;
		
		// 대신 PrepareStatement 사용
		String sql = "select * from person where person_id = ?";
		
		
		try {
			// Tomcat Connection Pool에서 Connection 객체를 받아옴
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, personId);	// 1번째 물음표를  personId로 치환
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new PersonDto();
				dto.setPersonId(rs.getInt("person_id"));
				dto.setPersonNm(rs.getString("person_nm"));
				dto.setPersonAge(rs.getInt("person_age"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// Connection 객체 반납
			DBManager.releaseConnection(rs, pstmt, con);
			
		}
		
		return dto;
		
	}
}
