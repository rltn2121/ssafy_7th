package dao;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SimpleDto;

public interface SimpleDao {
	public ArrayList<SimpleDto> findByColNm(String keyword) throws SQLException;
	public ArrayList<SimpleDto> findAll() throws SQLException;
	public SimpleDto findById(int col_id) throws SQLException;
	public int delete(SimpleDto dto) throws SQLException;
	public int update(SimpleDto dto) throws SQLException;
	public int insert(SimpleDto dto) throws SQLException;
	public int insertWithoutDefaultValue(SimpleDto dto) throws SQLException;
	public int insertDup(SimpleDto dto) throws SQLException;
	public int insert2(SimpleDto dto) throws SQLException;
}

