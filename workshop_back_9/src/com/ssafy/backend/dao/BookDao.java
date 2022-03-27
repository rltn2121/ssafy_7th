package com.ssafy.backend.dao;

import com.ssafy.backend.dto.Book;
import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    /**
     * Book 정보를 DB에 저장한다.
     *
     * @param book 저장할 Book 정보
     * @return 저장된 책의 개수
     * @throws SQLException
     */
    int insert(Book book) throws SQLException;

    /**
     * 전체 Book의 정보를 List에 담아서 반환한다.
     *
     * @return Book의 리스트
     * @throws SQLException
     */
    List<Book> select() throws SQLException;
}
