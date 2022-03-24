package design.singleton;

public class Test {

	public static void main(String[] args) {
//		Logger는 여러 개 필요 없음. 하나만 있으면 됨
		Logger logger = Logger.getInstance();
		logger.log("Test Message");

		Logger logger2 = Logger.getInstance();
		
		
		MySingleton mySingleton = MySingleton.getInstance();
		mySingleton.printMyInfo();
	}

}
