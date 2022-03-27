package com.ssafy.backend.dao;

import com.ssafy.backend.dto.User;
import java.sql.SQLException;

public interface UserDao {
    /**
     * id에 해당하는 사용자 정보를 반환한다.
     *
     * @param id 조회할 사용자의 id
     * @return 조회된 사용자 정보 객체 User
     * @throws SQLException
     */
    User select(String id) throws SQLException;
}
