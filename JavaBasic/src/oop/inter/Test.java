package oop.inter;

public class Test {
	public static void main(String[] args) {

//		1. 부모 클래스로 참조하면 interface의 메서드 사용 불가
		{
			Animal bird = new Bird();
//			bird.howToFly();
//			bird.howFastFly();
		}
		
//		2. interface로 참조하면 부모 클래스의 메서드 사용 불가
		{
			Fly bird = new Bird();
//			bird.eat();
		}
		
//		우리 팀에서 작성 코드 -> Fly에 대해서는 구현할 필요 없음. 가져다가 쓰기만 하면 됨. 구현 방법 몰라도 됨
		Fly flyObj = getInstance();
		flyObj.howFastFly();
	}
	
//	다른 팀에서 작성한 코드
	static Fly getInstance() {
//		return new Bird();
//		return new Airplane();
		return new Dove();
	}
}
