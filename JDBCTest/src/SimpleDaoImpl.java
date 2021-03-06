import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SimpleDaoImpl implements SimpleDao{
	@Override
	public ArrayList<SimpleDto> findByColNm(String keyword) throws SQLException {
		ArrayList<SimpleDto> list = new ArrayList<>();
		String sql = "select col_id, col_nm, col_not_null, col_default_val from jdbc_table where col_nm like ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		while(rset.next()) {
			SimpleDto dto = new SimpleDto();
		
			dto.setColId(rset.getInt("col_id"));
			dto.setColNm(rset.getString("col_nm"));
			dto.setColNotNull(rset.getString("col_not_null"));
			dto.setColDefaultVal(rset.getString("col_default_val"));
			list.add(dto);
		}
		DBManager.releaseConnection(pstmt, con);
		return list;
	}
	@Override
	public ArrayList<SimpleDto> findAll() throws SQLException {
		ArrayList<SimpleDto> list = new ArrayList<>();
		String sql = "select col_id, col_nm, col_not_null, col_default_val from jdbc_table";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		while(rset.next()) {
			SimpleDto dto = new SimpleDto();
		
			dto.setColId(rset.getInt("col_id"));
			dto.setColNm(rset.getString("col_nm"));
			dto.setColNotNull(rset.getString("col_not_null"));
			dto.setColDefaultVal(rset.getString("col_default_val"));
			list.add(dto);
		}
		DBManager.releaseConnection(pstmt, con);
		return list;
	}
	@Override
	public SimpleDto findById(int col_id) throws SQLException {
		SimpleDto dto = null;
		String sql = "select col_id, col_nm, col_not_null, col_default_val from jdbc_table where col_id = ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, col_id);
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		if(rset.next()) {
			dto = new SimpleDto();
		
			dto.setColId(rset.getInt("col_id"));
			dto.setColNm(rset.getString("col_nm"));
			dto.setColNotNull(rset.getString("col_not_null"));
			dto.setColDefaultVal(rset.getString("col_default_val"));
		}
		DBManager.releaseConnection(pstmt, con);
		return dto;
	}
	@Override
	public int delete(SimpleDto dto) throws SQLException {
		int ret = -1;
		String sql = "delete from jdbc_table where col_id = ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getColId());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}
	@Override
	public int update(SimpleDto dto) throws SQLException {
		int ret = -1;
		String sql = "update jdbc_table set col_nm = ?, col_not_null = ?, col_default_val = ? where col_id=?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getColNm());
		pstmt.setString(2, dto.getColNotNull());
		pstmt.setString(3, dto.getColDefaultVal());
		pstmt.setInt(4, dto.getColId());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}
	@Override
	public int insert(SimpleDto dto) throws SQLException {
		int ret = -1;
		String sql = "insert into jdbc_table (col_nm, col_not_null, col_default_val) values (?, ?, ?)";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getColNm());
		pstmt.setString(2, dto.getColNotNull());
		pstmt.setString(3, dto.getColDefaultVal());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}
	@Override
	public int insertWithoutDefaultValue(SimpleDto dto) throws SQLException {
		int ret = -1;
		String sql = "insert into jdbc_table (col_nm, col_not_null) values (?, ?)";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getColNm());
		pstmt.setString(2, dto.getColNotNull());
//		pstmt.setString(3, dto.getColDefaultVal());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}
	@Override
	public int insertDup(SimpleDto dto) throws SQLException {
		int ret = -1;
		String sql = "insert into jdbc_table (col_id, col_nm, col_not_null, col_default_val) values (?, ?, ?, ?)";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getColId());
		pstmt.setString(2, dto.getColNm());
		pstmt.setString(3, dto.getColNotNull());
		pstmt.setString(4, dto.getColDefaultVal());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		return ret;
	}
	@Override
	public int insert2(SimpleDto dto) throws SQLException {
		int ret = -1;
//		String sql = "insert into jdbc_table (col_nm, col_not_null, col_default_val) values (?, ?, ?)";
		StringBuilder sql = new StringBuilder();
		sql.append("insert into jdbc_table (col_nm, col_not_null, col_default_val) values ('")
		.append(dto.getColNm()).append("', '")
		.append(dto.getColNotNull()).append("', '")
		.append(dto.getColDefaultVal()).append("')");
		
		Connection con = DBManager.getConnection();
		
		Statement stmt = con.createStatement();
		
		ret = stmt.executeUpdate(sql.toString());
		DBManager.releaseConnection(stmt, con);
		return ret;
	}
}

