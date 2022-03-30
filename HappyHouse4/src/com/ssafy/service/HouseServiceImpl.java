package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dao.HouseDao;
import com.ssafy.dao.HouseDaoImpl;
import com.ssafy.dto.Dong;
import com.ssafy.dto.Gugun;
import com.ssafy.dto.HouseDeal;
import com.ssafy.dto.HouseInfo;

public class HouseServiceImpl implements HouseService{
	private final HouseDao dao = HouseDaoImpl.getInstance();
	
	private HouseServiceImpl() {}
	private static HouseServiceImpl instance = new HouseServiceImpl();
	public static HouseServiceImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public List<Gugun> getGugun(String sido_code) throws SQLException {
		return dao.getGugunList(sido_code);
	}


	@Override
	public List<Dong> getDong(String gugun_code) throws SQLException {
		return dao.getDongList(gugun_code);
	}


	@Override
	public List<HouseDeal> search(String sido_code, String gugun_code, String dong_code) throws SQLException {
		return dao.search(sido_code, gugun_code, dong_code);
	}


	@Override
	public HouseInfo detail(int nO) throws SQLException {
		return dao.detail(nO);
	}

}
