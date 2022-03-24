package dao;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.HouseDealDto;
import dto.ShopDto;

public interface HouseDealDao {
	public HouseDealDto findById(int id) throws SQLException;
	public ArrayList<HouseDealDto> findByAptCode(String keyword) throws SQLException;
	public ArrayList<HouseDealDto> findAll() throws SQLException;
}

