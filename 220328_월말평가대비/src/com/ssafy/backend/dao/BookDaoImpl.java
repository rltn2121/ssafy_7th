package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.util.DBUtil;

public class BookDaoImpl implements BookDao{
	DBUtil dbUtil = DBUtil.getInstance();
	private BookDaoImpl() {}
	private static BookDaoImpl instance = new BookDaoImpl();
	public static BookDaoImpl getInstance() {
		return instance;
	}
	@Override
	public int insert(Book book) throws SQLException {
		int ret = -1;
		String sql = "insert into book values (?,?,?,?,?, null)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getTitle());
            pstmt.setInt(4, book.getPrice());
            pstmt.setString(5, book.getDesc());
			ret = pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(pstmt, con);
		}
		return ret;
	}

	@Override
	public int delete(String isbn) throws SQLException {
		int ret = -1;
		String sql = "delete from book where isbn = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			ret = pstmt.executeUpdate();
		}
		 finally {
			dbUtil.close(pstmt, con);
		}
		return ret;
	}
	
	@Override
	public List<Book> select() throws SQLException {
		List<Book> books = new ArrayList<>();
		String sql = "select * from book";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setDesc(rs.getString("desc"));
				book.setImg(rs.getString("img"));
				books.add(book);
			}
			
		} finally {
			dbUtil.close(rs, pstmt, con);
		}
		return books;
	}

	@Override
	public Book detail(String isbn) throws SQLException {
		Book book = null;
		String sql = "select * from book where isbn = ?";
		Connection con = dbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = null;
		try {
			con = dbUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setDesc(rs.getString("desc"));
				book.setImg(rs.getString("img"));
			}
			
		} finally {
			dbUtil.close(rs, pstmt, con);
		}
		return book;
	}
}
