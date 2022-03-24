package design.singleton;

import java.time.LocalDateTime;

public class Logger {
//	싱글톤 필요한 경우
//	1. 여러 개의 객체가 필요 없는 경우
//	-	객체를 구별할 필요가 없는 경우 -> 수정 가능한 멤버 변수가 없고 기능만 있는 경우
//	-	이런 객체를 stateless 한 객체라고 한다.
//	ex) 학생 200명은 선생 1명만 있으면 됨. 학생 200명이 모두 new Teacher() 객체를 생성할 필요 없음
//	
//	2. 객체를 계속 생성, 삭제하는데 많은 비용이 들어서 재사용이 유리한 경우

//	싱글톤 클래스
//	1. 생성자를 private으로 만듦
//	2. 자신 타입의 멤버 변수를 static으로 생성
//	3. 외부에서 객체에 접근할 수 있는 getInstance() 제공 (외부에서 객체를 생성하지 않으므로 static으로 선언)
	
	private static Logger logger;
	private Logger() {}

//	getInstance() 제공 방법 3가지
//	방법 1.
	static {
		logger = new Logger();
	}
	
//	방법 2.
//	private static Logger logger = new Logger();

//	방법 3.
	public static Logger getInstance() {
		if(logger == null){
			return new Logger();
		}
		return logger;
	}
	
	
	public void log(String message)	{
		LocalDateTime ldt = LocalDateTime.now();
		String date = ldt.getYear() + " / " + ldt.getMonthValue() + " / " + ldt.getDayOfMonth();
		String time = ldt.getHour()	 + " : " + ldt.getMinute()	+ " : " + ldt.getSecond();
		
		
		System.out.println("[" + date + " " + time + "] " + message);
	}
}
