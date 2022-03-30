package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.*;

public interface HouseService {
	List<Gugun> getGugun(String sido_code) throws SQLException;
	List<Dong> getDong(String gugun_code) throws SQLException;
	List<HouseDeal> search(String sido_code, String gugun_code, String dong_code) throws SQLException;
	HouseInfo detail(int nO) throws SQLException;
}
