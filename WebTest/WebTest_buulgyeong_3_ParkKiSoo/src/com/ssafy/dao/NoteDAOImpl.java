package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.NoteBook;
import com.ssafy.dto.UserInfo;
import com.ssafy.util.DBUtil;

public class NoteDAOImpl implements NoteDAO{

	private final DBUtil util = DBUtil.getUtil();
	private static NoteDAOImpl instance = new NoteDAOImpl();
	private NoteDAOImpl() {};
	public static NoteDAOImpl getInstance() {
		return instance;
	}
	@Override
	public int saveNote(NoteBook noteBook) throws SQLException{
		int ret = 0;
		System.out.println(noteBook);
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = util.getConnection();
			String sql = "insert into notebook values (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noteBook.getNoteCode());
			pstmt.setString(2, noteBook.getModel());
			pstmt.setInt(3, noteBook.getPrice());
			pstmt.setString(4, noteBook.getCompany());
			ret = pstmt.executeUpdate();
		} finally {
			util.close(pstmt, con);
		}
		
		return ret;
	}
	@Override
	public List<NoteBook> select() throws SQLException {
		List<NoteBook> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = util.getConnection();
			String sql = "select * from notebook";
			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoteBook nb = new NoteBook();
				nb.setNoteCode(rs.getString("noteCode"));
				nb.setModel(rs.getString("model"));
				nb.setPrice(rs.getInt("price"));
				nb.setCompany(rs.getString("company"));
						
				list.add(nb);
			}
		} finally {
			util.close(pstmt, con);
		}
		
		return list;
	}
	@Override
	public NoteBook detail(String noteCode) throws SQLException {
		NoteBook nb = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = util.getConnection();
			String sql = "select * from notebook where noteCode = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noteCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nb = new NoteBook();
				nb.setNoteCode(rs.getString("noteCode"));
				nb.setModel(rs.getString("model"));
				nb.setPrice(rs.getInt("price"));
				nb.setCompany(rs.getString("company"));
			}
		} finally {
			util.close(pstmt, con);
		}
		
		return nb;
	}
	@Override
	public int removeNote(String noteCode) throws SQLException {
		int ret = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = util.getConnection();
			String sql = "delete from notebook where noteCode = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noteCode);
			ret = pstmt.executeUpdate();
		} finally {
			util.close(pstmt, con);
		}
		
		return ret;
	}
	@Override
	public UserInfo login(String id) throws SQLException {
		
		UserInfo user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = util.getConnection();
			String sql = "select * from userinfo where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserInfo();
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
			}
		} finally {
			util.close(pstmt, con);
		}
		
		return user;
	}

}
