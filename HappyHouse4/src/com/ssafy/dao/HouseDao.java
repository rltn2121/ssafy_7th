package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.*;

public interface HouseDao {
	List<HouseDeal> search(String sido_code, String gugun_code, String dong_code) throws SQLException;
	List<Sido> getSidoList() throws SQLException;
	List<Gugun> getGugunList(String sido_code) throws SQLException;
	List<Dong> getDongList(String gugun_code) throws SQLException;
	HouseInfo detail(int no) throws SQLException;
}
