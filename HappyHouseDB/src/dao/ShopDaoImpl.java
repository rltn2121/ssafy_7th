package dao;
import java.sql.*;
import java.util.ArrayList;
import connection.DBManager;
import dto.ShopDto;
public class ShopDaoImpl implements ShopDao{

	@Override
	public ShopDto findById(int id) throws SQLException {
		ShopDto dto = null;
		String sql = "select * from shop where shopNo = ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		if(rset.next()) {
			dto = new ShopDto();
			
			dto.setShopNo(rset.getInt("shopNo"));
			dto.setShopName(rset.getString("shopName"));
			dto.setDongCode(rset.getString("dongCode"));
			dto.setDongName(rset.getString("dongName"));
			dto.setRodeAddress(rset.getString("rodeAddress"));
			dto.setLat(rset.getString("lat"));
			dto.setLng(rset.getString("lng"));
		}
		DBManager.releaseConnection(pstmt, con);
		return dto;
	}

	@Override
	public ArrayList<ShopDto> findByShopName(String keyword) throws SQLException {
		ArrayList<ShopDto> list = new ArrayList<>();
		
		String sql = "select * from shop where shopname like ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		while(rset.next()) {
			ShopDto dto = new ShopDto();
		
			dto.setShopNo(rset.getInt("shopNo"));
			dto.setShopName(rset.getString("shopName"));
			dto.setDongCode(rset.getString("dongCode"));
			dto.setDongName(rset.getString("dongName"));
			dto.setRodeAddress(rset.getString("rodeAddress"));
			dto.setLat(rset.getString("lat"));
			dto.setLng(rset.getString("lng"));
			list.add(dto);
		}
		DBManager.releaseConnection(pstmt, con);
		return list;
		
	}

	@Override
	public ArrayList<ShopDto> findByDongCode(String keyword)  throws SQLException {
		ArrayList<ShopDto> list = new ArrayList<>();
		
		String sql = "select * from shop where dongCode like ?";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		while(rset.next()) {
			ShopDto dto = new ShopDto();
		
			dto.setShopNo(rset.getInt("shopNo"));
			dto.setShopName(rset.getString("shopName"));
			dto.setDongCode(rset.getString("dongCode"));
			dto.setDongName(rset.getString("dongName"));
			dto.setRodeAddress(rset.getString("rodeAddress"));
			dto.setLat(rset.getString("lat"));
			dto.setLng(rset.getString("lng"));
			list.add(dto);
		}
		DBManager.releaseConnection(pstmt, con);
		return list;
	}

	@Override
	public ArrayList<ShopDto> findAll() throws SQLException {
		ArrayList<ShopDto> list = new ArrayList<>();
		
		String sql = "select * from shop";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rset = pstmt.executeQuery();	// select: executeQuery(), 나머지: executeUpdate()
		while(rset.next()) {
			ShopDto dto = new ShopDto();
		
			dto.setShopNo(rset.getInt("shopNo"));
			dto.setShopName(rset.getString("shopName"));
			dto.setDongCode(rset.getString("dongCode"));
			dto.setDongName(rset.getString("dongName"));
			dto.setRodeAddress(rset.getString("rodeAddress"));
			dto.setLat(rset.getString("lat"));
			dto.setLng(rset.getString("lng"));
			list.add(dto);
		}
		DBManager.releaseConnection(pstmt, con);
		return list;
	}
}

