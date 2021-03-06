import java.util.ArrayList;

public class JDBCClient {
	public static void main(String[] args) throws Exception {
		// Connection 객체 사용
		
		// JDBC 드라이버를 메모리에 LOAD
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		SimpleDao dao = new SimpleDaoImpl();
//		SimpleDto dto = new SimpleDto("홍길동", "not null", "기본값");
//		
//		System.out.println(dao.insert2(dto));
//		
//		SimpleDto dto2 = new SimpleDto(1, "홍길동", "not null", "기본값");
//		System.out.println(dao.insertDup(dto2));
//		
		
//		SimpleDto dto3 = new SimpleDto("홍길동", "not null", "기본값");
//		System.out.println(dao.insertWithoutDefaultValue(dto3));
		
//		SimpleDto dto4 = new SimpleDto(3, "고길동", "not null", "기본값");
//		System.out.println(dao.update(dto4));
//		
//		SimpleDto dto5 = new SimpleDto(3, "고길동", "not null", "기본값");
//		System.out.println(dao.delete(dto4));
//		
//		SimpleDto dto6 = dao.detail(3);
//		System.out.println(dto6);
		// Connection 객체 반납 (종료)
		
//		ArrayList<SimpleDto> list = dao.list();
//		for(SimpleDto dto : list)
//			System.out.println(dto);
//		
		ArrayList<SimpleDto> list2 = dao.findByColNm("길동");
		for(SimpleDto dto : list2)
			System.out.println(dto);
	}
}
