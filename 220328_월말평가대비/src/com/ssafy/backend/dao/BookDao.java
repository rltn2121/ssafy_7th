package com.ssafy.backend.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dto.Book;

public interface BookDao {

	public int insert(Book book) throws SQLException;
	public List<Book> select() throws SQLException;
	public Book detail(String isbn) throws SQLException;
	public int delete(String isbn) throws SQLException;
}
