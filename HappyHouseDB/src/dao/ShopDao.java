package dao;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ShopDto;

public interface ShopDao {
	public ShopDto findById(int id) throws SQLException;
	public ArrayList<ShopDto> findByShopName(String keyword) throws SQLException;
	public ArrayList<ShopDto> findByDongCode(String keyword) throws SQLException;
	public ArrayList<ShopDto> findAll() throws SQLException;
}

