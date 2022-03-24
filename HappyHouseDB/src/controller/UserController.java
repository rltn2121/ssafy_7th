package controller;

import dao.HouseDealDao;
import dao.HouseDealDaoImpl;
import dao.ShopDao;
import dao.ShopDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.UserDto;

public class UserController {
	public static void main(String[] args) throws Exception {
		// Connection 객체 사용
		// JDBC 드라이버를 메모리에 LOAD
		Class.forName("com.mysql.cj.jdbc.Driver");
		UserDao dao = new UserDaoImpl();
		
		// 회원가입
		UserDto dto = new UserDto("ssafy", "qwer1234", "ssafy@naver.com", "싸피", 7);
		System.out.println(dao.insert(dto));
		
		// 회원조회
		UserDto selectUserDto = dao.detail("ssafy");
		System.out.println(selectUserDto);
		
		// 로그인
		dao.login("ssafy", "qwer12345");
		
		// 회원삭제
		UserDto deleteUserDto = new UserDto("ssafy", "qwer1234", "ssafy@naver.com", "싸피", 7);
		System.out.println(dao.delete(deleteUserDto));
		
		// 회원 업데이트
		UserDto updateUserDto = new UserDto("ssafy", "apple", "apple@naver.com", "아이폰", 10);
		System.out.println(dao.update(updateUserDto));
		
		
		// 관심지역 추가
		dao.favoriteMethod("ssafy", "12345");
	}
}
