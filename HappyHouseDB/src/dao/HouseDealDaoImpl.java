package dao;
import java.sql.*;
import java.util.ArrayList;
import connection.DBManager;
import dto.HouseDealDto;
import dto.ShopDto;
public class HouseDealDaoImpl implements HouseDealDao{

	@Override
	public HouseDealDto findById(int id) throws SQLException {
		HouseDealDto dto = null;
		String sql = "select * from housedeal where no = ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		if(rset.next()) {
			dto = new HouseDealDto();
			
			dto.setNo(rset.getInt("no"));
			dto.setAptCode(rset.getInt("aptCode"));
			dto.setDealAmount(rset.getString("dealAmount"));
			dto.setDealYear(rset.getInt("dealYear"));
			dto.setDealMonth(rset.getInt("dealMonth"));
			dto.setDealDay(rset.getInt("dealDay"));
			dto.setArea(rset.getString("area"));
			dto.setFloor(rset.getString("floor"));
			dto.setType(rset.getString("type"));
			dto.setRentMoney(rset.getString("rentMoney"));
		}
		DBManager.releaseConnection(pstmt, con);
		return dto;
	}

	@Override
	public ArrayList<HouseDealDto> findByAptCode(String keyword) throws SQLException {
		ArrayList<HouseDealDto> list = new ArrayList<>();
		
		String sql = "select * from housedeal where aptCode = ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, keyword);
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		while(rset.next()) {
			HouseDealDto dto = new HouseDealDto();
		
			dto.setNo(rset.getInt("no"));
			dto.setAptCode(rset.getInt("aptCode"));
			dto.setDealAmount(rset.getString("dealAmount"));
			dto.setDealYear(rset.getInt("dealYear"));
			dto.setDealMonth(rset.getInt("dealMonth"));
			dto.setDealDay(rset.getInt("dealDay"));
			dto.setArea(rset.getString("area"));
			dto.setFloor(rset.getString("floor"));
			dto.setType(rset.getString("type"));
			dto.setRentMoney(rset.getString("rentMoney"));
			list.add(dto);
		}
		DBManager.releaseConnection(pstmt, con);
		return list;
	}

	@Override
	public ArrayList<HouseDealDto> findAll() throws SQLException {
		ArrayList<HouseDealDto> list = new ArrayList<>();
		
		String sql = "select * from housedeal";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		while(rset.next()) {
			HouseDealDto dto = new HouseDealDto();
		
			dto.setNo(rset.getInt("no"));
			dto.setAptCode(rset.getInt("aptCode"));
			dto.setDealAmount(rset.getString("dealAmount"));
			dto.setDealYear(rset.getInt("dealYear"));
			dto.setDealMonth(rset.getInt("dealMonth"));
			dto.setDealDay(rset.getInt("dealDay"));
			dto.setArea(rset.getString("area"));
			dto.setFloor(rset.getString("floor"));
			dto.setType(rset.getString("type"));
			dto.setRentMoney(rset.getString("rentMoney"));
			list.add(dto);
		}
		DBManager.releaseConnection(pstmt, con);
		return list;
	}
}

