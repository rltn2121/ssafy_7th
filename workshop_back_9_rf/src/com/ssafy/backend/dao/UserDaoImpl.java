package com.ssafy.backend.dao;

import com.ssafy.backend.dto.User;
import com.ssafy.backend.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
public class UserDaoImpl implements UserDao {
    /**
     * DB 사용을 위해 DBUtil 객체를 가져온다.
     */
    private final DBUtil util = DBUtil.getInstance();

    private static UserDaoImpl instance = new UserDaoImpl();

    private UserDaoImpl() {}

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public User select(String id) throws SQLException {
        // 처리할 SQL 문장을 작성한다. 파라미터가 들어갈 곳은 ?를 이용해 표시한다.
        String sql = "select * from user where id=?";
        // DB 접속에서 사용할 객체들을 선언한다.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        User user = null;
        try {
            // DBUtil을 통해 Connection 객체를 가져온다.
            con = util.getConnection();
            // Connection을 통해 PreparedStatement를 가져온다.
            pstmt = con.prepareStatement(sql);
            // sql의 ?에 들어갈 파라미터를 설정한다. index는 1부터 시작함을 주의하자.
            pstmt.setString(1, id);
            // PreparedStatement를 실행한다. select 계열이므로 executeQuery를 사용한다. 결과로 ResultSet을 얻는다.
            rset = pstmt.executeQuery();
            // id는 P.K이므로 0 또는 1개의 데이터만 전달된다.
            if (rset.next()) {
                // ResultSet을 통해서 조회 결과를 넘겨받는다.
                String name = rset.getString("name");
                String pass = rset.getString("pass");
                String recId = rset.getString("rec_id");
                // 조회 결과를 이용해 User 객체를 생성한다.
                user = new User(id, name, pass, recId);
            }
        }
        // 동작의 성공 여부와 상관 없이 사용한 리소스들을 반환한다. 이때 얻은 순의 역순으로 반환해주자.
        finally {
            util.close(rset, pstmt, con);
        }
        return user;
    }
}
