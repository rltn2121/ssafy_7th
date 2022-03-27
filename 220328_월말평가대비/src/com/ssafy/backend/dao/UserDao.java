package com.ssafy.backend.dao;

import java.sql.SQLException;

import com.ssafy.backend.dto.User;

public interface UserDao {
	public User select(String id) throws SQLException;
}
