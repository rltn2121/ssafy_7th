package controller;

import dao.ShopDao;
import dao.ShopDaoImpl;

public class ShopController {
	public static void main(String[] args) throws Exception {
		// Connection 객체 사용
		// JDBC 드라이버를 메모리에 LOAD
		Class.forName("com.mysql.cj.jdbc.Driver");
		ShopDao shopDao = new ShopDaoImpl();
		
		
//		// 상점 id로 조회
//		System.out.println("------ 상점 id로 조회 ------");
//		System.out.println(shopDao.findById(2917696));

//		// 상점 이름으로 조회
//		System.out.println("------ 상점 이름으로 조회 ------");
//		shopDao.findByShopName("CU").forEach((dto) -> System.out.println(dto));
//		
//		// 상점의 동 코드로 조회
//		System.out.println("------ 상점의 동 코드로 조회 ------");
//		shopDao.findByDongCode("1165062000").forEach((dto) -> System.out.println(dto));
//		
		// 모든 상점 조회
		System.out.println("------ 모든 상점 조회 ------");
		shopDao.findAll().forEach((dto) -> System.out.println(dto));
	}
}
