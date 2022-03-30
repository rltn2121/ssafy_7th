package com.ssafy.guestbook.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.ListParameterDto;

public interface GuestBookDao {

	void registerArticle(GuestBookDto guestBookDto) throws SQLException;
	List<GuestBookDto> listArticle(ListParameterDto listParameterDto) throws SQLException;
	int getTotalCount(ListParameterDto listParameterDto) throws SQLException;
	
	GuestBookDto getArticle(int articleNo) throws SQLException;
	void updateArticle(GuestBookDto guestBookDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
}