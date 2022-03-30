package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Sido;
import com.ssafy.dto.Dong;
import com.ssafy.dto.HouseInfo;
import com.ssafy.dto.Gugun;
import com.ssafy.dto.HouseDeal;
import com.ssafy.util.DBUtil;

public class HouseDaoImpl implements HouseDao{
	private final DBUtil util = DBUtil.getUtil();
	private HouseDaoImpl() {}
	private static HouseDaoImpl instance = new HouseDaoImpl();
	public static HouseDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Sido> getSidoList() throws SQLException {
		List<Sido> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from sido_code";
			con = util.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sido sido = new Sido(
						rs.getString("code"),
						rs.getString("name")
				);
				list.add(sido);
			}
		}
		finally {
			util.close(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public List<Gugun> getGugunList(String sido_code) throws SQLException {
		List<Gugun> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from gugun_code where sido_code = ?";
			con = util.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, sido_code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Gugun gugun = new Gugun(
						rs.getString("code"),
						rs.getString("name"),
						rs.getString("sido_code")
				);
				list.add(gugun);
			}
		}
		finally {
			util.close(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public List<Dong> getDongList(String gugun_code) throws SQLException {
		
		List<Dong> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from dong_code where gugun_code = ?";
			con = util.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, gugun_code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Dong dong = new Dong(
						rs.getString("code"),
						rs.getString("name"),
						rs.getString("city_code"),
						rs.getString("city_name"),
						rs.getString("gugun_code"),
						rs.getString("gugun_name")
						
				);
				list.add(dong);
			}
		}
		finally {
			util.close(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public List<HouseDeal> search(String sido_code, String gugun_code, String dong_code) throws SQLException {
		List<HouseDeal> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from housedeal where code = ?";
			con = util.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, gugun_code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseDeal houseDeal = new HouseDeal(
						rs.getInt("no"),
						rs.getString("aptName"),
						rs.getString("dealAmount"),
						rs.getString("area")
						
				);
				list.add(houseDeal);
			}
		}
		finally {
			util.close(rs, pstmt, con);
		}
		
		return list;
	}

	@Override
	   public HouseInfo detail(int no) throws SQLException {
	      
	      HouseInfo house=null;
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         String sql = "select * from houseinfo where no = ?";
	         con = util.getConnection();
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, no);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            house = new HouseInfo(
	                  rs.getInt("no"), 
	                  rs.getString("dong"), 
	                  rs.getString("aptName"), 
	                  rs.getString("buildYear")
	            );
	         }
	      }
	      finally {
	         util.close(rs, pstmt, con);
	      }      
	      
	      return house;
	   }
}
