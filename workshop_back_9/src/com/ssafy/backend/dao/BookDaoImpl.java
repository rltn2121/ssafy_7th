package com.ssafy.backend.dao;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * BookDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
public class BookDaoImpl implements BookDao {
    /**
     * DB 사용을 위해 DBUtil 객체를 가져온다.
     */
    private final DBUtil util = DBUtil.getInstance();

    private static BookDaoImpl instance = new BookDaoImpl();

    private BookDaoImpl() {}

    public static BookDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int insert(Book book) throws SQLException {
        // 처리할 SQL 문장을 작성한다. 파라미터가 들어갈 곳은 ?를 이용해 표시한다.
        String sql = "insert into book values(?, ?, ?, ?, ?, null)";

        // DB 접속에서 사용할 객체들을 선언한다.
        Connection con = null;
        PreparedStatement pstmt = null;

        int result = -1;
        try {
            // DBUtil을 통해 Connection 객체를 가져온다.
            con = util.getConnection();
            // Connection을 통해 PreparedStatement를 가져온다.
            pstmt = con.prepareStatement(sql);
            // sql의 ?에 들어갈 파라미터를 설정한다. index는 1부터 시작함을 주의하자.
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getTitle());
            pstmt.setInt(4, book.getPrice());
            pstmt.setString(5, book.getDesc());
            // PreparedStatement를 실행한다. insert 계열이므로 executeUpdate를 사용한다.
            // 결과로 몇 개의 행이 영향 받았는지가 리턴된다.
            result = pstmt.executeUpdate();
        }
        // 동작의 성공 여부와 상관 없이 사용한 리소스들을 반환한다. 이때 얻은 순의 역순으로 반환해주자.
        finally {
            util.close(pstmt, con);
        }
        return result;
    }

    @Override
    public List<Book> select() throws SQLException {
        // 처리할 SQL 문장을 작성한다. 파라미터가 들어갈 곳은 ?를 이용해 표시한다.
        String sql = "select * from book";

        // DB 접속에서 사용할 객체들을 선언한다.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        List<Book> result = new ArrayList<>();
        try {
            // DBUtil을 통해 Connection 객체를 가져온다.
            con = util.getConnection();
            // Connection을 통해 PreparedStatement를 가져온다.
            pstmt = con.prepareStatement(sql);
            // PreparedStatement를 실행한다. select 계열이므로 executeQuery를 사용한다. 결과로 ResultSet을 얻는다.
            rset = pstmt.executeQuery();
            // 여러 개의 자료가 반환될 수 있으므로 while 문장을 이용한다.
            while (rset.next()) {
                // ResultSet을 통해서 조회 결과를 넘겨받는다.
                // 조회 결과를 이용해 User 객체를 생성하고 list에 담는다.
                Book book = new Book(rset.getString("isbn"),
                        rset.getString("title"),
                        rset.getString("author"),
                        rset.getInt("price"),
                        rset.getString("desc"),
                        rset.getString("img"));
                result.add(book);
            }
        }
        // 동작의 성공 여부와 상관 없이 사용한 리소스들을 반환한다. 이때 얻은 순의 역순으로 반환해주자.
        finally {
            util.close(rset, pstmt, con);
        }
        return result;
    }
}
