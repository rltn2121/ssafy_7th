package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.NoteBook;
import com.ssafy.dto.UserInfo;

public interface NoteDAO {
	int saveNote(NoteBook noteBook) throws SQLException;
	int removeNote(String noteCode) throws SQLException;
	List<NoteBook> select() throws SQLException;
	NoteBook detail(String noteCode) throws SQLException;
	UserInfo login(String id) throws SQLException;
}
