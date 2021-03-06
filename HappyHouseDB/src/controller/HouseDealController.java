package controller;

import dao.HouseDealDao;
import dao.HouseDealDaoImpl;
import dao.ShopDao;
import dao.ShopDaoImpl;

public class HouseDealController {
	public static void main(String[] args) throws Exception {
		// Connection 객체 사용
		// JDBC 드라이버를 메모리에 LOAD
		Class.forName("com.mysql.cj.jdbc.Driver");
		HouseDealDao houseDealDao = new HouseDealDaoImpl ();
		
		
		// 거래내역 id로 조회
//		System.out.println("------ 거래내역 id로 조회 ------");
//		System.out.println(houseDealDao.findById(10));

		
		// 아파트 코드로 조회
//		System.out.println("------ 아파트 코드로 조회 ------");
//		houseDealDao.findByAptCode("1").forEach((dto) -> System.out.println(dto));
//		
		// 모든 거래내역 조회
		System.out.println("------ 모든 거래내역 조회 ------");
		houseDealDao.findAll().forEach((dto) -> System.out.println(dto));
	}
}
